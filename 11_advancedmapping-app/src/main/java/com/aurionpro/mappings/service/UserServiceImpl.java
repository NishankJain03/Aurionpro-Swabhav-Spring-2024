package com.aurionpro.mappings.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.mappings.dto.UserDto;
import com.aurionpro.mappings.entity.Role;
import com.aurionpro.mappings.entity.User;
import com.aurionpro.mappings.repository.RoleRepository;
import com.aurionpro.mappings.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	public User toUserMapper(UserDto userDto) {
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		return user;
	}
	
	public UserDto ToUserDtoMapper(User user) {
		UserDto userDto = new UserDto();
		userDto.setUserId(user.getUserId());
		userDto.setUsername(user.getUsername());
		userDto.setPassword(user.getPassword());
		return userDto;
	}
	@Override
	public UserDto addUser(User user) {
		User dbUser = userRepository.save(user);
		
		return ToUserDtoMapper(dbUser);
	}

	@Override
	public UserDto getUserById(int userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new NullPointerException("User Not Found"));
		return ToUserDtoMapper(user);
	}

	@Override
	public UserDto assignRole(int userId, List<Integer> roleIds) {
		User user = userRepository.findById(userId).orElseThrow(() -> new NullPointerException("User Not Found"));
		
		List<Role> existingRole = user.getRoles();
		if(existingRole == null)
			existingRole = new ArrayList<>();
		
		List<Role> rolesToAdd = new ArrayList<>();
		
		roleIds.forEach((role) -> {
			Role dbRole = roleRepository.findById(role).orElseThrow(() -> new NullPointerException("Role Not Found"));
			List<User> existingUsers = dbRole.getUsers();
			if(existingUsers == null)
				existingUsers = new ArrayList<>();
			
			existingUsers.add(user);
			rolesToAdd.add(dbRole);
		});
		existingRole.addAll(rolesToAdd);
		user.setRoles(existingRole);
		return ToUserDtoMapper(userRepository.save(user));
	}

}
