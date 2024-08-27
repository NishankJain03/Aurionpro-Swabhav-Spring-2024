package com.aurionpro.onetomany.service;

import java.util.List;

import com.aurionpro.onetomany.dto.SalaryTransactionDto;
import com.aurionpro.onetomany.entity.Bank;
import com.aurionpro.onetomany.entity.Employee;
import com.aurionpro.onetomany.entity.Salary;
import com.aurionpro.onetomany.entity.SalaryAccount;
import com.aurionpro.onetomany.entity.SalaryTransaction;

public interface SalaryTransactionService {
	SalaryTransaction addSalaryTransaction(SalaryTransaction salaryTransaction);
	SalaryTransaction addBank(int transactionId, Bank bank );
	SalaryTransaction addSalary(int transactionId, Salary salary);
	SalaryTransaction addAccountNumber(int transactionId, SalaryAccount salaryAccount );
    SalaryTransaction updateSalaryTransaction(int transactionId, SalaryTransactionDto salaryTransactionDto);
    List<SalaryTransaction> getAllTransaction();

}
