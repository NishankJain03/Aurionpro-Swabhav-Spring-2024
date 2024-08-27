package com.aurionpro.assignment.entity;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="payment")
public class Payment {

	@Column(name="paymentID")
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int paymentID;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@NotNull(message = "Date cannot be null")
	@Column(name="date")
	private Date date;
	
	@Positive(message = "Amount must be greater than zero")
	@Column(name="amount")
	private double amount;
	
	@NotNull(message = "Payment mode cannot be null")
    @Enumerated(EnumType.STRING)// Maps enum to database as a string
	@Column(name="paymentMode")
	private PaymentMode paymentMode;
	
	@NotNull(message = "Payment status cannot be null")
    @Enumerated(EnumType.STRING)// Maps enum to database as a string
	@Column(name="paymentStatus")
	private PaymentStatus paymentStatus;
	
	
	
	
}
