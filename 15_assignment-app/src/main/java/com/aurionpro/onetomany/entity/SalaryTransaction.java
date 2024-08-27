package com.aurionpro.onetomany.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "salaryTransactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SalaryTransaction {
	
	@Column(name = "transactionId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	
	@Column(name = "transactionDate")
	private LocalDate transactionDate;
	
	@Column(name = "amount")
	private double amount;
	
	@Column(name = "transactionStatus")
	private TransactionStatus transactionStatus;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	@JoinColumn(name = "accountNumber")
	private SalaryAccount salaryAccount;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	@JoinColumn(name = "bankId")
	private Bank bank;
	
	@JsonBackReference
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	@JoinColumn(name = "salaryId")
	private Salary salary;

}
