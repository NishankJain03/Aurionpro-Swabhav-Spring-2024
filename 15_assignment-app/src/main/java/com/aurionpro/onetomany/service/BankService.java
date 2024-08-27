package com.aurionpro.onetomany.service;

import java.util.List;

import com.aurionpro.onetomany.dto.BankDto;
import com.aurionpro.onetomany.entity.Bank;
import com.aurionpro.onetomany.entity.SalaryAccount;

public interface BankService {
	Bank addBank(Bank bank);
	
	Bank addSalaryAccount(int bankId, List<SalaryAccount> salaryAccounts);
	
	Bank updateBank(BankDto bankDto);
	
	List<Bank> getAllBank(); 
}
