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
@Table(name = "client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Client {
	
	@Column(name = "clientId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clientId;
	
	@Column(name = "companyName")
	private String companyName;
	
	@Column(name = "registrationNumber")
	private double registrationNumber;
	
	@Column(name = "contactPerson")
	private String contactPerson;
	
	@Column(name = "contactEmail")
	private String contactEmail;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "clientStatus")
	private ClientStatus clientStatus;
	
	@Column(name = "creationDate")
	private LocalDate creationDate;
	
	@Column(name = "kycStatus")
	private KycStatus kycStatus;
	
	@JsonIgnore
	@JsonManagedReference
	@OneToMany(mappedBy = "client", cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	List<Employee> employees;
	
}
