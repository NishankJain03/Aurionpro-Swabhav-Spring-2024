package com.aurionpro.jpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.aurionpro.jpa.dto.PageResponse;
import com.aurionpro.jpa.entity.Student;
import com.aurionpro.jpa.service.StudentService;

@RestController
@RequestMapping("/studentApp")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public ResponseEntity<PageResponse> getAllStudents(@RequestParam int pageNumber, @RequestParam int pageSize){
		return ResponseEntity.ok(studentService.getAllStudents(pageNumber, pageSize));
	}
	
	@GetMapping("/students/{rollnumber}")
	public ResponseEntity<Student> getByRollnumber(@PathVariable int rollnumber){
		return ResponseEntity.ok(studentService.getByRollNumber(rollnumber));
	}
	
	@PutMapping("/students")
	public String updateStudent(@RequestBody Student student) {
		studentService.updateStudent(student);
		return "Updated Successfully";
	}
	
	
	@DeleteMapping("/students")
	public String deleteStudent(@RequestBody Student student) {
		studentService.deleteStudent(student);
		return "Deleted Successfully";
	}
	
	@PostMapping("/students")
	public String addStudent(@RequestBody Student student) {
		studentService.addStudent(student);
		return "Added successfully";
	}
	
	@GetMapping("/student/name")
	public ResponseEntity<List<Student>> findByName(@RequestParam(required = false) String name){
		return ResponseEntity.ok(studentService.getByName(name));
	}
	
	@GetMapping("/student/age/{age}")
	public ResponseEntity<List<Student>> findByAge(@PathVariable int age){
		return ResponseEntity.ok(studentService.getByAge(age));
	}
	
	@GetMapping("/students/name")
	public ResponseEntity<PageResponse> getAllStudentsByName(@RequestParam String name, @RequestParam int pageNumber, @RequestParam int pageSize){
		return ResponseEntity.ok(studentService.getAllStudentsByName(name, pageNumber, pageSize));
	}
	
	
}	
