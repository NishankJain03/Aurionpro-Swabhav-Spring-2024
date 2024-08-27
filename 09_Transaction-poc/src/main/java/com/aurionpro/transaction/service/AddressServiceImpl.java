package com.aurionpro.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.transaction.entity.Address;
import com.aurionpro.transaction.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
    private AddressRepository addressRepository;
    
	@Override
    public Address addAddress(Address address) {
        Address addressSavedToDB = this.addressRepository.save(address);
        return addressSavedToDB;
    }
}
