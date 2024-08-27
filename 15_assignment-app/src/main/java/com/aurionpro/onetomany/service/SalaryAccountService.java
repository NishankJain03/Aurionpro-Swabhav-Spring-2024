package com.aurionpro.onetomany.service;

import java.util.List;

import com.aurionpro.onetomany.dto.SalaryAccountDto;
import com.aurionpro.onetomany.entity.Bank;
import com.aurionpro.onetomany.entity.SalaryAccount;
import com.aurionpro.onetomany.entity.SalaryTransaction;

public interface SalaryAccountService {
	SalaryAccount addBanks(long accountNumber, Bank bank);
	
	SalaryAccount allocateSalaryTransaction(long accountNumber, List<SalaryTransaction> salaryTransactions );
	SalaryAccount updateSalaryAccount(long accountNumber, SalaryAccountDto salaryAccountDto);
	List<SalaryAccount> getAllSalaryAccount();
}
