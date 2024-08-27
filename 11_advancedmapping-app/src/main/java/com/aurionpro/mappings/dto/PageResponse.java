package com.aurionpro.mappings.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageResponse<T> {
	private long totalElements;
	private int totalPages;
	private int size;
	private List<T> contents;
	private boolean isLastPage;
	
	public PageResponse(Page<T> page) {
		this.totalElements = page.getTotalElements();
		this.totalPages = page.getTotalPages();
		this.contents = page.getContent();
		this.size = page.getSize();
	}
	
	
}
