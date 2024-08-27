package com.aurionpro.onetomany.dto;

import java.time.LocalDate;

import com.aurionpro.onetomany.entity.SalaryStatus;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalaryDto {
	private int salaryId;
	private String salaryMonth;
	private double grossSalary;
	private double deductions;
	private double netSalary;
	private LocalDate paymentDate;
	private SalaryStatus salaryStatus;
}
