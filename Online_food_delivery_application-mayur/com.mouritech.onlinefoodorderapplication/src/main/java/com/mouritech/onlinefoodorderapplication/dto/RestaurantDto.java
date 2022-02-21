package com.mouritech.onlinefoodorderapplication.dto;


public class RestaurantDto {
	
	private String restaurantPassword;

	private String restaurantEmail;

	public RestaurantDto(String restaurantPassword, String restaurantEmail) {
		super();
		this.restaurantPassword = restaurantPassword;
		this.restaurantEmail = restaurantEmail;
	}

	public RestaurantDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getRestaurantPassword() {
		return restaurantPassword;
	}

	public void setRestaurantPassword(String restaurantPassword) {
		this.restaurantPassword = restaurantPassword;
	}

	public String getRestaurantEmail() {
		return restaurantEmail;
	}

	public void setRestaurantEmail(String restaurantEmail) {
		this.restaurantEmail = restaurantEmail;
	}
	
	

}
