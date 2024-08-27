package com.aurionpro.di.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


public class Computer {
	@Value("Apple")
	private String name;
	
	@Autowired
	private Hardisk hardisk;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Hardisk getHardisk() {
		return hardisk;
	}
	public void setHardisk(Hardisk hardisk) {
		this.hardisk = hardisk;
	}
	public Computer(String name, Hardisk hardisk) {
		super();
		this.name = name;
		this.hardisk = hardisk;
	}
	
	public Computer() {
		
	}
	@Override
	public String toString() {
		return "Computer [name=" + name + ", hardisk=" + hardisk + "]";
	}
	
	
}
