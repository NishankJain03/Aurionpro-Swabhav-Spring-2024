package com.aurionpro.jpa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.aurionpro.jpa.errors.StudentError;

@ControllerAdvice
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<StudentError> handleNotFoundException(StudentException exception){
		StudentError studentError = new StudentError();
		studentError.setStatusCode(HttpStatus.NOT_FOUND.value());
		studentError.setErrorMessage(exception.getMessage());
		studentError.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(studentError, HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<StudentError> handleNotFoundException(MethodArgumentTypeMismatchException exception){
		StudentError studentError = new StudentError();
		studentError.setStatusCode(HttpStatus.BAD_REQUEST.value());
		studentError.setErrorMessage("Roll number must be integer");
		studentError.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(studentError, HttpStatus.BAD_REQUEST);
	}
}
