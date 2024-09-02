package com.aurionpro.mappings.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.mappings.dto.RoleDto;
import com.aurionpro.mappings.entity.Role;
import com.aurionpro.mappings.entity.User;
import com.aurionpro.mappings.repository.RoleRepository;
import com.aurionpro.mappings.repository.UserRepository;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Role toRoleMapper(RoleDto rDto) {
		Role role = new Role();
		role.setRolename(rDto.getRolename());
		return role;
	}
	
	public RoleDto toRoleDtoMapper(Role role) {
		RoleDto roleDto = new RoleDto();
		roleDto.setRoleId(role.getRoleId());
		roleDto.setRolename(role.getRolename());
		return roleDto;
	}
	
	@Override
	public RoleDto addRole(Role role) {
		Role dbRole = roleRepository.save(role);
		return toRoleDtoMapper(dbRole);
	}

	@Override
	public RoleDto getRoleById(int roleId) {
		Role role = roleRepository.findById(roleId).orElseThrow(() -> new NullPointerException());
		return toRoleDtoMapper(role);
	}

	@Override
	public RoleDto assignRole(int roleId, List<Integer> userIds) {
		Role role = roleRepository.findById(roleId).orElseThrow(() -> new NullPointerException("Role not found"));
		 List<User> existingUser = role.getUsers();
		 
		 List<User> usersToAdd = new ArrayList<>();
		 
		 userIds.forEach((userId)->{
			 User user = userRepository.findById(userId).orElseThrow(() -> new NullPointerException("Role not found"));
			 List<Role> existingRoles = user.getRoles();
			 
			 existingRoles.add(role);
			 usersToAdd.add(user);
		 });
		 existingUser.addAll(usersToAdd);
		 role.setUsers(existingUser);
		 return toRoleDtoMapper(roleRepository.save(role));
		 
	}

}
