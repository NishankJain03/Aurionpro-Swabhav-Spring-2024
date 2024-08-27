package com.aurionpro.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.assignment.entity.Employee;
import com.aurionpro.assignment.entity.SalaryAccount;
import com.aurionpro.assignment.service.EmployeeService;
@RestController
@RequestMapping("/employeeapp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employee")
	public String addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		return "Employee Added successfully";
	}
	
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		return ResponseEntity.ok(employeeService.getAllEmployee());
	}
	
	@GetMapping("/employees/salaryaccount")
	public ResponseEntity<SalaryAccount> getSalaryAccountByEmployeeId(@RequestParam int employeeId)
	{
		return ResponseEntity.ok(employeeService.getSalaryAccountByEmployeeId(employeeId));
	}
	
	@PutMapping("/update")
	public String updateEmployee(@RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
		return "Updated Successfully";
	}
	
	@DeleteMapping("/delete")
	public String deleteEmployee(@RequestParam int employeeId) {
		employeeService.deleteEmployee(employeeId);
		return "Deleted Successfully";
	}
}
