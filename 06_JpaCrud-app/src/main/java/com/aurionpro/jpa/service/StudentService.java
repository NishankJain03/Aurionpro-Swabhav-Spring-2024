package com.aurionpro.jpa.service;

import java.util.List;
import java.util.Optional;

import com.aurionpro.jpa.entity.Student;

public interface StudentService {
	List<Student> getAllStudents();
	Optional<Student> getByRollNumber(int rollnumber);
	void updateStudent(Student student);
	void deleteStudent(Student student);
	void addStudent(Student student);
	List<Student> getByName(String name);
	List<Student> getByAge(int age);
}
