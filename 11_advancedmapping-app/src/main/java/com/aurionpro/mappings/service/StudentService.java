package com.aurionpro.mappings.service;

import java.util.List;

import com.aurionpro.mappings.dto.PageResponse;
import com.aurionpro.mappings.dto.StudentDto;
import com.aurionpro.mappings.entity.Address;
import com.aurionpro.mappings.entity.Course;
import com.aurionpro.mappings.entity.Student;

public interface StudentService {
	StudentDto addStudent(Student student);
	List<Student> getAllStudent();
	Address getStudentAddress(int rollnumber);
	Address updateStudentAddress(int rollnumber, String city);
	
	PageResponse<StudentDto> getAllStudents(int pageNumber, int pageSize);
	StudentDto getStudentByRollNumber(int rollnumber);
	StudentDto assignCourses(int rollnumber, List<Integer> courseIds);
	
	List<StudentDto> getStudentInstructor(int instructorId);
}
