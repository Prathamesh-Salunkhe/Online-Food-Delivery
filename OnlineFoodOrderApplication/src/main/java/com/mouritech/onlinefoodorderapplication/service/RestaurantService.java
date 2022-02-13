package com.mouritech.onlinefoodorderapplication.service;
import org.springframework.http.ResponseEntity;

import com.mouritech.onlinefoodorderapplication.entity.Restaurant;

public interface RestaurantService {

	void addRestaurantInformation(Restaurant restaurant);

	boolean findRestaurantByNameAndPassword(String restaurantName, String restaurantPassword);

	ResponseEntity<?> updaterestaurantinfobyname(Restaurant restaurant);

}
