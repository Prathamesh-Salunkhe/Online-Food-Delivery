package com.mouritech.onlinefoodorderapplication.mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mouritech.onlinefoodorderapplication.dto.CartsDto;
import com.mouritech.onlinefoodorderapplication.entity.Carts;



@Component
public class CartsMapper {
	
	@Autowired
	ModelMapper modelMapper;
	
	public CartsDto convertEntityToDto(Carts carts)
	{
		return modelMapper.map(carts, CartsDto.class);
	}
	
	public Carts convertDtoToEntity(CartsDto cartsDto)
	{
		return modelMapper.map(cartsDto,Carts.class);
	}


}


