package com.aurionpro.jwtsecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.jwtsecurity.entity.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByUsername(String username);
	boolean existsByUsername(String username);
}
