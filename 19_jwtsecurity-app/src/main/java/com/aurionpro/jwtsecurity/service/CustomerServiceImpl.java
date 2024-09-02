package com.aurionpro.jwtsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.jwtsecurity.entity.Customer;
import com.aurionpro.jwtsecurity.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(int customerId) {
		return customerRepository.findById(customerId).orElseThrow(() -> new NullPointerException("Customer Not found"));
	}

}
