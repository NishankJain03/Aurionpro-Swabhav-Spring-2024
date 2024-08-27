package com.aurionpro.client.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.aurionpro.client.entity.Client;
import com.aurionpro.client.entity.KycStatus;

public interface ClientService {
	Page<Client> getAllClient(int pageNumber, int pageSize);
	void addClient(Client client);
	List<Client> getAllClients();
	void deleteClient(Client client);
	void updateClient(Client client);
	List<Client> getAddress(String address);
	List<Client> getCompanyName(String companyName);
}
