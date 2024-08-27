package com.aurionpro.onetomany.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "salaryAccount")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SalaryAccount {
	@Column(name = "accountNumber")
	@Id
	private long accountNumber;
	
	@Column(name = "accountHolderName")
	private String accountHolderName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "salaryAccount", cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	private List<SalaryTransaction> salaryTransactions;
	
	@JsonIgnore
	@JsonBackReference
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	@JoinColumn(name = "bankId")
	private Bank bank;
}
