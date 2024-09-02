package com.aurionpro.batch.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.aurionpro.batch.entity.Employee;

@Configuration
public class EmployeeBatchConfig {
	
	@Bean
	public FlatFileItemReader<Employee> readEmployeeCsv(){
		FlatFileItemReader<Employee> flatFileItemReader = new FlatFileItemReader<>();
		flatFileItemReader.setResource(new ClassPathResource("data.csv"));
		flatFileItemReader.setName("employeeCsvReader");
		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setLineMapper(lineMapper());
		return flatFileItemReader;
	}
	
	private LineMapper<Employee> lineMapper(){
		DefaultLineMapper<Employee> defaultLineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames("employeeId", "name", "salary");
		
		BeanWrapperFieldSetMapper<Employee> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
		beanWrapperFieldSetMapper.setTargetType(Employee.class);
		
		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
		return defaultLineMapper;
	}
	
	@Bean
	public EmployeeProcessor employeeProcessor() {
		return new EmployeeProcessor();
	}
	
	@Bean
	public JdbcBatchItemWriter<Employee> batchItemWriter(DataSource datasource){
		return new JdbcBatchItemWriterBuilder<Employee>()
		.sql("INSERT INTO employees (employee_id,name,salary) VALUES (:employeeId, :name, :salary)")
		.dataSource(datasource)
		.beanMapped()
		.build();
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager(DataSource data) {
		return new DataSourceTransactionManager(data);
	}
	
	@Bean
	public Step step1(JobRepository jobRepository, DataSourceTransactionManager transactionManager, 
			FlatFileItemReader<Employee> reader, EmployeeProcessor processor, JdbcBatchItemWriter<Employee> writer) {
		return new StepBuilder("importcsvstep", jobRepository).<Employee, Employee>chunk(2,transactionManager)
				.reader(reader).processor(processor).writer(writer).build();
	}
	
	@Bean
	public Job importUserJob(JobRepository jobRepository, Step step1, JobCompletionNotificationListener completionNotificationListener) {
		return new JobBuilder("importUserJob", jobRepository).listener(completionNotificationListener).start(step1).build();
	}
}
