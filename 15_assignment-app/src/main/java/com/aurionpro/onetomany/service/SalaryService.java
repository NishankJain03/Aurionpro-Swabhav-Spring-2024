package com.aurionpro.onetomany.service;

import java.util.List;

import com.aurionpro.onetomany.dto.SalaryDto;
import com.aurionpro.onetomany.entity.Salary;

public interface SalaryService {
	Salary addSalary(Salary salary);
	Salary updateSalary(int salaryId, SalaryDto salaryDto);
	List<Salary> getAllSalary();
}
