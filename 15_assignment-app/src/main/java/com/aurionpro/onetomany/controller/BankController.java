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

import com.aurionpro.onetomany.dto.BankDto;
import com.aurionpro.onetomany.entity.Bank;
import com.aurionpro.onetomany.entity.SalaryAccount;
import com.aurionpro.onetomany.service.BankService;

@RestController
@RequestMapping("/bankapp")
public class BankController {

	@Autowired
	private BankService bankService;
	
	@PostMapping("/addBank")
	public ResponseEntity<Bank> addBank(@RequestBody Bank bank){
		return ResponseEntity.ok(bankService.addBank(bank));
	}
	
	@PutMapping("/allocateSalaryAccount")
	public ResponseEntity<Bank> allocateSalaryAccount(@RequestParam int bankId, @RequestBody List<SalaryAccount> salaryAccounts){
		return ResponseEntity.ok(bankService.addSalaryAccount(bankId, salaryAccounts));
	}
	
	@PutMapping("/updateBank/{id}")
	public ResponseEntity<Bank> updateBank(@PathVariable int id, @RequestBody BankDto bankDto){
		bankDto.setBankId(id);
		return ResponseEntity.ok(bankService.updateBank(bankDto));
	}
	
	@GetMapping("/getAllBank")
	public ResponseEntity<List<Bank>> getAllBank(){
		return ResponseEntity.ok(bankService.getAllBank());
	}
	
}
