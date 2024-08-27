package com.aurionpro.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.client.entity.Client;
import com.aurionpro.client.entity.KycStatus;

public interface ClientRepository extends JpaRepository<Client, Integer>{
	List<Client> findByAddress(String address);
	List<Client> findByCompanyName(String companyName);
}