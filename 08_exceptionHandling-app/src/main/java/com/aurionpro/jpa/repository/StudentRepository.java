package com.aurionpro.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.jpa.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	List<Student> findByName(String name);
	Page<Student> findByName(String name, Pageable pageable);
	List<Student> findByAge(int age);
}
