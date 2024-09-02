package com.aurionpro.jwtsecurity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.aurionpro.jwtsecurity.dto.LoginDto;
import com.aurionpro.jwtsecurity.dto.RegistrationDto;
import com.aurionpro.jwtsecurity.entity.Role;
import com.aurionpro.jwtsecurity.entity.User;
import com.aurionpro.jwtsecurity.exception.UserApiException;
import com.aurionpro.jwtsecurity.repository.RoleRepository;
import com.aurionpro.jwtsecurity.repository.UserRepository;
import com.aurionpro.jwtsecurity.security.JwtTokenProvider;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtTokenProvider tokenProvider;
	@Override
	public User register(RegistrationDto registrationDto) {
		if(userRepository.existsByUsername(registrationDto.getUsername()))
			throw new UserApiException(HttpStatus.BAD_REQUEST, "User Already Exits");
		
		User user = new User();
		user.setUsername(registrationDto.getUsername());
		user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
		
		List<Role> roles = new ArrayList<>();
		Role userRole = roleRepository.findByRolename(registrationDto.getRole()).get();
		roles.add(userRole);
		user.setRoles(roles);
		return userRepository.save(user);
	}

	@Override
	public String login(LoginDto loginDto) {
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String token = tokenProvider.generateToken(authentication);
			return token;
			
		}catch(BadCredentialsException e) {
			throw new UserApiException(HttpStatus.NOT_FOUND, "Username and Password is incorrect");
		}
	}

}
