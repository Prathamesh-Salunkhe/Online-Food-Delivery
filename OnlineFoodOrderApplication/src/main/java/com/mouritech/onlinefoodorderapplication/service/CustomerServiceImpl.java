package com.mouritech.onlinefoodorderapplication.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mouritech.onlinefoodorderapplication.dto.CustomerCartsDto;
import com.mouritech.onlinefoodorderapplication.dto.CustomerDto;
import com.mouritech.onlinefoodorderapplication.entity.Customer;
import com.mouritech.onlinefoodorderapplication.mapper.CustomerCartsMapper;
import com.mouritech.onlinefoodorderapplication.mapper.CustomerMapper;
import com.mouritech.onlinefoodorderapplication.repository.CartsRepository;
import com.mouritech.onlinefoodorderapplication.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	CartsRepository cartsRepository;

@Autowired
CustomerMapper customerMapper;

@Autowired
CustomerCartsMapper customerCartsMapper;

@Override
public void addCustomerInformation(Customer customer) {
	
	customerRepository.save(customer);
		
	}

	@Override
	public boolean findCustomerByEmailAndPassword(String customerEmail, String customerPassword) {
		boolean flag =false;
		
		Customer customer = customerRepository.findByCustomerEmailAndCustomerPassword(customerEmail,customerPassword);
		if(customer==null) {
			return flag;
		}
		else {
			return flag=true;
		}

	}

	@Override
	public ResponseEntity<?> updatecustomerinfobyname(Customer customer) {
		
		Customer cust = customerRepository.findByCustomerName(customer.getCustomerName());
		if(cust==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("resourse not you can't update");
		}
		else {
			
			cust.setCustomerName(customer.getCustomerName());
			cust.setCustomerPassword(customer.getCustomerPassword());
			cust.setCustomerCity(customer.getCustomerCity());
			cust.setCustomerState(customer.getCustomerState());
			cust.setCustomerCountry(customer.getCustomerCountry());
			cust.setCustomerPincode(customer.getCustomerPincode());
			cust.setCustomerMobileNumber(customer.getCustomerMobileNumber());
			cust.setCustomerEmail(customer.getCustomerEmail());
			
			final Customer customerfinal = customerRepository.save(cust);
			
			 return ResponseEntity.ok(customerfinal);
		}
	}
		
		@Override
		public ResponseEntity<?> checkCustomerEmailAndPassword(CustomerDto customerDto) {
		// Restaurant restaurant = restaurantMapper.convertDtoToEntity(restaurantDto);
		 Customer checkEmailExisting = customerRepository.findByCustomerEmail(customerDto.getCustomerEmail());
		 Customer checkpasswordExisting = customerRepository.findByCustomerPassword(customerDto.getCustomerPassword());
		 
		 if(checkEmailExisting==null) {
			 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This email is not present in data base please check email or go to sign in");
			 
		 }
		 else if (checkpasswordExisting==null) {
			
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("password doesnt match");
		}
		
		 else {
			 return ResponseEntity.ok().body("login successful");
		 }
			
		}
		
		@SuppressWarnings("unused")
		@Override
		public ResponseEntity<?> insertCarts(CustomerCartsDto customerCartsDto) {
			
			 Customer checkEmailExisting = customerRepository.findByCustomerEmail(customerCartsDto.getCustomerEmail());
			 checkEmailExisting.setCarts(null);
			 
			 
			 Customer checkpasswordExisting = customerRepository.findByCustomerPassword(customerCartsDto.getCustomerPassword());
			 checkEmailExisting.setCustomerId(checkpasswordExisting.getCustomerId());
			
			 if(checkEmailExisting==null) {
				 
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This email is not present in data base please check email or go to sign in");
				 
			 }
			 else if (checkpasswordExisting==null) {
				
				 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("password doesnt match");
			}
			 
			 else {
				 
				 Customer customer = customerCartsMapper.convertDtoToEntity(customerCartsDto);
				 
				 checkEmailExisting.setCarts(customer.getCarts());
				 
			
				 cartsRepository.saveAll(checkEmailExisting.getCarts());
				 return ResponseEntity.ok().body("carts inserted");
			 }
}

		@Override
		public ResponseEntity<?> checkRestauramtEmailAndPassword(CustomerDto customerDto) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ResponseEntity<?> insertItems(CustomerCartsDto customerCartsDto) {
			// TODO Auto-generated method stub
			return null;
		}


}
