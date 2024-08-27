package com.aurionpro.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.onetomany.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer>{

}
