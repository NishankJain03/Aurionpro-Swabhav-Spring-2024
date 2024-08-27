package com.aurionpro.onetomany.controller;

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

import com.aurionpro.onetomany.entity.Client;
import com.aurionpro.onetomany.entity.Employee;
import com.aurionpro.onetomany.service.ClientService;

@RestController
@RequestMapping("/bankapp")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@PostMapping("/addClient")
	public ResponseEntity<Client> addClient(@RequestBody Client client){
		return ResponseEntity.ok(clientService.addClient(client));
	}
	
	@PutMapping("/employeeAdd/client")
	public ResponseEntity<Client> addEmployeeToClient(@RequestParam int clientId, @RequestBody List<Employee> employee){
		return ResponseEntity.ok(clientService.addEmployeeToClient(clientId, employee));
	}
	
	@GetMapping("/getAllClient")
	public ResponseEntity<List<Client>> getAllClient(){
		return ResponseEntity.ok(clientService.getAllClient());
	}
}
