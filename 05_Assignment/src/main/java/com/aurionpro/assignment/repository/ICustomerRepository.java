package com.aurionpro.assignment.repository;

import java.util.List;

import com.aurionpro.assignment.entity.Customer;

public interface ICustomerRepository {
	List<Customer> getAllCustomer();
	void addCustomer(Customer customer);
	void updateCustomer( Customer customer);
	void deleteCustomer(Customer customer);
}	
