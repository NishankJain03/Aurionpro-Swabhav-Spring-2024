package com.aurionpro.assignment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.assignment.entity.Loan;
import com.aurionpro.assignment.service.ILoanService;

import jakarta.validation.Valid;


@RestController
public class LoanController {
	@Autowired
	private ILoanService iLoanService;
	
	@GetMapping("/loan")
	public ResponseEntity<List<Loan>> getAllLoans(){
		return ResponseEntity.ok(iLoanService.getAllLoans());
	}
	
	@PostMapping("/loan")
	public String addLoan(@RequestBody @Valid Loan loan) {
		iLoanService.addLoan(loan);
		return "added successfully";
	}
	
	@PutMapping("/updateloan")
	public String updateLoan(@RequestBody Loan loan) {
		iLoanService.updateLoan(loan);
		return "Loan updated successfully";
	}
	
	@DeleteMapping("/deleteloan")
	public String deleteLoan(@RequestBody Loan loan) {
		iLoanService.deleteLoan(loan);
		return "Loan deleted successfully";
	}
}
