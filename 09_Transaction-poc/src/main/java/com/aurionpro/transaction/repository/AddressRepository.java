package com.aurionpro.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.transaction.entity.Address;

public interface AddressRepository extends  JpaRepository<Address, Integer>{
	
}
