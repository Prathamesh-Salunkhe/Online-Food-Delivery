package com.mouritech.onlinefooddeliveryapplication.service;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mouritech.onlinefooddeliveryapplication.entity.Customer;
import com.mouritech.onlinefooddeliveryapplication.entity.FoodCart;
import com.mouritech.onlinefooddeliveryapplication.exception.ResourceNotFoundException;


import com.mouritech.onlinefooddeliveryapplication.repository.CustomerRepository;
import com.mouritech.onlinefooddeliveryapplication.repository.FoodCartRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CartRepository cartRepository;

	@Override
	public Customer insertCustomer(Customer newCustomer) {
	
		newCustomer.setCustomerId(generateCustomerId());
		return customerRepository.save(newCustomer);
	}
	
	
	public Long generateCustomerId() {
		Random rand = new Random(); //instance of random class
	      int upperbound = 255;
	        //generate random values from 0-254
	      Long cId = (long) rand.nextInt(upperbound);
		return 0 + cId; 
	
	}


	@Override
	public Customer showCustomerById(Long customerId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return customerRepository.findByCustomerId(customerId).orElseThrow(() -> new ResourceNotFoundException("customer not found with id " + customerId));
	}


	@Override
	public List<Customer> showAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}


	@Override
	public Customer updateCustomerById(Long customerId,Customer customer) throws ResourceNotFoundException {
		Customer existingProduct = customerRepository.findByCustomerId(customerId).orElseThrow(() -> new ResourceNotFoundException("customer not found with id " + productId));
		existingCustomer.setCustomerFirstName(customer.getFirstName());
		existingCustomer.setCustomerLastName(customer.getLastName());
		customerRepository.save(existingCustomer);
		return existingCustomer;
	}


	@Override
	public void deleteCustomerById(Long customerId) throws ResourceNotFoundException {
		Customer existingCustomer = customerRepository.findByCustomerId(customerId).orElseThrow(() -> new ResourceNotFoundException("customer not found with id " + customerId));
		customerRepository.delete(existingCustomer);
	}


	@Override
	public ResponseEntity<List<Customer>> getAllCustomersByCartId(Long cartId) throws ResourceNotFoundException {
		if(!cartRepository.existsById(cartId)) {
			throw new ResourceNotFoundException("Cart not found with id = "  + cartId);
		}
		List<Customer> customers = customerRepository.findByCartId(cartId);
		return new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<Customer> createCustomer(Long cartId,Customer newCustomer) throws ResourceNotFoundException {
	
		Customer customer = cartRepository.findById(cartId).map(
				cart ->{
					newCustomer.setCart(cart);
					newCustomer.setCustomerId(generateCustomerId());
					return customerRepository.save(newCustomer);
				}).orElseThrow(()-> new ResourceNotFoundException("Cart not found with id = "  + cartId));
		return new ResponseEntity<Customer>(newCustomer,HttpStatus.CREATED);
	}


	@Override
	public ResponseEntity<List<Customer>> getAllCustomerByCartId(Long cartId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


	



}
