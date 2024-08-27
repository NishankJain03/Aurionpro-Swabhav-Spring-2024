package com.aurionpro.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.assignment.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
}