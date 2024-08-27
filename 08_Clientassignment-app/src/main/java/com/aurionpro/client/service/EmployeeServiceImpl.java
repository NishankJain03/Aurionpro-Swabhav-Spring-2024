package com.aurionpro.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aurionpro.client.entity.Employee;
import com.aurionpro.client.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Page<Employee> getEmployeePagination(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Employee> employeePage = employeeRepository.findAll(pageable);
		return employeePage;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		if(employeeRepository.existsById(employee.getEmployeeId()))
			employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		if(employeeRepository.existsById(employee.getEmployeeId()))
			employeeRepository.delete(employee);
	}
	
}
