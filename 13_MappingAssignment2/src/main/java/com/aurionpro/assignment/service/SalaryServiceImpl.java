package com.aurionpro.assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.assignment.entity.Salary;
import com.aurionpro.assignment.entity.Transaction;
import com.aurionpro.assignment.repository.SalaryRepository;

@Service
public class SalaryServiceImpl implements SalaryService{
	
	@Autowired
	private SalaryRepository salaryRepository;

	@Override
	public Salary addSalary(Salary salary) {
		return salaryRepository.save(salary);
	}

	@Override
	public List<Salary> getAllSalary() {
		return salaryRepository.findAll();
	}

	@Override
	public Transaction getTransaction(int salaryId) {
		Optional<Salary> salary = salaryRepository.findById(salaryId);
		if(!salary.isPresent())
			return null;
		Salary existingSalary = salary.get();
		return existingSalary.getTransaction();
	}

	@Override
	public Salary updateSalary(Salary salary) {
		Transaction salary2 = salary.getTransaction();
		salary2.setAmount(salary.getTransaction().getAmount());
		salary2.setTransactionDate(salary.getTransaction().getTransactionDate());
		salary2.setTransactionStatus(salary.getTransaction().getTransactionStatus());
		
		return salaryRepository.save(salary);
	}

	@Override
	public void deleteSalary(int salaryId) {
		salaryRepository.deleteById(salaryId);
		
	}
	
	
}
