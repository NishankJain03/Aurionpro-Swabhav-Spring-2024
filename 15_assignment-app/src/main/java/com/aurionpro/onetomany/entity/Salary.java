package com.aurionpro.onetomany.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "salary")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
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
	private LocalDate paymentDate;
	
	@Column(name = "salaryStatus")
	private SalaryStatus salaryStatus;
	
	@JsonIgnore
	@JsonManagedReference
	@OneToMany(mappedBy = "salary", cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	private List<SalaryTransaction> salaryTransactions;

}
