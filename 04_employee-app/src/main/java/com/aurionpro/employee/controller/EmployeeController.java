package com.aurionpro.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.employee.entity.Employee;
import com.aurionpro.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/EmployeesApp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		return ResponseEntity.ok(employeeService.getAllEmployee());
	}
	
	@PostMapping("/employees")
    public String insertEmployeeData(@RequestBody Employee employee) {
        	employeeService.insertEmployeeData(employee);
        	return "Record added successfully";
    }
	
}
