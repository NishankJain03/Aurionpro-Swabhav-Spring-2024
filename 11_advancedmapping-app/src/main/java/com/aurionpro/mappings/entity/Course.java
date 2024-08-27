package com.aurionpro.mappings.entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;
	
	@NotBlank(message = "Name must be not blank")
	@Pattern(regexp = "^[A-Za-z]+$", message = "Course name must only contain alphabetic characters")
	@Column(name = "courseName")
	private String courseName;
	
	@Positive(message = "Duration should be in positive")
	@Column(name = "duration")
	private int duration;
	
	@Positive(message = "Fees should be in positive")
	@Column(name = "fees")
	private double fees;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	@JoinColumn(name = "instructorId")
	private Instructor instructor;
	
	@ManyToMany(mappedBy =  "courses")
	private List<Student> students;
}
