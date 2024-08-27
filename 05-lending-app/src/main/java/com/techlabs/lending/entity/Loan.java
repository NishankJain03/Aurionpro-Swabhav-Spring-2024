package com.techlabs.lending.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="loan")
public class Loan {
	
	
	@Column(name="loanID")
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int loanID;
	
	@Column(name="loanAmount")
	private double loanAmount;
	
	@Column(name="rateofinterest")
	private double rateofinterest;
	
	@Column(name="loanterm")
	private int loanTerm;
	
	@Column(name="startdate")
	private Date startDate;
	
	@Column(name="enddate")
	private Date endDate;
	
	@Column(name="loanStatus")
	@Enumerated(EnumType.STRING)
	private LoanStatus loanStatus;
	public Loan(int loanID, double loanAmount, double rateofinterest, int loanTerm, Date startDate, Date endDate,
			LoanStatus loanStatus) {
		super();
		this.loanID = loanID;
		this.loanAmount = loanAmount;
		this.rateofinterest = rateofinterest;
		this.loanTerm = loanTerm;
		this.startDate = startDate;
		this.endDate = endDate;
		this.loanStatus = loanStatus;
	}
	
	public Loan() {
	}

	public int getLoanID() {
		return loanID;
	}

	public void setLoanID(int loanID) {
		this.loanID = loanID;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public double getRateofinterest() {
		return rateofinterest;
	}

	public void setRateofinterest(double rateofinterest) {
		this.rateofinterest = rateofinterest;
	}

	public int getLoanTerm() {
		return loanTerm;
	}

	public void setLoanTerm(int loanTerm) {
		this.loanTerm = loanTerm;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public LoanStatus getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(LoanStatus loanStatus) {
		this.loanStatus = loanStatus;
	}

	@Override
	public String toString() {
		return "Loan [loanID=" + loanID + ", loanAmount=" + loanAmount + ", rateofinterest=" + rateofinterest
				+ ", loanTerm=" + loanTerm + ", startDate=" + startDate + ", endDate=" + endDate + ", loanStatus="
				+ loanStatus + "]";
	}
	
	

}
