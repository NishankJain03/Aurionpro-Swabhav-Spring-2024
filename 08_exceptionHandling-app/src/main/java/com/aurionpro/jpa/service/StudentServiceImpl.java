package com.aurionpro.jpa.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aurionpro.jpa.dto.PageResponse;
import com.aurionpro.jpa.entity.Student;
import com.aurionpro.jpa.exceptions.StudentException;
import com.aurionpro.jpa.repository.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public PageResponse getAllStudents(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Student> studentPage = studentRepository.findAll(pageable);
		PageResponse studentResponse = new PageResponse();
		studentResponse.setTotalPAges(studentPage.getTotalPages());
		studentResponse.setSze(studentPage.getSize());
		studentResponse.setTotalElements(studentPage.getNumberOfElements());
		studentResponse.setContents(studentPage.getContent());
		studentResponse.setLastPage(studentPage.isLast());
		return studentResponse;
	}
	
	
	
	@Override
	public Student getByRollNumber(int rollnumber) {
		Optional<Student> dbStudent = studentRepository.findById(rollnumber);
		if(!dbStudent.isPresent()) {
			throw new StudentException();
		}
		return dbStudent.get();
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



	@Override
	public PageResponse getAllStudentsByName(String name, int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Student> studentPage = studentRepository.findByName(name, pageable);
		PageResponse studentResponse = new PageResponse();
		studentResponse.setTotalPAges(studentPage.getTotalPages());
		studentResponse.setSze(studentPage.getSize());
		studentResponse.setTotalElements(studentPage.getNumberOfElements());
		studentResponse.setContents(studentPage.getContent());
		return studentResponse;
	}

	
	
}
