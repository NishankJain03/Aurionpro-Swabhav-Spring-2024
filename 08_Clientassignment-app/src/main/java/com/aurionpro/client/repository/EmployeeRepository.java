package com.aurionpro.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.client.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
