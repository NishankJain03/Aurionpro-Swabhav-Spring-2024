package com.aurionpro.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.assignment.entity.Loan;
import com.aurionpro.assignment.repository.ILoanRepository;

@Service
public class LoanService implements ILoanService{
	
	@Autowired
	private ILoanRepository iLoanRepository;

	@Override
	public List<Loan> getAllLoans() {
		return iLoanRepository.getAllLoans();
	}

	@Override
	public void addLoan(Loan loan) {
		iLoanRepository.addLoan(loan);
		
	}

	@Override
	public void updateLoan(Loan loan) {
		iLoanRepository.updateLoan(loan);
		
	}

	@Override
	public void deleteLoan(Loan loan) {
		iLoanRepository.deleteLoan(loan);
		
	}
	
}
