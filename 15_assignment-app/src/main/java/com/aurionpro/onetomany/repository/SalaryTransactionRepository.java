package com.aurionpro.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.onetomany.entity.SalaryTransaction;

public interface SalaryTransactionRepository extends JpaRepository<SalaryTransaction, Integer>{

}
