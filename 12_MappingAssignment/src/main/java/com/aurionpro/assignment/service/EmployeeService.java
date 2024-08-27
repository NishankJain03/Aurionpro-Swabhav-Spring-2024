package com.aurionpro.assignment.service;

import java.util.List;

import com.aurionpro.assignment.entity.Employee;
import com.aurionpro.assignment.entity.SalaryAccount;

public interface EmployeeService {
	Employee addEmployee(Employee employee);
	List<Employee> getAllEmployee();
	SalaryAccount getSalaryAccountByEmployeeId(int employeeId);
	Employee updateEmployee(Employee employee);
	void deleteEmployee(int employeeId);
}
