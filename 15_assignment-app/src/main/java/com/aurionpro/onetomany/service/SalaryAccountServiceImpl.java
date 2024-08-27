package com.aurionpro.onetomany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.onetomany.dto.SalaryAccountDto;
import com.aurionpro.onetomany.entity.Bank;
import com.aurionpro.onetomany.entity.SalaryAccount;
import com.aurionpro.onetomany.entity.SalaryTransaction;
import com.aurionpro.onetomany.repository.BankRepository;
import com.aurionpro.onetomany.repository.SalaryAccountRespository;
import com.aurionpro.onetomany.repository.SalaryTransactionRepository;

@Service
public class SalaryAccountServiceImpl implements SalaryAccountService{
	
	@Autowired
	private SalaryAccountRespository salaryAccountRespository;
	
	@Autowired
	private BankRepository bankRepository;
	
	@Autowired
	private SalaryTransactionRepository salaryTransactionRepository;

	@Override
	public SalaryAccount addBanks(long accountNumber, Bank bank) {
		Optional<SalaryAccount> optionalSalaryAccount = salaryAccountRespository.findByAccountNumber(accountNumber);
		Optional<Bank> optionalBank = bankRepository.findById(bank.getBankId());
		if(!optionalSalaryAccount.isPresent())
			return null;
		SalaryAccount dbSalaryAccount = optionalSalaryAccount.get();
		Bank dbBank = optionalBank.get();
		dbSalaryAccount.setBank(dbBank);
		return salaryAccountRespository.save(dbSalaryAccount);
	}

	@Override
	public SalaryAccount allocateSalaryTransaction(long accountNumber, List<SalaryTransaction> salaryTransactions) {
		Optional<SalaryAccount> optionalSalaryAccount = salaryAccountRespository.findByAccountNumber(accountNumber);
		if(!optionalSalaryAccount.isPresent())
			return null;
		SalaryAccount dbSalaryAccount = optionalSalaryAccount.get();
		List<SalaryTransaction> existingTransaction = dbSalaryAccount.getSalaryTransactions();
		salaryTransactions.forEach((salaryTransaction) -> {
			SalaryTransaction dbSalaryTransaction = salaryTransactionRepository.findById(salaryTransaction.getTransactionId()).get();
			dbSalaryTransaction.setSalaryAccount(dbSalaryAccount);
			existingTransaction.add(dbSalaryTransaction);
		});
		dbSalaryAccount.setSalaryTransactions(existingTransaction);
		return salaryAccountRespository.save(dbSalaryAccount);
	}
	
	@Override
    public SalaryAccount updateSalaryAccount(long accountNumber, SalaryAccountDto salaryAccountDto) {
        Optional<SalaryAccount> optionalSalaryAccount = salaryAccountRespository.findByAccountNumber(accountNumber);
        if (!optionalSalaryAccount.isPresent()) {
            return null; 
        }
        SalaryAccount salaryAccount = optionalSalaryAccount.get();
        if (salaryAccountDto.getAccountHolderName() != null && !salaryAccountDto.getAccountHolderName().isEmpty()) {
            salaryAccount.setAccountHolderName(salaryAccountDto.getAccountHolderName());
        }
        return salaryAccountRespository.save(salaryAccount);
    }

	@Override
	public List<SalaryAccount> getAllSalaryAccount() {
		return salaryAccountRespository.findAll();
	}
	
	
}
