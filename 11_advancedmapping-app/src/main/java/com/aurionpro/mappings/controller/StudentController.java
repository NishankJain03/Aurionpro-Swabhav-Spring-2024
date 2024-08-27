package com.aurionpro.mappings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.mappings.dto.PageResponse;
import com.aurionpro.mappings.dto.StudentDto;
import com.aurionpro.mappings.entity.Address;
import com.aurionpro.mappings.entity.Course;
import com.aurionpro.mappings.entity.Student;
import com.aurionpro.mappings.service.StudentService;

@RestController
@RequestMapping("/studentapp")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/students")
	public ResponseEntity<StudentDto> addNewStudent(@RequestBody Student student){
		return ResponseEntity.ok(studentService.addStudent(student));
	}
	
	@GetMapping("/getAllStudent")
	public ResponseEntity<PageResponse<StudentDto>> getAllStudents(@RequestParam int pageNumber, @RequestParam int pageSize){
		return ResponseEntity.ok(studentService.getAllStudents(pageNumber,pageSize));
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getStudent(){
		return ResponseEntity.ok(studentService.getAllStudent());
	}
	
	@GetMapping("/address/{rollnumber}")
	public ResponseEntity<Address> getAddress(@PathVariable int rollnumber){
		return ResponseEntity.ok(studentService.getStudentAddress(rollnumber));
	}
	
	@PutMapping("/address")
	public String updateAddress(@RequestParam int rollnumber, @RequestParam String city){
		studentService.updateStudentAddress(rollnumber, city);
		return "Updated the record";
	}
	
	@PostMapping("/student/course")
	public ResponseEntity<StudentDto> assignCourse(@RequestParam int rollNumber, @RequestBody List<Integer> courseIds){
		return ResponseEntity.ok(studentService.assignCourses(rollNumber, courseIds));
	}
	
	@GetMapping("/get/student/instructor")
	public ResponseEntity<List<StudentDto>> getStudentInstructor(@RequestParam int instructorId){
		return ResponseEntity.ok(studentService.getStudentInstructor(instructorId));
	}
}
