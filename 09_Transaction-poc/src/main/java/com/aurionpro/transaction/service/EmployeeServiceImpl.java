package com.aurionpro.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aurionpro.transaction.entity.Address;
import com.aurionpro.transaction.entity.Employee;
import com.aurionpro.transaction.repository.AddressRepository;
import com.aurionpro.transaction.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private AddressService addressService;
	@Override
	@Transactional
	public Employee addEmployee(Employee employee) {
		Employee employeeSavedToDB = this.employeeRepository.save(employee);
        
        Address address = null;
        address.setId(123L);
        address.setAddress("Varanasi");
        address.setEmployee(employee);
        
        // calling addAddress() method 
        // of AddressService class
        this.addressService.addAddress(address);
        return employeeSavedToDB;
	}	

}
