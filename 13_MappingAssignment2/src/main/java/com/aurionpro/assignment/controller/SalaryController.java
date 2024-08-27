package com.aurionpro.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.assignment.entity.Salary;
import com.aurionpro.assignment.entity.Transaction;
import com.aurionpro.assignment.service.SalaryService;

@RestController
@RequestMapping("/salaryapp")
public class SalaryController {
	
	@Autowired
	private SalaryService salaryService;
	
	@PostMapping("/add")
	public String addSalary(@RequestBody Salary salary) {
		salaryService.addSalary(salary);
		return "Added successfully";
	}
	
	@GetMapping("/salary")
	public ResponseEntity<List<Salary>> getAllSalary(){
		return ResponseEntity.ok(salaryService.getAllSalary());
	}
	
	@GetMapping("/transaction")
	public ResponseEntity<Transaction> getTransaction(@RequestParam int salaryId){
		return ResponseEntity.ok(salaryService.getTransaction(salaryId));
	}
	
	@PutMapping("/update")
	public String updateDetails(@RequestBody Salary salary) {
		salaryService.updateSalary(salary);
		return "Updated successfully";
	}
	
	@DeleteMapping("/delete")
	public String deleteDetails(@RequestParam int salaryId) {
		salaryService.deleteSalary(salaryId);
		return "Deleted successfully";
	}
}
