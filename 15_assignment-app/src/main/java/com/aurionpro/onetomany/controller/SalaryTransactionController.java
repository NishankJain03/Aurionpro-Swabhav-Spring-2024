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

import com.aurionpro.onetomany.dto.SalaryTransactionDto;
import com.aurionpro.onetomany.entity.Bank;
import com.aurionpro.onetomany.entity.Salary;
import com.aurionpro.onetomany.entity.SalaryAccount;
import com.aurionpro.onetomany.entity.SalaryTransaction;
import com.aurionpro.onetomany.service.SalaryTransactionService;

@RestController
@RequestMapping("/bankapp")
public class SalaryTransactionController {
	
	@Autowired
	private SalaryTransactionService salaryTransactionService;
	
	@PostMapping("/addSalaryTransaction")
	public ResponseEntity<SalaryTransaction> addSalaryTransaction(@RequestBody SalaryTransaction salaryTransaction){
		return ResponseEntity.ok(salaryTransactionService.addSalaryTransaction(salaryTransaction));
	}
	
	@PutMapping("/salaryTransaction/bank")
	public ResponseEntity<SalaryTransaction> addBank(@RequestParam int transactionId, @RequestBody Bank bank){
		return ResponseEntity.ok(salaryTransactionService.addBank(transactionId, bank));
	}
	
	@PutMapping("/salaryTransaction/salary")
	public ResponseEntity<SalaryTransaction> addSalary(@RequestParam int transactionId, @RequestBody Salary salary){
		return ResponseEntity.ok(salaryTransactionService.addSalary(transactionId, salary));
	}
	
	@PutMapping("/salaryTransaction/accountNumber")
	public ResponseEntity<SalaryTransaction> addAccountNumber(@RequestParam int transactionId, @RequestBody SalaryAccount salaryAccount){
		return ResponseEntity.ok(salaryTransactionService.addAccountNumber(transactionId, salaryAccount));
	}
	
	@PutMapping("/salaryTransaction/{transactionId}")
    public ResponseEntity<SalaryTransaction> updateSalaryTransaction(@PathVariable int transactionId, @RequestBody SalaryTransactionDto salaryTransactionDto) {
        SalaryTransaction updatedTransaction = salaryTransactionService.updateSalaryTransaction(transactionId, salaryTransactionDto);
        return ResponseEntity.ok(updatedTransaction);
    }
	
	@GetMapping("/getAllTransaction")
	public ResponseEntity<List<SalaryTransaction>> getAllTransaction(){
		return ResponseEntity.ok(salaryTransactionService.getAllTransaction());
	}
}

