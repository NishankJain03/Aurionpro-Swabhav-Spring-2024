package com.aurionpro.mappings.service;

import java.util.List;

import com.aurionpro.mappings.dto.CourseDto;

public interface CourseService {
	CourseDto assignStudents(int courseId, List<Integer> rollNumbers);
	List<CourseDto> getCourseInstructor(int instructorId); 
}
