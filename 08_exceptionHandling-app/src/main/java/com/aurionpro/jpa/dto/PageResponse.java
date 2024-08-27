package com.aurionpro.jpa.dto;

import java.util.List;

import com.aurionpro.jpa.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PageResponse {
	private long totalElements;
	private int totalPAges;
	private int sze;
	private List<Student> contents;
	private boolean isLastPage;
}
