package com.aurionpro.assignment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.assignment.entity.Customer;
import com.aurionpro.assignment.service.ICustomerService;

import jakarta.validation.Valid;

@RestController
public class CustomerController {
	@Autowired
	private ICustomerService customerService;	
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		return ResponseEntity.ok(customerService.getAllCustomer());
		
	}
	
	@PostMapping("/customers")
	public String addCustomers(@Valid @RequestBody Customer customer) {
		customerService.addCustomer(customer);
		return "Customer added successfully!!";
	}
	
	@PutMapping("/updatecustomer")
	public String updateCustomer(@Valid @RequestBody Customer customer) {
		
		customerService.updateCustomer(customer);
		return "Customer updated successfully!!";
	}
	
	@DeleteMapping("/deletecustomer")
	public String deleteCustomer(@RequestBody Customer customer) {
		customerService.deleteCustomer(customer);
		return "Customer deleted successfully!!";
	}
}
