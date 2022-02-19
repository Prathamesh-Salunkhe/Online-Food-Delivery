package com.mouritech.onlinefoodorderapplication.mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mouritech.onlinefoodorderapplication.dto.CustomerDto;
import com.mouritech.onlinefoodorderapplication.entity.Customer;

@Component
 public class CustomerMapper 
{
	
	@Autowired
	ModelMapper modelMapper;
	
	public CustomerDto convertEntityToDto(Customer customer)
	{
		return modelMapper.map(customer, CustomerDto.class);
	}
	
	public Customer convertDtoToEntity(CustomerDto customerDto)
	{
		return modelMapper.map(customerDto,Customer.class);
	}

}