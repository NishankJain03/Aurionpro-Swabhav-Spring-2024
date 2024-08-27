package com.aurionpro.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.assignment.entity.Payment;
import com.aurionpro.assignment.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Override
	public List<Payment> getAllPayments() {
		return paymentRepository.getAllPayments();
	}

	@Override
	public void addPayment(Payment payment) {
		paymentRepository.addPayment(payment);
		
	}

	@Override
	public void updatePayment(Payment payment) {
		paymentRepository.updatePayment(payment);
		
	}

	@Override
	public void deletePayment(Payment payment) {
		paymentRepository.deletePayment(payment);
	}
	
}
