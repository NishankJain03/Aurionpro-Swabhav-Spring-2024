package com.aurionpro.assignment.service;

import java.util.List;

import com.aurionpro.assignment.entity.Payment;


public interface PaymentService {
	List<Payment> getAllPayments();
	void addPayment(Payment payment);
	void updatePayment( Payment payment);
	void deletePayment(Payment payment);
}
