package com.aurionpro.jwtsecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.jwtsecurity.entity.Role;


public interface RoleRepository extends JpaRepository<Role, Integer>{
	Optional<Role> findByRolename(String rolename);
}
