package com.aurionpro.onetomany.service;

import java.util.List;

import com.aurionpro.onetomany.dto.CourseDto;
import com.aurionpro.onetomany.entity.Course;
import com.aurionpro.onetomany.entity.Instructor;

public interface CourseService {
	Course addCourse(CourseDto courseDto);
	
	List<CourseDto> getAllCourses();
	
	CourseDto getCourseById(int courseId);

	Course allocateInstructor(int courseId, Instructor instructor);
}
