package com.aurionpro.mappings.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class InstructorDto {
	
	private int instructorId;	
	
	private String instructorName;
	
	private String email;
	
	private String qualification;
}
