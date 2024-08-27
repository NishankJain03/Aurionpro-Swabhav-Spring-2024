package com.aurionpro.jpa.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentError {
	//whenever exception we will send this object
	private int statusCode;
	private String errorMessage;
	private long timeStamp;
	
}
