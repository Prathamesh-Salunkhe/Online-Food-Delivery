package com.mouritech.onlinefoodorderapplication.service;

import org.springframework.http.ResponseEntity;

import com.mouritech.onlinefoodorderapplication.dto.CustomerCartsDto;
import com.mouritech.onlinefoodorderapplication.dto.CustomerDto;
import com.mouritech.onlinefoodorderapplication.entity.Customer;

public interface CustomerService {

	void addCustomerInformation(Customer customer);

	ResponseEntity<?> updatecustomerinfobyname(Customer customer);

	boolean findCustomerByEmailAndPassword(String customerEmail, String customerPassword);

	ResponseEntity<?> checkRestauramtEmailAndPassword(CustomerDto customerDto);

//	ResponseEntity<?> insertItems(CustomerCartsDto customerCartsDto);

	ResponseEntity<?> insertCarts(CustomerCartsDto customerCartsDto);

	ResponseEntity<?> checkCustomerEmailAndPassword(CustomerDto customerDto);
}