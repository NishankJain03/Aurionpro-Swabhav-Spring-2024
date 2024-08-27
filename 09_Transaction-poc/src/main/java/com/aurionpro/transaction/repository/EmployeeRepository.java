package com.aurionpro.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.transaction.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
