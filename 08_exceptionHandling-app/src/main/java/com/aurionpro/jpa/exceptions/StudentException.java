package com.aurionpro.jpa.exceptions;

public class StudentException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "You are searching for is not present";
	}
}
