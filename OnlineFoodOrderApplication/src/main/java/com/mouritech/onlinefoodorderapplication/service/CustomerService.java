package com.mouritech.onlinefoodorderapplication.service;

import org.springframework.http.ResponseEntity;

import com.mouritech.onlinefoodorderapplication.entity.Customer;

public interface CustomerService {

	void addCustomerInformation(Customer customer);

	boolean findCustomerByEmailAndPassword(String customerEmail, String customerPassword);

	ResponseEntity<?> updatecustomerinfobyname(Customer customer);

}