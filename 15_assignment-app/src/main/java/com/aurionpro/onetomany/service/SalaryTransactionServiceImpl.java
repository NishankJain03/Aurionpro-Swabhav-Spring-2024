package com.aurionpro.onetomany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.onetomany.dto.SalaryTransactionDto;
import com.aurionpro.onetomany.entity.Bank;
import com.aurionpro.onetomany.entity.Employee;
import com.aurionpro.onetomany.entity.Salary;
import com.aurionpro.onetomany.entity.SalaryAccount;
import com.aurionpro.onetomany.entity.SalaryTransaction;
import com.aurionpro.onetomany.repository.BankRepository;
import com.aurionpro.onetomany.repository.EmployeeRepository;
import com.aurionpro.onetomany.repository.SalaryAccountRespository;
import com.aurionpro.onetomany.repository.SalaryRespository;
import com.aurionpro.onetomany.repository.SalaryTransactionRepository;

@Service
public class SalaryTransactionServiceImpl implements SalaryTransactionService{

	@Autowired
	private SalaryTransactionRepository salaryTransactionRepository;
	
	@Autowired
	private BankRepository bankRepository;
	
	@Autowired
	private SalaryRespository salaryRespository;
	
	@Autowired
	private SalaryAccountRespository salaryAccountRespository;
	
	@Override
	public SalaryTransaction addSalaryTransaction(SalaryTransaction salaryTransaction) {
		return salaryTransactionRepository.save(salaryTransaction);
	}

	@Override
	public SalaryTransaction addBank(int transactionId, Bank bank) {
		Optional<SalaryTransaction> optionalSalaryTransaction = salaryTransactionRepository.findById(transactionId);
		if(!optionalSalaryTransaction.isPresent())
			return null;
		Optional<Bank> optionalBank = bankRepository.findById(bank.getBankId());
		SalaryTransaction dbSalaryTransaction = optionalSalaryTransaction.get();
		Bank dbBank = optionalBank.get();
		dbSalaryTransaction.setBank(dbBank);
		return salaryTransactionRepository.save(dbSalaryTransaction);
	}

	@Override
	public SalaryTransaction addSalary(int transactionId, Salary salary) {
		Optional<SalaryTransaction> optionalSalaryTransaction = salaryTransactionRepository.findById(transactionId);
		if(!optionalSalaryTransaction.isPresent())
			return null;
		Optional<Salary> optionalSalary = salaryRespository.findById(salary.getSalaryId());
		SalaryTransaction dbSalaryTransaction = optionalSalaryTransaction.get();
		Salary dbSalary = optionalSalary.get();
		dbSalaryTransaction.setSalary(dbSalary);
		return salaryTransactionRepository.save(dbSalaryTransaction);
	}

	@Override
	public SalaryTransaction addAccountNumber(int transactionId, SalaryAccount salaryAccount) {
		Optional<SalaryTransaction> optionalSalaryTransaction = salaryTransactionRepository.findById(transactionId);
		if(!optionalSalaryTransaction.isPresent())
			return null;
		Optional<SalaryAccount> optionalSalaryAccount = salaryAccountRespository.findByAccountNumber(salaryAccount.getAccountNumber());
		SalaryTransaction dbSalaryTransaction = optionalSalaryTransaction.get();
		SalaryAccount dbSalaryAccount = optionalSalaryAccount.get();
		dbSalaryTransaction.setSalaryAccount(dbSalaryAccount);
		return salaryTransactionRepository.save(dbSalaryTransaction);
	}

	@Override
	public SalaryTransaction updateSalaryTransaction(int transactionId, SalaryTransactionDto salaryTransactionDto) {
		Optional<SalaryTransaction> optionalSalaryTransaction = salaryTransactionRepository.findById(transactionId);
        if (!optionalSalaryTransaction.isPresent()) {
        }
        SalaryTransaction salaryTransaction = optionalSalaryTransaction.get();
        if (salaryTransactionDto.getTransactionDate() != null) {
            salaryTransaction.setTransactionDate(salaryTransactionDto.getTransactionDate());
        }

        if (salaryTransactionDto.getAmount() != 0) {
            salaryTransaction.setAmount(salaryTransactionDto.getAmount());
        }

        if (salaryTransactionDto.getTransactionStatus() != null) {
            salaryTransaction.setTransactionStatus(salaryTransactionDto.getTransactionStatus());
        }
        return salaryTransactionRepository.save(salaryTransaction);
	}

	@Override
	public List<SalaryTransaction> getAllTransaction() {
		return salaryTransactionRepository.findAll();
	}

}
