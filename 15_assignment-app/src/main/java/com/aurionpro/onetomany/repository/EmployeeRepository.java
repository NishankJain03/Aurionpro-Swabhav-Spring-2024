package com.aurionpro.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.onetomany.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
