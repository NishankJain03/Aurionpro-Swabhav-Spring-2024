package com.aurionpro.client.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
	
	@Column(name = "bankAccountNumber")
	private long bankAccountNumber;
	
	@Column(name = "bankIFSCCode")
	private String bankIFSCCode;
	
	@Column(name = "status")
	private BankStatus bankStatus;
	
	
	
	
}
