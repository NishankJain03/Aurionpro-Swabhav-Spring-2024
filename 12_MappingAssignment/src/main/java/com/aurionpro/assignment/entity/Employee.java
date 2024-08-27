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
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "employees")
public class Employee {
	@Column(name = "employeeId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "phoneNumber")
	private long phoneNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "position")
	private String position;
	
	@Column(name = "hireDate")
	private LocalDate date;
	
	@Column(name = "salary")
	private double salary;
	
	@Column(name = "bankIFSCCode")
	private String bankIFSCCode;
	
	@Column(name = "status")
	private BankStatus bankStatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bankaccountNumber")
	private SalaryAccount salaryAccount;
}
