package com.aurionpro.di.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.di.entity.Computer;
import com.aurionpro.di.entity.Hardisk;

@RestController
public class ComputerController {
	//it is possible only when computer class is bean
	@Autowired
	private Computer computer;
	
	@Autowired
	private Hardisk hardisk;
	
	
	@GetMapping("/computers")
	public Computer getComputer() {
		return computer;
	}
	
	@GetMapping("/hardisk")
	public Hardisk getHardisk() {
		return hardisk;
	}
}
