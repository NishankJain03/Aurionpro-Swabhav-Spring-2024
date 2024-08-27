package com.aurionpro.assignment.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aurionpro.assignment.entity.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class CustomerRepository implements ICustomerRepository{

	@Autowired
	private EntityManager manager;
	
	@Override
	public List<Customer> getAllCustomer() {
		TypedQuery<Customer> query = manager.createQuery("SELECT c from Customer c",Customer.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void addCustomer(Customer customer) {
		manager.persist(customer);
		
	}

	@Override
	@Transactional
	public void updateCustomer(Customer customer) {
		Customer existingCustomer = manager.find(Customer.class ,customer.getCustomerID());
		if(existingCustomer != null) 			
			manager.merge(existingCustomer);
	}

	@Override
	@Transactional
	public void deleteCustomer(Customer customer) {
		Customer existingCustomer = manager.find(Customer.class ,customer.getCustomerID() );
		manager.remove(existingCustomer);
		
	}
	
	
	
}
