package com.aurionpro.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.client.entity.Client;
import com.aurionpro.client.entity.KycStatus;
import com.aurionpro.client.service.ClientService;

@RestController
@RequestMapping("/clientapp")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/client")
	public Page<Client> getAllClient(@RequestParam int pageNumber, @RequestParam int pageSize){
		return clientService.getAllClient(pageNumber, pageSize);
	}
	
	@PostMapping("/client")
	public String addClient(@RequestBody Client client) {
		clientService.addClient(client);
		return "Client added successfully";
	}
	
	@GetMapping("/allclients")
	public ResponseEntity<List<Client>> getAllClients(){
		return ResponseEntity.ok(clientService.getAllClients());
	}
	
	@PutMapping("/updateclient")
	public String updateClient(@RequestBody Client client) {
		clientService.updateClient(client);
		return "Client updated successfully";
	}
	
	@DeleteMapping("/deleteclient")
	public String deleteClient(@RequestBody Client client) {
		clientService.deleteClient(client);
		return "Deleted successfully";
	}
	
	@GetMapping("/address")
	public ResponseEntity<List<Client>> findByAddress(@RequestParam String address){
		return ResponseEntity.ok(clientService.getAddress(address));
	}
	
	@GetMapping("/companyName")
	public ResponseEntity<List<Client>> findByCompanyName(@RequestParam String companyName){
		return ResponseEntity.ok(clientService.getCompanyName(companyName));
	}
}
