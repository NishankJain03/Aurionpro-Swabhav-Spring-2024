package com.aurionpro.onetomany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.onetomany.entity.Client;
import com.aurionpro.onetomany.entity.Employee;
import com.aurionpro.onetomany.repository.ClientRepository;
import com.aurionpro.onetomany.repository.EmployeeRepository;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Client addClient(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public Client addEmployeeToClient(int clientId, List<Employee> employees) {
		Optional<Client> optionalClient = clientRepository.findById(clientId);
		if(!optionalClient.isPresent())
			return null;
		Client dbClient = optionalClient.get();
		List<Employee> dbEmployees = dbClient.getEmployees();
		employees.forEach((employee) -> {
			Employee temp = employeeRepository.findById(employee.getEmployeeId()).get();
			temp.setClient(dbClient);
			dbEmployees.add(temp);
		});
		dbClient.setEmployees(dbEmployees);
		return clientRepository.save(dbClient);
		
 	}

	@Override
	public List<Client> getAllClient() {
		return clientRepository.findAll();
	}

}
