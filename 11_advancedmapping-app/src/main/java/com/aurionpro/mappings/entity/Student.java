package com.aurionpro.mappings.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Student {
	@Id
	@Column(name = "rollnumber")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rollnumber;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private int age;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId")
	private Address address;
	
	@ManyToMany
	@JoinTable(name = "student-course", joinColumns = @JoinColumn(name = "rollnumber"), 
				inverseJoinColumns = @JoinColumn(name = "courseId"))
	private Set<Course> courses;
}
