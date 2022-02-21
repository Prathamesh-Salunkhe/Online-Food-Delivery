package com.mouritech.onlinefoodorderapplication.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mouritech.onlinefoodorderapplication.dto.RestaurantDto;
import com.mouritech.onlinefoodorderapplication.entity.Restaurant;

@Component
 public class RestaurantMapper 
{
	
	@Autowired
	ModelMapper modelMapper;
	
	public RestaurantDto convertEntityToDto(Restaurant restaurant)
	{
		return modelMapper.map(restaurant, RestaurantDto.class);
	}
	
	public Restaurant convertDtoToEntity(RestaurantDto restaurantDto)
	{
		return modelMapper.map(restaurantDto,Restaurant.class);
	}

}