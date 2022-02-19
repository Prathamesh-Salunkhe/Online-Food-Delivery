package com.mouritech.onlinefoodorderapplication.mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mouritech.onlinefoodorderapplication.dto.CustomerDto;
import com.mouritech.onlinefoodorderapplication.dto.CustomerCartsDto;
import com.mouritech.onlinefoodorderapplication.entity.Customer;

@Component
public class CustomerCartsMapper {
	
	@Autowired
	ModelMapper modelMapper;
	
	public CustomerCartsDto convertEntityToDto(Customer customer)
	{
		return modelMapper.map(customer, CustomerCartsDto.class);
	}
	
	public Customer convertDtoToEntity(CustomerCartsDto customerCartsDto)
	{
		return modelMapper.map(customerCartsDto,Customer.class);
	}




}
