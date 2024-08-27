package com.aurionpro.mappings.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "instructor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Instructor {
	
	@Column(name = "instructorId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int instructorId;
	
	@NotNull(message = "Name should not be null")
	@Pattern(regexp = "^[A-Za-z]+$", message = "Instructor name must only contain alphabetic characters")
	@Column(name = "instructorName")
	private String instructorName;
	
	@NotNull(message = "Email should not be null")
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Email should be valid")
	@Column(name = "email")
	private String email;
	
	@NotNull(message = "Qualifications should not be null")
	@Column(name = "qualifications")
	private String qualification;
	
	@OneToMany(mappedBy = "instructor", cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	@JsonIgnore
	private List<Course> courses;
}
