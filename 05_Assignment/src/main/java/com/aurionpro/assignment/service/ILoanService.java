package com.aurionpro.assignment.service;

import java.util.List;

import com.aurionpro.assignment.entity.Loan;

public interface ILoanService {
	List<Loan> getAllLoans();
	void addLoan(Loan loan);
	void updateLoan( Loan loan);
	void deleteLoan(Loan loan);

}
