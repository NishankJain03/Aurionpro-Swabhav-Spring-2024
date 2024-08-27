package com.aurionpro.onetomany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.onetomany.dto.BankDto;
import com.aurionpro.onetomany.entity.Bank;
import com.aurionpro.onetomany.entity.SalaryAccount;
import com.aurionpro.onetomany.repository.BankRepository;
import com.aurionpro.onetomany.repository.SalaryAccountRespository;

@Service
public class BankServiceImpl implements BankService{

	@Autowired
	private BankRepository bankRepository;
	
	@Autowired
	private SalaryAccountRespository salaryAccountRespository;
	
	@Override
	public Bank addBank(Bank bank) {
		return bankRepository.save(bank);
	}

	@Override
	public Bank addSalaryAccount(int bankId, List<SalaryAccount> salaryAccounts) {
		Optional<Bank> optionalBank = bankRepository.findById(bankId);
	    if (!optionalBank.isPresent()) {
	        return null;
	    }
	    
	    Bank dbBank = optionalBank.get();
	    List<SalaryAccount> existingSalaryAccounts = dbBank.getSalaryAccounts();
	    
	    salaryAccounts.forEach(salaryAccount -> {
	        Optional<SalaryAccount> tempOptional = salaryAccountRespository.findByAccountNumber(salaryAccount.getAccountNumber());
	        if (tempOptional.isPresent()) {
	            SalaryAccount temp = tempOptional.get();
	            temp.setBank(dbBank); // Set the Bank for the existing SalaryAccount
	            existingSalaryAccounts.add(temp);
	        }
	    });

	    dbBank.setSalaryAccounts(existingSalaryAccounts);
	    return bankRepository.save(dbBank);
	}

	@Override
	public Bank updateBank(BankDto bankDto) {
		Optional<Bank> optionalBank = bankRepository.findById(bankDto.getBankId());
		if(!optionalBank.isPresent())
			return null;
		Bank bank = optionalBank.get();
		if (bankDto.getBankName() != null && !bankDto.getBankName().isEmpty()) {
	        bank.setBankName(bankDto.getBankName());
	    }
	    
	    if (bankDto.getIfscNo() != null && !bankDto.getIfscNo().isEmpty()) {
	        bank.setIfscNo(bankDto.getIfscNo());
	    }
		return bankRepository.save(bank);
	}

	@Override
	public List<Bank> getAllBank() {
		return bankRepository.findAll();
	}

}
