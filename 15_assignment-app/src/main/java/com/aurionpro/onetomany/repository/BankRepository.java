package com.aurionpro.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.onetomany.entity.Bank;

public interface BankRepository extends JpaRepository<Bank, Integer>{

}
