package com.aurionpro.assignment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.assignment.entity.Payment;
import com.aurionpro.assignment.service.PaymentService;

import jakarta.validation.Valid;

@RestController
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/payments")
	public ResponseEntity<List<Payment>> getAllPayments(){
		return ResponseEntity.ok(paymentService.getAllPayments());
	}
	
	@PostMapping("/payments")
	public String addPayment(@Valid @RequestBody Payment payment) {
		paymentService.addPayment(payment);
		return "added successfully";
	}
	
	@PutMapping("/updatepayments")
	public String updatePayment(@RequestBody Payment payment) {
		paymentService.updatePayment(payment);
		return "updated successfully";
	}
	
	@DeleteMapping("/deletepayments")
	public String deletePayment(@RequestBody Payment payment) {
		paymentService.deletePayment(payment);
		return "deleted successfully";
	}
}
