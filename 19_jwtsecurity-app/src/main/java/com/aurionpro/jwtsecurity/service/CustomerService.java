package com.aurionpro.jwtsecurity.service;

import java.util.List;

import com.aurionpro.jwtsecurity.entity.Customer;

public interface CustomerService {
	List<Customer> getAllCustomers();
	Customer getCustomerById(int customerId);
}
