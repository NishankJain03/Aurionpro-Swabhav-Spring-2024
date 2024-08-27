package com.aurionpro.assignment.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aurionpro.assignment.entity.Payment;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class PaymentRepositoryImpl implements PaymentRepository{
	
	@Autowired
	private EntityManager manager;
	
	@Override
	public List<Payment> getAllPayments() {
		TypedQuery<Payment> query = manager.createQuery("SELECT p from Payment p", Payment.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void addPayment(Payment payment) {
		manager.persist(payment);
		
	}

	@Override
	@Transactional
	public void updatePayment(Payment payment) {
		manager.merge(payment);
		
	}

	@Override
	@Transactional
	public void deletePayment(Payment payment) {
		Payment existingPayment = manager.find(Payment.class ,payment.getPaymentID() );
		manager.remove(existingPayment);
		
	}
	
}
