package com.aurionpro.assignment.repository;

import java.util.List;

import com.aurionpro.assignment.entity.Loan;

public interface ILoanRepository {
	List<Loan> getAllLoans();
	void addLoan(Loan loan);
	void updateLoan( Loan loan);
	void deleteLoan(Loan loan);
}
