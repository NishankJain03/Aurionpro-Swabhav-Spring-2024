package com.aurionpro.assignment.service;

import java.util.List;

import com.aurionpro.assignment.entity.Customer;

public interface ICustomerService {
	List<Customer> getAllCustomer();
	void addCustomer(Customer customer);
	void updateCustomer(Customer customer);
	void deleteCustomer(Customer customer);
	
}
