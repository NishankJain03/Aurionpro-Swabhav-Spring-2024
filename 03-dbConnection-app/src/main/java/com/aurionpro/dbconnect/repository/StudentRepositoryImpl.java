package com.aurionpro.dbconnect.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aurionpro.dbconnect.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentRepositoryImpl implements StudentRepository{

	//for communicating with database we need to define a method
	@Autowired
	private EntityManager manager;
	
	@Override
	public List<Student> getAllStudents() {
		//SELECT s from Student s Student is name of class
		TypedQuery<Student>query = manager.createQuery("SELECT s from Student s", Student.class);
		return query.getResultList();
	}

	@Override
	public Student getStudent(int rollnumber) {
		return manager.find(Student.class, rollnumber);
	}

	@Override
	@Transactional
	public Student addStudent(Student student) {
		manager.persist(student);
		return student; 
	}

	@Override
	public List<Student> getStudentByName(String name) {
		TypedQuery<Student> query = manager.createQuery("Select s from Student s where s.name=: theName", Student.class);
		query.setParameter("theName", name);
		return query.getResultList();
	}
	
	
	
}
