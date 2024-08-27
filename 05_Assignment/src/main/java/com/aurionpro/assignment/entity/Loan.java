package com.aurionpro.assignment.entity;

import java.sql.Date;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="loan")
public class Loan {
	
	
	@Column(name="loanID")
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int loanID;
	
	
    @Positive(message = "Loan Amount must be greater than zero")
	@Column(name="loanAmount")
	private double loanAmount;

    @Positive(message = "Loan Amount must be greater than zero")
	@Column(name="rateofinterest")
	private double rateofinterest;
	
    @Positive(message = "Loan Amount must be greater than zero")
	@Column(name="loanterm")
	private int loanTerm;
	
    @DateTimeFormat(pattern = "yyyy-mm-dd")
	@PastOrPresent(message = "Date should be in past or present")
    @NotNull(message = "Date cannot be null")
	@Column(name="startdate")
	private Date startDate;
	
    @DateTimeFormat(pattern = "yyyy-mm-dd")
	@PastOrPresent(message = "Date should be in past or present")
    @NotNull(message = "Date cannot be null")
	@Column(name="enddate")
	private Date endDate;
	
    
	@Column(name="loanStatus")
	@NotNull(message = "Loan Status cannot be null")
    @Enumerated(EnumType.STRING)// Maps enum to database as a string
	private LoanStatus loanStatus;
	
}
	
