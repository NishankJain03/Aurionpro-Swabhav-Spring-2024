package com.aurionpro.onetomany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.onetomany.dto.EmployeeDto;
import com.aurionpro.onetomany.entity.Client;
import com.aurionpro.onetomany.entity.Employee;
import com.aurionpro.onetomany.repository.ClientRepository;
import com.aurionpro.onetomany.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee addClients(int employeeId, Client client) {
		Optional<Employee> optionalEmloyee = employeeRepository.findById(employeeId);
		if(!optionalEmloyee.isPresent())
			return null;
		Employee dbEmployee = optionalEmloyee.get();
		Optional<Client> optionalClient = clientRepository.findById(client.getClientId());
		Client dbClient = optionalClient.get();
		dbEmployee.setClient(dbClient);
		return employeeRepository.save(dbEmployee);
	}

	@Override
	public Employee updateEmployee(EmployeeDto employeeDto) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(employeeDto.getEmployeeId());
		if(!optionalEmployee.isPresent())
			return null;
		Employee dbEmployee = optionalEmployee.get();
		if(employeeDto.getEmail() != null && !employeeDto.getEmail().isEmpty())
			dbEmployee.setEmail(employeeDto.getEmail());
		if(employeeDto.getEmployeeStatus() != null)
			dbEmployee.setEmployeeStatus(employeeDto.getEmployeeStatus());
		if(employeeDto.getFirstName() != null && !employeeDto.getFirstName().isEmpty())
			dbEmployee.setFirstName(employeeDto.getFirstName());
		if(employeeDto.getLastName() != null && !employeeDto.getLastName().isEmpty())
			dbEmployee.setLastName(employeeDto.getLastName());
		if(employeeDto.getHireDate() != null)
			dbEmployee.setHireDate(employeeDto.getHireDate());
		if(employeeDto.getPhoneNumber()!= 0)
			dbEmployee.setPhoneNumber(employeeDto.getPhoneNumber());
		if(employeeDto.getPosition() != null && employeeDto.getPosition().isEmpty())
			dbEmployee.setPosition(employeeDto.getPosition());
		if(employeeDto.getSalary() != 0)
			dbEmployee.setSalary(employeeDto.getSalary());
		return employeeRepository.save(dbEmployee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

}
