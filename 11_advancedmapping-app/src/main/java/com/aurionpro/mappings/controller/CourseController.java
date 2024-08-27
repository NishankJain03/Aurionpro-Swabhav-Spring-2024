package com.aurionpro.mappings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.mappings.dto.CourseDto;
import com.aurionpro.mappings.service.CourseService;

@RestController
@RequestMapping("/studentapp")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@PutMapping("/course/student")
	public ResponseEntity<CourseDto> assignStudent(@RequestParam int courseId, @RequestBody List<Integer> rollNumbers){
		return ResponseEntity.ok(courseService.assignStudents(courseId, rollNumbers));
	}
	
	@GetMapping("/get/course/instructor")
	public ResponseEntity<List<CourseDto>> getInstructorCourse(@RequestParam int instructorId){
		return ResponseEntity.ok(courseService.getCourseInstructor(instructorId));
	}
}
