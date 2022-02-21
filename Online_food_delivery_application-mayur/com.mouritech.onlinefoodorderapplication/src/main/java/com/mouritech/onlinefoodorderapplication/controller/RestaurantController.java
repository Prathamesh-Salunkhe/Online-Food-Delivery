package com.mouritech.onlinefoodorderapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.onlinefoodorderapplication.dto.RestaurantDto;
import com.mouritech.onlinefoodorderapplication.dto.RestaurantItemsDto;
import com.mouritech.onlinefoodorderapplication.entity.Restaurant;
import com.mouritech.onlinefoodorderapplication.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	@Autowired
	private RestaurantService restaurantService;
	
	@PostMapping("/addrestaurantinfo")
	public ResponseEntity<?>addRestaurantInformation(@RequestBody Restaurant restaurant)
	{
		restaurantService.addRestaurantInformation(restaurant);
		
		return ResponseEntity.ok().body("all restaurant information inserted");
		
		
	}
	
	@GetMapping("/getrestaurantbyemaiandpassword/{restaurantEmail}/{restaurantPassword}")
	public ResponseEntity<?> findRestaurantByEmailAndPassword(@PathVariable(value = "restaurantEmail") String restaurantEmail,
			@PathVariable(value ="restaurantPassword") String restaurantPassword){
		
		boolean result = restaurantService.findRestaurantByEmailAndPassword(restaurantEmail,restaurantPassword);
		if(result==true) {
			return ResponseEntity.ok().body("login successful");
		}
	
		else {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("resourse not found please sign in first");
			
		}
		
	}
	@PutMapping("/updaterestaurantinfobyname")
	public ResponseEntity<?>updaterestaurantinfobyname(@RequestBody Restaurant restaurant){
		
		ResponseEntity<?> result = restaurantService.updaterestaurantinfobyname(restaurant);
		return result;
	}
	
@GetMapping("/getrestaurantbyemailandpasswordcheck")
public ResponseEntity<?>checkRestauramtEmailAndPassword(@RequestBody RestaurantDto restaurantDto){
	if(restaurantDto==null) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please Enter Email and password");
	}
	else {
		
		ResponseEntity<?> ckeckLogin = restaurantService.checkRestauramtEmailAndPassword(restaurantDto);
		return ckeckLogin;
		
	}
	
}

@PostMapping("/insertitemsByrestaurantemaiandpassword")
public ResponseEntity<?>insertItems(@RequestBody RestaurantItemsDto restaurantItemsDto){
	
	if(restaurantItemsDto==null) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please Enter Email and password, items");
	}
	else {
		
		ResponseEntity<?> itemsInsert = restaurantService.insertItems(restaurantItemsDto);
		return itemsInsert;
		
	}

}
}
