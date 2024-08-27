package com.aurionpro.dbconnect.repository;

import java.util.List;

import com.aurionpro.dbconnect.entity.Student;

//each table separate repository
public interface StudentRepository {
	List<Student> getAllStudents();
	Student getStudent(int rollnumber);
	Student addStudent(Student student);
	List<Student> getStudentByName(String name);
}
