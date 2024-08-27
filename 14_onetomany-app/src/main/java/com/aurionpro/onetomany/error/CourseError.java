package com.aurionpro.onetomany.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseError {
	private int statusCode;
	private String errorMessage;
	private long timeStamp;
}
