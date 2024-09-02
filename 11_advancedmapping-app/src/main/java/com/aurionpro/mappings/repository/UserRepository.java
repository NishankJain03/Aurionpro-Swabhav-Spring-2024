package com.aurionpro.mappings.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.mappings.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
