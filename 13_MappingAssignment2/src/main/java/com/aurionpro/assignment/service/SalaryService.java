package com.aurionpro.assignment.service;

import java.util.List;

import com.aurionpro.assignment.entity.Salary;
import com.aurionpro.assignment.entity.Transaction;

public interface SalaryService {
	Salary addSalary(Salary salary);
	List<Salary> getAllSalary();
	Transaction getTransaction(int salaryId);
	Salary updateSalary(Salary salary);
	void deleteSalary(int salaryId);
}
