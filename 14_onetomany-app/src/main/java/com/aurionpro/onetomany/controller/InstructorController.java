package com.aurionpro.onetomany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.onetomany.dto.CourseDto;
import com.aurionpro.onetomany.dto.InstructorDto;
import com.aurionpro.onetomany.dto.PageResponse;
import com.aurionpro.onetomany.entity.Course;
import com.aurionpro.onetomany.entity.Instructor;
import com.aurionpro.onetomany.service.InstructorService;

@RestController
@RequestMapping("/studentapp")
public class InstructorController {
	
	@Autowired
	private InstructorService instructorService;
	
	@PostMapping("/instructor")
	public  ResponseEntity<InstructorDto> addInstructor(@RequestBody InstructorDto instructorDto) {
		return ResponseEntity.ok(instructorService.addInstructor(instructorDto));
	}
	@PutMapping("/instructors/courses")
	public ResponseEntity<Instructor> allocateCourse(@RequestParam int instructorId, @RequestBody List<Course> course){
		return ResponseEntity.ok(instructorService.allocateCourses(instructorId, course));
	}
	
	@GetMapping("/pageinstructor")
	public PageResponse<InstructorDto> getAllInstructor(@RequestParam int pageNumber, @RequestParam int pageSize){
		return instructorService.getAllInstructor(pageNumber, pageSize);
	}
	
	@GetMapping("/getinstructor")
	public ResponseEntity<InstructorDto> getInstructor(@RequestParam int instructorId){
		return ResponseEntity.ok(instructorService.getInstructor(instructorId));
	}
	
}
