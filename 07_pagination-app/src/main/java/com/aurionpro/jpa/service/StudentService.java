package com.aurionpro.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.aurionpro.jpa.dto.PageResponse;
import com.aurionpro.jpa.entity.Student;

public interface StudentService {
	PageResponse getAllStudents(int pageNumber, int pageSize);
	PageResponse getAllStudentsByName(String name, int pageNumber, int pageSize);
	Optional<Student> getByRollNumber(int rollnumber);
	void updateStudent(Student student);
	void deleteStudent(Student student);
	void addStudent(Student student);
	List<Student> getByName(String name);
	List<Student> getByAge(int age);
}
