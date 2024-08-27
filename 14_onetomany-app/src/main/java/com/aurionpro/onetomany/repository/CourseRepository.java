package com.aurionpro.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.onetomany.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

}
