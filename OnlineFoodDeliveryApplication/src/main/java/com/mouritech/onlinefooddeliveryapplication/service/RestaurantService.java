package com.mouritech.onlinefooddeliveryapplication.service;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mouritech.onlinefooddeliveryapplication.exception.ResourceNotFoundException;
import com.mouritech.onlinefooddeliveryapplication.model.Restaurant;

public interface RestaurantService {

	Restaurant insertRestaurant(Restaurant newRestaurant);

	Restaurant showRestaurantById(String restaurantId) throws ResourceNotFoundException;

	List<Restaurant> showAllRestaurants();



	Restaurant updateRestaurantById(String restaurantId, Restaurant restaurant) throws ResourceNotFoundException;

	void deleteRestaurantById(String restaurantId) throws ResourceNotFoundException;
//	ResponseEntity<List<Customer>> getAllCustomerByCartId(Long cartId) throws ResourceNotFoundException;



//	ResponseEntity<Customer> createCustomer(Long cartId, Customer newCustomer) throws ResourceNotFoundException;


}
