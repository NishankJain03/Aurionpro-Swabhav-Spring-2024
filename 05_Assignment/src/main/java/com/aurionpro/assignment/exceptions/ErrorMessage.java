package com.aurionpro.assignment.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
	
	private int statusCode;
	private String errorMessage;
	private long timeStamp;
}
