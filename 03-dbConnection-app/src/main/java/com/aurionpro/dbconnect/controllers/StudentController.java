package com.aurionpro.dbconnect.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.dbconnect.entity.Student;
import com.aurionpro.dbconnect.repository.StudentRepository;
import com.aurionpro.dbconnect.service.IStudentService;

@RestController
public class StudentController {
	
	@Autowired
	private IStudentService iStudentService;
	
	@GetMapping("/students")
	public ResponseEntity <List<Student>> getAllStudents(){
		return ResponseEntity.ok(iStudentService.getAllStudents());
	}
	
	@GetMapping("/students/{rollnumber}")
	public ResponseEntity<Student> getStudent(@PathVariable int rollnumber){
		return ResponseEntity.ok(iStudentService.getStudent(rollnumber));
	}
	
	@PostMapping("/students")
	public String addStudent(@RequestBody Student student) {
		iStudentService.addStudent(student);
		return "Record added successfully";
	}
	
	@GetMapping("/students/name")
	public ResponseEntity<List<Student>> getStudentByName(@RequestParam String name){
		return ResponseEntity.ok(iStudentService.getStudentByName(name));
	}
}
