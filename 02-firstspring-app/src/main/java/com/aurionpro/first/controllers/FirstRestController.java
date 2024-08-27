package com.aurionpro.first.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstRestController {
	
	
	//this method should work on particular request the base url we don't need to define
	@GetMapping("/hello")
	//request handler method
	public String sayHello() {
		return "Hello, Welcome to Spring Boot";
	}
	
	@GetMapping("hello/bye")
	public String sayBye() {
		return "Goodbye";
	}
}
