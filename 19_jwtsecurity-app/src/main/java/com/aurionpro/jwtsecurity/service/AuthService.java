package com.aurionpro.jwtsecurity.service;

import com.aurionpro.jwtsecurity.dto.LoginDto;
import com.aurionpro.jwtsecurity.dto.RegistrationDto;
import com.aurionpro.jwtsecurity.entity.User;

public interface AuthService {
	User register(RegistrationDto registrationDto);
	String login(LoginDto loginDto);
}
