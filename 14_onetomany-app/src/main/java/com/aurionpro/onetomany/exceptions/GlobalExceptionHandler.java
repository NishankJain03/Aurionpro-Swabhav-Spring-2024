package com.aurionpro.onetomany.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.aurionpro.onetomany.error.CourseError;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<CourseError> handleNullPointerException(NullPointerException exception){
		CourseError courseError = new CourseError();
		courseError.setStatusCode(HttpStatus.BAD_REQUEST.value());
		courseError.setErrorMessage(exception.getMessage());
		courseError.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(courseError, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<CourseError> handleNotFoundException(MethodArgumentTypeMismatchException exception){
		CourseError courseError = new CourseError();
		courseError.setStatusCode(HttpStatus.BAD_REQUEST.value());
		courseError.setErrorMessage("id number must be integer");
		courseError.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(courseError, HttpStatus.BAD_REQUEST);
	}
}
