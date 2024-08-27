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
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
	@Column(name="clientid")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clientId;
	
	@Column(name = "companyName")
	private String companyName;
	
	@Column(name = "registrationNumber")
	private long registrationNumber;
	
	@Column(name  = "contactPerson")
	private String contactPerson;
	
	@Column(name = "contactEmail")
	private String contactEmail;
	
	@Column(name = "contactNumber")
	private long contactNumber;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "status")
	private ClientStatus clientStatus;
	
	@Column(name = "creationDate")
	private LocalDate date;
	
	@Column(name = "kycStatus")
	private KycStatus kycStatus;
	
	
}
