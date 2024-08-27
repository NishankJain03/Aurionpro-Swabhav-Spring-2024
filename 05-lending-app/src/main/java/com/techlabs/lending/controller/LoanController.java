package com.techlabs.lending.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techlabs.lending.entity.Loan;
import com.techlabs.lending.service.LoanService;

@RestController
@RequestMapping("/lendingapp")
public class LoanController {

	@Autowired
	private LoanService loanService;
	
	@GetMapping("/loan")
	public ResponseEntity<List<Loan>> getAllLoans(){
		return ResponseEntity.ok(loanService.getAllLoans());
	}
	
	@PostMapping("/loan")
	public String addLoan(@RequestBody Loan loan) {
		loanService.addLoan(loan);
		return "added successfully";
	}
	
	@PostMapping("/updateloan")
	public String updateLoan(@RequestBody Loan loan) {
		loanService.updateLoan(loan);
		return "updated successfully";
	}
	
	@PostMapping("/deleteloan")
	public String deleteLoan(@RequestBody Loan loan) {
		loanService.deleteLoan(loan);
		return "deleted successfully";
	}
	
}
