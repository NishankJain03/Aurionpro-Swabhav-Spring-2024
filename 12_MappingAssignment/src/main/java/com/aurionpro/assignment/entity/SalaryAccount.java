package com.aurionpro.assignment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "salaryAccount")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalaryAccount {
	
	@Id
	@Column(name = "bankaccountNumber")
	private long bankAccountNumber;
	
	@Column(name = "accountHolderName")
	private String accountHolderName;
	
}
