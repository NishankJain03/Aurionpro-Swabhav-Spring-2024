package com.aurionpro.assignment.entity;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="customer")
public class Customer {

	@Column(name="customerID")
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int customerID;
	
	@NotBlank(message = "First Name cannot be null")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Name must contain only letters")
	@Column(name="firstname")
	private String firstname;
	
	@NotBlank(message = "Last Name cannot be null")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Name must contain only letters")
	@Column(name="lastname")
	private String lastname;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@PastOrPresent(message = "Date should be in past or present")
	@NotNull(message = "Date cannot be null")
	@Column(name="dateofbirth")
	private Date dateofbirth;
	
	@NotBlank(message = "Email cannot be Blank")
	@Size(max = 40, message = "Email should not exceed more than 40 characters")
	@Email(message = "Please enter a valid email address")
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Please enter a valid email address")
	@Column(name="email")
	private String email;
	
	@NotNull(message = "Mobile number cannot be null")
	@Pattern(regexp = "^\\d{10}$", message = "Mobile number must be at least 10 digits long")
	@Column(name="mobilenumber")
	private String mobilenumber;

	
	
	
}
