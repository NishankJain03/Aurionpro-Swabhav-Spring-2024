package com.aurionpro.di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aurionpro.di.entity.Computer;
import com.aurionpro.di.entity.Hardisk;

@Configuration
public class ApplicationConfig {
	
	//we can apply bean on method level
	@Bean
	public Computer getComputer() {
		return new Computer();
	}
	
	@Bean
	Hardisk getHardisk() {
		return new Hardisk();
	}
}
