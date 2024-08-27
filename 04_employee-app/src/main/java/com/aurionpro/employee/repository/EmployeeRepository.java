package com.aurionpro.employee.repository;

import java.util.List;

import com.aurionpro.employee.entity.Employee;

public interface EmployeeRepository {
	List<Employee> getAllEmployee();
	Employee insertEmployeeData(Employee employee);
}
