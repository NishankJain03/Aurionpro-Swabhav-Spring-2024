package com.aurionpro.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.assignment.entity.Customer;
import com.aurionpro.assignment.repository.ICustomerRepository;

@Service
public class CustomerService implements ICustomerService{
	
	@Autowired
	private ICustomerRepository customerRepository;
	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.getAllCustomer();
	}
	@Override
	public void addCustomer(Customer customer) {
		customerRepository.addCustomer(customer);
		
	}
	@Override
	public void updateCustomer(Customer customer) {
		customerRepository.updateCustomer(customer);
	}
	@Override
	public void deleteCustomer(Customer customer) {
		customerRepository.deleteCustomer(customer);
		
	}

}
