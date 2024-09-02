package com.aurionpro.mappings.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.mappings.dto.CourseDto;
import com.aurionpro.mappings.entity.Course;
import com.aurionpro.mappings.entity.Instructor;
import com.aurionpro.mappings.entity.Student;
import com.aurionpro.mappings.repository.CourseRespository;
import com.aurionpro.mappings.repository.InstructorRepository;
import com.aurionpro.mappings.repository.StudentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRespository courseRespository;
	
	private static final Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);
	
	@Autowired
	private InstructorRepository instructorRepository;
	public Course toCourseMapper(CourseDto courseDto) {
		Course course = new Course();
		course.setCourseName(courseDto.getCourseName());
		course.setDuration(courseDto.getDuration());
		course.setFees(courseDto.getFees());
		return course;
	}
	
	public CourseDto toCourseDtoMapper(Course course) {
		CourseDto courseDto = new CourseDto();
		courseDto.setCourseName(course.getCourseName());
		courseDto.setDuration(course.getDuration());
		courseDto.setFees(course.getFees());
		return courseDto;
	}

	@Override
	public CourseDto assignStudents(int courseId, List<Integer> rollNumbers) {
		Course dbCourse = courseRespository.findById(courseId).orElseThrow(() -> new NullPointerException("Course not Found"));
		
		List<Student> existingStudents = dbCourse.getStudents();
		if(existingStudents == null)
			existingStudents = new ArrayList<>();
		
		List<Student> studentsToAdd = new ArrayList<>();
		
		rollNumbers.forEach((rollNumber) -> {
			Student student = studentRepository.findById(rollNumber).orElseThrow(() -> new NullPointerException("Course not Found"));
			
			Set<Course> existingCourse = student.getCourses();
			if(existingCourse == null)
				existingCourse = new HashSet<>();
			
			existingCourse.add(dbCourse);
			studentsToAdd.add(student);
		});
		existingStudents.addAll(studentsToAdd);
		dbCourse.setStudents(existingStudents);
		return toCourseDtoMapper(courseRespository.save(dbCourse));
		
	}

	@Override
	public List<CourseDto> getCourseInstructor(int instructorId) {
		Instructor instructor = instructorRepository.findById(instructorId).orElseThrow(() -> new NullPointerException("Instructor Not Found"));
		return instructor.getCourses().stream()
					.map(this :: toCourseDtoMapper)
					.collect(Collectors.toList());
	}
	
	

}
