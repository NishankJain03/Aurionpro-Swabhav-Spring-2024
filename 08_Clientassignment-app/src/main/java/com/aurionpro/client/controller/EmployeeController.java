package com.aurionpro.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.client.entity.Employee;
import com.aurionpro.client.service.EmployeeService;

@RestController
@RequestMapping("/employeeapp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public Page<Employee> getEmployeePagination(@RequestParam int pageNumber, @RequestParam int pageSize){
		return employeeService.getEmployeePagination(pageNumber, pageSize);
	}
	
	@GetMapping("/employeedetails")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		return ResponseEntity.ok(employeeService.getAllEmployee());
	}
	
	@PutMapping("/update")
	public String updateEmployee(@RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
		return "Updated Successfully";
	}
	
	@PostMapping("/employee")
	public String addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		return "Added successfully";
	}
	
	@DeleteMapping("/delete")
	public String deleteEmployee(@RequestBody Employee employee) {
		employeeService.deleteEmployee(employee);
		return "Delete Successfully";
	}
}
