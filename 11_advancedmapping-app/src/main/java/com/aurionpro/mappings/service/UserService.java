package com.aurionpro.mappings.service;

import java.util.List;

import com.aurionpro.mappings.dto.UserDto;
import com.aurionpro.mappings.entity.User;

public interface UserService {
	UserDto addUser(User user);
	
	UserDto getUserById(int userId);
	
	UserDto assignRole(int userId, List<Integer> roleIds);
}
