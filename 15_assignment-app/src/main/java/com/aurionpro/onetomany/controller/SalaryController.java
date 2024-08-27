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
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.onetomany.dto.SalaryDto;
import com.aurionpro.onetomany.entity.Salary;
import com.aurionpro.onetomany.service.SalaryService;

@RestController
@RequestMapping("/bankapp")
public class SalaryController{
	
	@Autowired
	private SalaryService salaryService;
	
	@PostMapping("/addSalary")
	public ResponseEntity<Salary> addSalary(@RequestBody Salary salary){
		return ResponseEntity.ok(salaryService.addSalary(salary));
	}
	
	@PutMapping("/salary/{id}")
    public ResponseEntity<Salary> updateSalary(@PathVariable int id, @RequestBody SalaryDto salaryDto) {
        Salary updatedSalary = salaryService.updateSalary(id, salaryDto);
        return ResponseEntity.ok(updatedSalary);
    }
	
	@GetMapping("/getAllSalary")
	public ResponseEntity<List<Salary>> getAllSalary(){
		return ResponseEntity.ok(salaryService.getAllSalary());
	}
}
