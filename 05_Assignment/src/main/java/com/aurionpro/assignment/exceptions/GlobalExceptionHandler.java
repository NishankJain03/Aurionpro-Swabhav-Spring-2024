package com.aurionpro.assignment.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {
	private ErrorMessage errorMessage;
	
	@ExceptionHandler
	public ResponseEntity<?> handleNotFoundException(MethodArgumentNotValidException exception){
		Map<String, String> errors = new HashMap<>();
		exception.getBindingResult().getFieldErrors().forEach((error) -> {
			errors.put(error.getField(), error.getDefaultMessage());
		});
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorMessage> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception){
		errorMessage = new ErrorMessage();
		errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setErrorMessage("Date should be in the format of yyyy-mm-dd");
		errorMessage.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorMessage> handleConstraintViolationException(ConstraintViolationException exception){
		errorMessage = new ErrorMessage();
		errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setErrorMessage(errorMessage.getErrorMessage());
		errorMessage.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
	}
}
