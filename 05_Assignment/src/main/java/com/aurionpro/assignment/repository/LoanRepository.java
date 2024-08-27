package com.aurionpro.assignment.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aurionpro.assignment.entity.Loan;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class LoanRepository implements ILoanRepository{
	@Autowired
	private EntityManager manager;
	
	@Override
	public List<Loan> getAllLoans() {
		TypedQuery<Loan> query = manager.createQuery("SELECT l from Loan l",Loan.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void addLoan(Loan loan) {
		manager.persist(loan);
		
	}

	@Override
	@Transactional
	public void updateLoan(Loan loan) {
		manager.merge(loan);
		
	}

	@Override
	@Transactional
	public void deleteLoan(Loan loan) {
		Loan existingLoan = manager.find(Loan.class ,loan.getLoanID() );
		manager.remove(existingLoan);
		
	}

}
