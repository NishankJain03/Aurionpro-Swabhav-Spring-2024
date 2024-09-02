package com.aurionpro.jwtsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.jwtsecurity.entity.Customer;
import com.aurionpro.jwtsecurity.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/getAllCustomer")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Customer>> getCustomer(){
		return ResponseEntity.ok(customerService.getAllCustomers());
	}
	
	@GetMapping("/getCustomerById/{id}")
	public ResponseEntity<Customer> getById(@PathVariable int id){
		return ResponseEntity.ok(customerService.getCustomerById(id));
	}
}
