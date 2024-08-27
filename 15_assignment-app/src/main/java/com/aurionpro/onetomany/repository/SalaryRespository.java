package com.aurionpro.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.onetomany.entity.Salary;

public interface SalaryRespository extends JpaRepository<Salary, Integer>{

}
