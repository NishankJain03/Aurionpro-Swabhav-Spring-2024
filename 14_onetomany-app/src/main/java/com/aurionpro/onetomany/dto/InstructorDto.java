package com.aurionpro.onetomany.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class InstructorDto {
	
	private int instructorId;	
	
	private String instructorName;
	
	private String email;
	
	private String qualification;
}
