package com.aurionpro.onetomany.service;

import java.util.List;

import com.aurionpro.onetomany.dto.EmployeeDto;
import com.aurionpro.onetomany.entity.Client;
import com.aurionpro.onetomany.entity.Employee;

public interface EmployeeService {
	Employee addEmployee(Employee employee);
	
	Employee addClients(int employeeId, Client client);
	Employee updateEmployee(EmployeeDto employeeDto);
	List<Employee> getAllEmployee();
}
