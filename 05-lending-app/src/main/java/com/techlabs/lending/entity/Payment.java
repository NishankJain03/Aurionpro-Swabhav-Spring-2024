package com.techlabs.lending.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="payment")
public class Payment {

	@Column(name="paymentID")
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int paymentID;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="paymentMode")
	private PaymentMode paymentMode;
	
	@Column(name="paymentStatus")
	private PaymentStatus paymentStatus;
	public Payment(int paymentID, Date date, double amount, PaymentMode paymentMode, PaymentStatus paymentStatus) {
		super();
		this.paymentID = paymentID;
		this.date = date;
		this.amount = amount;
		this.paymentMode = paymentMode;
		this.paymentStatus = paymentStatus;
	}
	
	public Payment() {
	}

	public int getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "Payment [paymentID=" + paymentID + ", date=" + date + ", amount=" + amount + ", paymentMode="
				+ paymentMode + ", paymentStatus=" + paymentStatus + "]";
	}
	
	
	
}
