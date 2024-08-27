package com.aurionpro.assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.assignment.entity.Employee;
import com.aurionpro.assignment.entity.SalaryAccount;
import com.aurionpro.assignment.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public SalaryAccount getSalaryAccountByEmployeeId(int employeeId) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
		if(!optionalEmployee.isPresent())
			return null;
		Employee existingEmployee = optionalEmployee.get();
		
		return existingEmployee.getSalaryAccount();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		SalaryAccount salaryAccount = employee.getSalaryAccount();
		salaryAccount.setBankAccountNumber(employee.getSalaryAccount().getBankAccountNumber());
		salaryAccount.setAccountHolderName(employee.getSalaryAccount().getAccountHolderName());
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(int employeeId) {
		employeeRepository.deleteById(employeeId);
	}

	


}
