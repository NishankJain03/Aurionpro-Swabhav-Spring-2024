package com.aurionpro.onetomany.dto;

import java.time.LocalDate;

import com.aurionpro.onetomany.entity.TransactionStatus;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalaryTransactionDto {
	private int transactionId;
	private LocalDate transactionDate;
	private double amount;
	private TransactionStatus transactionStatus;
}
