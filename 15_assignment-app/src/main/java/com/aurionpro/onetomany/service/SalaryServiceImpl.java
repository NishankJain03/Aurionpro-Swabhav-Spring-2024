package com.aurionpro.onetomany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.onetomany.dto.SalaryDto;
import com.aurionpro.onetomany.entity.Salary;
import com.aurionpro.onetomany.repository.SalaryRespository;

@Service
public class SalaryServiceImpl implements SalaryService{

	@Autowired
	private SalaryRespository salaryRespository;
	@Override
	public Salary addSalary(Salary salary) {
		
		return salaryRespository.save(salary);
	}
	@Override
	public Salary updateSalary(int salaryId, SalaryDto salaryDto) {
		Optional<Salary> optionalSalary = salaryRespository.findById(salaryId);
        if (!optionalSalary.isPresent()) {
            return null; 
        }
        Salary salary = optionalSalary.get();
        if (salaryDto.getSalaryMonth() != null && !salaryDto.getSalaryMonth().isEmpty()) {
            salary.setSalaryMonth(salaryDto.getSalaryMonth());
        }

        if (salaryDto.getGrossSalary() != 0) {
            salary.setGrossSalary(salaryDto.getGrossSalary());
        }

        if (salaryDto.getDeductions() != 0) {
            salary.setDeductions(salaryDto.getDeductions());
        }

        if (salaryDto.getNetSalary() != 0) {
            salary.setNetSalary(salaryDto.getNetSalary());
        }

        if (salaryDto.getPaymentDate() != null) {
            salary.setPaymentDate(salaryDto.getPaymentDate());
        }

        if (salaryDto.getSalaryStatus() != null) {
            salary.setSalaryStatus(salaryDto.getSalaryStatus());
        }
        return salaryRespository.save(salary);
	}
	@Override
	public List<Salary> getAllSalary() {
		return salaryRespository.findAll();
	}

}
