package com.mouritech.onlinefoodorderapplication.service;

import java.util.List;
import org.springframework.http.ResponseEntity;

import com.mouritech.onlinefoodorderapplication.entity.Customer;
import com.mouritech.onlinefoodorderapplication.exception.CustomerNotFound;

public interface CustomerService {

	void addCustomerInformation(Customer customer);

	ResponseEntity<?> updatecustomerinfobyname(Customer customer);

	boolean findCustomerByEmailAndPassword(String customerEmail, String customerPassword);

	//ResponseEntity<?> checkRestauramtEmailAndPassword(CustomerDto customerDto);

//	ResponseEntity<?> insertItems(CustomerCartsDto customerCartsDto);

	//ResponseEntity<?> insertCarts(CustomerCartsDto customerCartsDto);

   //	ResponseEntity<?> checkCustomerEmailAndPassword(CustomerDto customerDto);

	void deleteCustomerById(String customerId) throws CustomerNotFound;

	List<Customer> showAllCustomers();

	ResponseEntity<?> checkCustomerEmailAndPassword(Customer customer);

	//ResponseEntity<?> checkCustomerEmailAndPassword(CustomerDto customerDto);

	//ResponseEntity<?> checkRestauramtEmailAndPassword(CustomerDto customerDto);
}