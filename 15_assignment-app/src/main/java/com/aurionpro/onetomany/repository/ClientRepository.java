package com.aurionpro.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.onetomany.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{

}
