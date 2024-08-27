package com.aurionpro.client.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aurionpro.client.entity.Client;
import com.aurionpro.client.entity.KycStatus;
import com.aurionpro.client.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Page<Client> getAllClient(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Client> clientPage = clientRepository.findAll(pageable);
		return clientPage;
	}

	@Override
	public void addClient(Client client) {
		clientRepository.save(client);
	}

	@Override
	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}

	@Override
	public void deleteClient(Client client) {
		if(clientRepository.existsById(client.getClientId()))
			clientRepository.delete(client);
	}

	@Override
	public void updateClient(Client client) {
		if(clientRepository.existsById(client.getClientId()))
			clientRepository.save(client);
		
	}

	@Override
	public List<Client> getAddress(String address) {
		return clientRepository.findByAddress(address);
	}

	@Override
	public List<Client> getCompanyName(String companyName) {
		return clientRepository.findByCompanyName(companyName);
	}

	
	
	

}
