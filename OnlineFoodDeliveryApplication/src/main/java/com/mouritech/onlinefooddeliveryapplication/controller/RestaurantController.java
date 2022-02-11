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
import com.mouritech.onlinefooddeliveryapplication.model.Restaurant;
import com.mouritech.onlinefooddeliveryapplication.repository.RestaurantRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController 
@RequestMapping("/api/v1")
public class RestaurantController {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	//get all customers
	@GetMapping("/restaurants")
	public List<Restaurant> getRestaurantList()
	{
		return restaurantRepository.findAll();
	}
	
	//add new restaurant
	@PostMapping("/restaurants")
	public Restaurant createRestaurant(@Validated @RequestBody Restaurant restaurant)
	{
		return restaurantRepository.save(restaurant);
	}
	//get a restaurant by id
		@GetMapping("/restaurants/{id}")
	    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable(value = "id") Long restaurantId)
	        throws ResourceNotFoundException {
			Restaurant restaurant = restaurantRepository.findById(restaurantId)
	          .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found for this id :: " + restaurantId));
	        return ResponseEntity.ok().body(restaurant);
	    }
		
		//get a customer by restaurantName
		@GetMapping("/restaurants/{restaurantName}")
		public ResponseEntity<Restaurant> getRestaurantByName(@PathVariable(value = "restaurantName") String restaurantName)
				 throws ResourceNotFoundException {
		       // Customer customer = customerRepository.findByEmailAndPassword(email, password)
		       //   .orElseThrow(() -> new ResourceNotFoundException("Customer not found "));
		        return ResponseEntity.ok().body(null);
		    }
		
		//update a restaurant
		@PutMapping("/restaurants/{id}")
	    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable(value = "id") Long restaurantId,
	         @Validated @RequestBody Restaurant restaurantDetails) throws ResourceNotFoundException {
			Restaurant restaurant = restaurantRepository.findById(restaurantId)
	        .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found for this id :: " + restaurantId));

	        restaurant.setRestaurantName(restaurantDetails.getRestaurantName());
	        restaurant.setAddress(restaurantDetails.getAddress());
	        restaurant.setCity(restaurantDetails.getCity());
	        restaurant.setCountry(restaurantDetails.getCountry());
	        restaurant.setPincode(restaurantDetails.getPincode());
	        
	        final Restaurant updatedRestaurant = restaurantRepository.save(restaurant);
	        return ResponseEntity.ok(updatedRestaurant);
	    }
}
 


