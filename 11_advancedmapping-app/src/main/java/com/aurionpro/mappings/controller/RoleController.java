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
import com.aurionpro.mappings.entity.Role;
import com.aurionpro.mappings.entity.User;
import com.aurionpro.mappings.service.RoleService;

@RestController
@RequestMapping("/studentapp")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping("/addRole")
	public ResponseEntity<RoleDto> addRole(@RequestBody Role role){
		return ResponseEntity.ok(roleService.addRole(role));
	}
	
	@GetMapping("/getRoleById")
	public ResponseEntity<RoleDto> getById(@RequestParam int roleId){
		return ResponseEntity.ok(roleService.getRoleById(roleId));
	}
	
	@PutMapping("/assignUser")
	public ResponseEntity<RoleDto> assignUser(@RequestParam int roleId, @RequestBody List<Integer> userIds){
		return ResponseEntity.ok(roleService.assignRole(roleId, userIds));
	}
}
