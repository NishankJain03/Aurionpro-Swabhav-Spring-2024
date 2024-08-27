package com.aurionpro.assignment.repository;

import java.util.List;

import com.aurionpro.assignment.entity.Payment;

public interface PaymentRepository {
	List<Payment> getAllPayments();
	void addPayment(Payment payment);
	void updatePayment( Payment payment);
	void deletePayment(Payment payment);
}
