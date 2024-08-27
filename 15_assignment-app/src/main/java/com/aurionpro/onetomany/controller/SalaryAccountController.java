package com.aurionpro.onetomany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.onetomany.dto.SalaryAccountDto;
import com.aurionpro.onetomany.entity.Bank;
import com.aurionpro.onetomany.entity.SalaryAccount;
import com.aurionpro.onetomany.entity.SalaryTransaction;
import com.aurionpro.onetomany.service.SalaryAccountService;

@RestController
@RequestMapping("/bankapp")
public class SalaryAccountController {
	
	@Autowired
	private SalaryAccountService salaryAccountService;
	
	@PutMapping("/salaryAccount/bank")
	public ResponseEntity<SalaryAccount> addBank(@RequestParam long accountNumber, @RequestBody Bank bank){
		return ResponseEntity.ok(salaryAccountService.addBanks(accountNumber, bank));
	}
	
	@PutMapping("/allocateSalaryTransaction")
	public ResponseEntity<SalaryAccount> addSalaryTransaction(@RequestParam long accountNumber, @RequestBody List<SalaryTransaction> salaryTransactions){
		return ResponseEntity.ok(salaryAccountService.allocateSalaryTransaction(accountNumber, salaryTransactions));
	}
	
	@PutMapping("/salaryAccount/{accountNumber}")
    public ResponseEntity<SalaryAccount> updateSalaryAccount(@PathVariable long accountNumber, @RequestBody SalaryAccountDto salaryAccountDto) {
        SalaryAccount updatedAccount = salaryAccountService.updateSalaryAccount(accountNumber, salaryAccountDto);
        return ResponseEntity.ok(updatedAccount);
    }
	
	@GetMapping("/getAllSalaryAccount")
	public ResponseEntity<List<SalaryAccount>> getAllSalaryAccount(){
		return ResponseEntity.ok(salaryAccountService.getAllSalaryAccount());
	}
}
