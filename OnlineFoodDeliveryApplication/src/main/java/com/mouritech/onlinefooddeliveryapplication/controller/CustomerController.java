package com.mouritech.onlinefooddeliveryapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.onlinefooddeliveryapplication.exception.ResourceNotFoundException;
import com.mouritech.onlinefooddeliveryapplication.model.Customer;
import com.mouritech.onlinefooddeliveryapplication.repository.CustomerRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController 
@RequestMapping("/api/v1")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	//get all customers
	@GetMapping("/customers")
	public List<Customer> getCustomerList()
	{
		return customerRepository.findAll();
	}
	
	//add new customer
	@PostMapping("/customers")
	public Customer createCustomer(@Validated @RequestBody Customer customer)
	{
		return customerRepository.save(customer);
	}
	//get a customer by id
		@GetMapping("/customers/{id}")
	    public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Long customerId)
	        throws ResourceNotFoundException {
	        Customer customer = customerRepository.findById(customerId)
	          .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));
	        return ResponseEntity.ok().body(customer);
	    }
		
		//get a customer by username and email
		@GetMapping("/customers/{username}/{email}")
		public ResponseEntity<Customer> getCustomerByEmailAndPassword(@PathVariable(value = "email") String email,
				@PathVariable(value ="password") String password) throws ResourceNotFoundException {
		       // Customer customer = customerRepository.findByEmailAndPassword(email, password)
		       //   .orElseThrow(() -> new ResourceNotFoundException("Customer not found "));
		        return ResponseEntity.ok().body(null);
		    }
		
		//update a customer
		@PutMapping("/customers/{id}")
	    public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Long customerId,
	         @Validated @RequestBody Customer customerDetails) throws ResourceNotFoundException {
	        Customer customer = customerRepository.findById(customerId)
	        .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));

	        customer.setEmail(customerDetails.getEmail());
	        customer.setLastName(customerDetails.getLastName());
	        customer.setFirstName(customerDetails.getFirstName());
	        customer.setAddress(customerDetails.getAddress());
	        customer.setCity(customerDetails.getCity());
	        customer.setCountry(customerDetails.getCountry());
	        customer.setPincode(customerDetails.getPincode());
	        
	        final Customer updatedCustomer = customerRepository.save(customer);
	        return ResponseEntity.ok(updatedCustomer);
	    }
}