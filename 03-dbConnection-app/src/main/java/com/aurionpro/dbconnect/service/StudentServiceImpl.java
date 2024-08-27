package com.aurionpro.dbconnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.dbconnect.entity.Student;
import com.aurionpro.dbconnect.repository.StudentRepository;

@Service
public class StudentServiceImpl implements IStudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.getAllStudents();
	}

	@Override
	public Student getStudent(int rollnumber) {
		return studentRepository.getStudent(rollnumber);
	}

	@Override
	public Student addStudent(Student student) {
		return studentRepository.addStudent(student);
	}

	@Override
	public List<Student> getStudentByName(String name) {
		return studentRepository.getStudentByName(name);
	}

}
