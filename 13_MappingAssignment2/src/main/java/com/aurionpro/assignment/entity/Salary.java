package com.aurionpro.assignment.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "salary")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Salary {
	
	@Column(name = "salaryId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int salaryId;
	
	@Column(name = "salaryMonth")
	private String salaryMonth;
	
	@Column(name = "grossSalary")
	private double grossSalary;
	
	@Column(name = "deductions")
	private double deductions;
	
	@Column(name = "netSalary")
	private double netSalary;
	
	@Column(name = "paymentDate")
	private LocalDate date;
	
	@Column(name = "status")
	private SalaryStatus salaryStatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "transactionId")
	private Transaction transaction;
}
