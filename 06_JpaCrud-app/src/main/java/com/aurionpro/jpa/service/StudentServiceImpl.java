package com.aurionpro.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.jpa.entity.Student;
import com.aurionpro.jpa.repository.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Optional<Student> getByRollNumber(int rollnumber) {
		return studentRepository.findById(rollnumber);
	}

	@Override
	public void updateStudent(Student student) {
		if(studentRepository.existsById(student.getRollnumber()))
			studentRepository.save(student);
		
	}

	@Override
	public void deleteStudent(Student student) {
		if(studentRepository.existsById(student.getRollnumber()))
			studentRepository.delete(student);
		
	}

	@Override
	public void addStudent(Student student) {
		studentRepository.save(student);
	}

	@Override
	public List<Student> getByName(String name) {
		return studentRepository.findByName(name);
	}

	@Override
	public List<Student> getByAge(int age) {
		// TODO Auto-generated method stub
		return studentRepository.findByAge(age);
	}

	
	
}
