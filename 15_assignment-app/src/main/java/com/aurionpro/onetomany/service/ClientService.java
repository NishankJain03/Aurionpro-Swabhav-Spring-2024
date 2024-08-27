package com.aurionpro.onetomany.service;

import java.util.List;

import com.aurionpro.onetomany.entity.Client;
import com.aurionpro.onetomany.entity.Employee;

public interface ClientService {
	Client addClient(Client client);
	Client addEmployeeToClient(int clientId, List<Employee> employees);
	List<Client> getAllClient();
}	
