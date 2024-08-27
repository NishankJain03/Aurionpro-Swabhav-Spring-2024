package com.aurionpro.employee.service;

import java.util.List;

import com.aurionpro.employee.entity.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployee();
	Employee insertEmployeeData(Employee employee);
}
