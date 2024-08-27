package com.aurionpro.onetomany.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.aurionpro.onetomany.dto.CourseDto;
import com.aurionpro.onetomany.dto.InstructorDto;
import com.aurionpro.onetomany.dto.PageResponse;
import com.aurionpro.onetomany.entity.Course;
import com.aurionpro.onetomany.entity.Instructor;

public interface InstructorService {
	InstructorDto addInstructor(InstructorDto instructorDto);
	
	InstructorDto getInstructor(int instructorId);
	
	List<CourseDto> getInstructorCourses(int instructorId);
	
	PageResponse<InstructorDto> getAllInstructor(int pageNumber, int pageSize);

	Instructor allocateCourses(int instructorId, List<Course> course);

}
