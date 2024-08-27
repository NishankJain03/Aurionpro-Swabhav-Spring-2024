package com.aurionpro.onetomany.dto;

import java.time.LocalDate;

import com.aurionpro.onetomany.entity.EmployeeStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	private int employeeId;
	private String firstName;
	private String lastName;
	private long phoneNumber;
	private String email;
	private String position;
	private LocalDate hireDate;
	private double salary;
	private EmployeeStatus employeeStatus;
	
}
