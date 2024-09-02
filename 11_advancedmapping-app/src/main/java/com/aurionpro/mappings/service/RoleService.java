package com.aurionpro.mappings.service;

import java.util.List;

import com.aurionpro.mappings.dto.RoleDto;
import com.aurionpro.mappings.entity.Role;

public interface RoleService {
	RoleDto addRole(Role role);
	RoleDto getRoleById(int roleId);
	
	RoleDto  assignRole(int roleId, List<Integer> userIds);
}
