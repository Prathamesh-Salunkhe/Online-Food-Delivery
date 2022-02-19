package com.mouritech.onlinefoodorderapplication.service;
import org.springframework.http.ResponseEntity;

import com.mouritech.onlinefoodorderapplication.dto.RestaurantDto;
import com.mouritech.onlinefoodorderapplication.dto.RestaurantItemsDto;
import com.mouritech.onlinefoodorderapplication.entity.Restaurant;

public interface RestaurantService {
	void addRestaurantInformation(Restaurant restaurant);

	ResponseEntity<?> updaterestaurantinfobyname(Restaurant restaurant);

	boolean findRestaurantByEmailAndPassword(String restaurantEmail, String restaurantPassword);

	ResponseEntity<?> checkRestauramtEmailAndPassword(RestaurantDto restaurantDto);

	ResponseEntity<?> insertItems(RestaurantItemsDto restaurantItemsDto);

	boolean findRestaurantByNameAndPassword(String restaurantName, String restaurantPassword);

	
}
