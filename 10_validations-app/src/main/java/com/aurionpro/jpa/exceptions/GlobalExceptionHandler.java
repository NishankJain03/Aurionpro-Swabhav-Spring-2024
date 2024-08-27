package com.aurionpro.jpa.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.bind.annotation.ExceptionHandler;


import com.aurionpro.jpa.errors.StudentError;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<StudentError> handleNotFoundException(StudentException exception){
		StudentError studentError = new StudentError();
		studentError.setStatusCode(HttpStatus.NOT_FOUND.value());
		studentError.setErrorMessage(exception.getMessage());
		studentError.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(studentError, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentError> handleNotFoundException(MethodArgumentTypeMismatchException exception){
		StudentError studentError = new StudentError();
		studentError.setStatusCode(HttpStatus.BAD_REQUEST.value());
		studentError.setErrorMessage("Roll number must be integer");
		studentError.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(studentError, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<?> handleNotFoundException(MethodArgumentNotValidException exception){
		Map<String, String> errors = new HashMap<>();
		exception.getBindingResult().getFieldErrors().forEach((error) -> {
			errors.put(error.getField(), error.getDefaultMessage());
		});
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		
	}
}
