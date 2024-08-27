package com.aurionpro.onetomany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.onetomany.dto.EmployeeDto;
import com.aurionpro.onetomany.entity.Client;
import com.aurionpro.onetomany.entity.Employee;
import com.aurionpro.onetomany.service.EmployeeService;

@RestController
@RequestMapping("/bankapp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		return ResponseEntity.ok(employeeService.addEmployee(employee));
	}
	
	@PutMapping("/employee/client")
	public ResponseEntity<Employee> addClients(@RequestParam int employeeId, @RequestBody Client client){
		return ResponseEntity.ok(employeeService.addClients(employeeId, client));
	}
	
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody EmployeeDto employeeDto){
		employeeDto.setEmployeeId(id);
		return ResponseEntity.ok(employeeService.updateEmployee(employeeDto));
	}
	
	@GetMapping("/getAllEmployee")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		return ResponseEntity.ok(employeeService.getAllEmployee());
	}
}

