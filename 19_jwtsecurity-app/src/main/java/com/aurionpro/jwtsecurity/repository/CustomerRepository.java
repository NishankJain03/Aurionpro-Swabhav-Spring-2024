package com.aurionpro.jwtsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.jwtsecurity.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
