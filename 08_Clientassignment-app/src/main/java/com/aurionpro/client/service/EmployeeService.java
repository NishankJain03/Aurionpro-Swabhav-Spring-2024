package com.aurionpro.client.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.aurionpro.client.entity.Employee;

public interface EmployeeService {
	Page<Employee> getEmployeePagination(int pageNumber, int pageSize);
	List<Employee> getAllEmployee();
	void addEmployee(Employee employee);
	void updateEmployee(Employee employee);
	void deleteEmployee(Employee employee);
	
}
