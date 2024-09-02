package com.aurionpro.mappings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.mappings.dto.RoleDto;
import com.aurionpro.mappings.dto.UserDto;
import com.aurionpro.mappings.entity.User;
import com.aurionpro.mappings.service.UserService;

@RestController
@RequestMapping("/studentapp")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/addUser")
	public ResponseEntity<UserDto> addUser(@RequestBody User user){
		return ResponseEntity.ok(userService.addUser(user));
	}
	
	@GetMapping("/getUserById")
	public ResponseEntity<UserDto> getUserById(@RequestParam int userId){
		return ResponseEntity.ok(userService.getUserById(userId));
	}
	
	@PutMapping("/AddRoleUser")
	public ResponseEntity<UserDto> assignRole(@RequestParam int userId, @RequestBody List<Integer> roleIds){
		return ResponseEntity.ok(userService.assignRole(userId, roleIds));
	}
}
