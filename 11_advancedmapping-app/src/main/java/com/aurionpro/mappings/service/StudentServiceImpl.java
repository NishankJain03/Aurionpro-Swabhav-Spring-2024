package com.aurionpro.mappings.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aurionpro.mappings.dto.PageResponse;
import com.aurionpro.mappings.dto.StudentDto;
import com.aurionpro.mappings.entity.Address;
import com.aurionpro.mappings.entity.Course;
import com.aurionpro.mappings.entity.Instructor;
import com.aurionpro.mappings.entity.Student;
import com.aurionpro.mappings.repository.CourseRespository;
import com.aurionpro.mappings.repository.InstructorRepository;
import com.aurionpro.mappings.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRespository courseRespository;
	
	@Autowired
	private InstructorRepository instructorRepository;
	
	@Override
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}
	@Override
	public Address getStudentAddress(int rollnumber) {
		Student studentObj1 = studentRepository.findById(rollnumber).orElse(null);
		return studentObj1.getAddress();	
	}
	@Override
	public Address updateStudentAddress(int rollnumber, String city) {
		Student studentObj1 = studentRepository.findById(rollnumber).orElse(null);
		studentObj1.getAddress().setCity(city);
		studentRepository.save(studentObj1);
		return studentObj1.getAddress();
	}
	
	public Student toStudentMapper(StudentDto studentDto) {
		Student student = new Student();
		student.setName(studentDto.getName());
		student.setAge(studentDto.getRollnumber());
		return student;
	}
	
	public StudentDto toStudentDtoMapper(Student student) {
		StudentDto studentDto = new StudentDto();
		studentDto.setRollnumber(student.getRollnumber());
		studentDto.setName(student.getName());
		studentDto.setAge(student.getAge());
		return studentDto;
	}
	
	@Override
	public StudentDto addStudent(Student student) {
		Student dbStudent = studentRepository.save(student);
		return toStudentDtoMapper(student);
	}
	@Override
	public PageResponse<StudentDto> getAllStudents(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Student> studentPage = studentRepository.findAll(pageable);
		
		PageResponse<StudentDto> response = new PageResponse<>();
		response.setTotalPages(studentPage.getTotalPages());
		response.setTotalElements(studentPage.getTotalPages());
		response.setLastPage(studentPage.isLast());
		response.setSize(studentPage.getSize());
		
		List<StudentDto> studentDtoList = new ArrayList<>();
		studentPage.getContent().forEach((student) -> {
			studentDtoList.add(toStudentDtoMapper(student));
		});
		response.setContents(studentDtoList);
		return response;
	}
	@Override
	public StudentDto getStudentByRollNumber(int rollnumber) {
		Student student = studentRepository.findById(rollnumber).orElseThrow(() -> new NullPointerException("Student Not found"));
		return toStudentDtoMapper(student);
	}
	@Override
	public StudentDto assignCourses(int rollnumber, List<Integer> courseIds) {
		Student student = studentRepository.findById(rollnumber).orElseThrow(() -> new NullPointerException("Student not Found"));
		
		Set<Course> existingCourses = student.getCourses();
		if (existingCourses == null)
			existingCourses = new HashSet<>();
			
		Set<Course> coursesToAdd = new HashSet<>();
		
		courseIds.forEach((courseId) -> {
			Course course = courseRespository.findById(courseId).orElseThrow(() -> new NullPointerException("Course not found"));
			List<Student> existingStudent = course.getStudents();
			if(existingStudent == null)
				existingStudent = new ArrayList<>();
			
			existingStudent.add(student);
			coursesToAdd.add(course);
		});
		
		existingCourses.addAll(coursesToAdd);
		student.setCourses(existingCourses);
		
		return toStudentDtoMapper(studentRepository.save(student));
	}
	@Override
	public List<StudentDto> getStudentInstructor(int instructorId) {
		Instructor instructor = instructorRepository.findById(instructorId).orElseThrow(() -> new NullPointerException("Instructor Not Found"));
		
//		List<Course> existingCourse = instructor.getCourses();
//		List<Student> courseStudent = new ArrayList<>();
//		List<StudentDto> studentDtos = new ArrayList<>();
//		
//		existingCourse.forEach((course) -> {
//			List<Student> dbStudent = course.getStudents();
//			dbStudent.forEach((student) -> {
//				courseStudent.add(student);
//			});
//		});
//		courseStudent.forEach((courseStu)->{
//			StudentDto dbStudentDto = toStudentDtoMapper(courseStu);
//			studentDtos.add(dbStudentDto);
//		});
//		return studentDtos;		
		return instructor.getCourses().stream()
	            .flatMap(course -> course.getStudents().stream())
	            .map(this::toStudentDtoMapper)
	            .collect(Collectors.toList());
		
	}
	
	

}
