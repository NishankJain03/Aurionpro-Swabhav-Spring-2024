package com.aurionpro.di.entity;

import org.springframework.beans.factory.annotation.Value;

public class Hardisk {
	@Value("20")
	private int capacity;

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Hardisk(int capacity) {
		super();
		this.capacity = capacity;
	}
	
	public Hardisk() {
		
	}

	@Override
	public String toString() {
		return "Hardisk [capacity=" + capacity + "]";
	}
	
	
}	
