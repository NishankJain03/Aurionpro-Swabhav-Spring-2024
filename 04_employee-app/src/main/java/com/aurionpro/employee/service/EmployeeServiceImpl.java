package com.aurionpro.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.employee.entity.Employee;
import com.aurionpro.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.getAllEmployee();
	}

	@Override
	public Employee insertEmployeeData(Employee employee) {
		return employeeRepository.insertEmployeeData(employee);
		
	}
	
}
