package com.aurionpro.onetomany.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.onetomany.dto.CourseDto;
import com.aurionpro.onetomany.entity.Course;
import com.aurionpro.onetomany.entity.Instructor;
import com.aurionpro.onetomany.repository.CourseRepository;
import com.aurionpro.onetomany.repository.InstructorRepository;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private InstructorRepository instructorRepository;

	@Override
	public Course addCourse(CourseDto courseDto) {
		Course course = new Course();
		course.setCourseName(courseDto.getCourseName());
		course.setDuration(courseDto.getDuration());
		course.setFees(courseDto.getFees());
		return courseRepository.save(course);
	}

	@Override
	public Course allocateInstructor(int courseId, Instructor instructor) {
		Course course = courseRepository.findById(courseId).orElseThrow(() -> new NullPointerException("Course not found"));
		Instructor OptionalInstructor = instructorRepository.findById(instructor.getInstructorId()).orElseThrow(() -> new NullPointerException("Instructor not found"));
		course.setInstructor(OptionalInstructor);
		
		return courseRepository.save(course);
	}
	
	public Course toCourseMapper(CourseDto courseDto) {
		Course course = new Course();
		course.setCourseName(courseDto.getCourseName());
		course.setDuration(courseDto.getDuration());
		course.setFees(courseDto.getFees());
		return course;
	}
	
	public CourseDto toCourseDtoMapper(Course course) {
		CourseDto courseDto = new CourseDto();
		courseDto.setCourseId(course.getCourseId());
		courseDto.setCourseName(course.getCourseName());
		courseDto.setDuration(course.getDuration());
		courseDto.setFees(course.getFees());
		return courseDto;
	}

	@Override
	public List<CourseDto> getAllCourses() {
		List<Course> optionalCourse = courseRepository.findAll();
		List<CourseDto> courseDto = new ArrayList<>();
		for(Course dbCourse : optionalCourse) {
			courseDto.add(toCourseDtoMapper(dbCourse));
		}
		return courseDto;
 	}

	@Override
	public CourseDto getCourseById(int courseId) {
		Course optionalCourse = courseRepository.findById(courseId).orElseThrow(()-> new NullPointerException("Course not Found"));
		return toCourseDtoMapper(optionalCourse);
	}

	
	
}
