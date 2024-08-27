package com.aurionpro.onetomany.dto;

import java.util.List;

import org.springframework.data.domain.Page;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PageResponse<T> {
	private long totalElements;
	private int totalPAges;
	private int size;
	private List<T> contents;
	private boolean isLastPage;
	
	public PageResponse(Page<T> page) {
		this.totalElements = page.getTotalElements();
		this.totalPAges = page.getTotalPages();
		this.contents = page.getContent();
		this.size = page.getSize();
	}
	
	
}
