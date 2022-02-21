package com.mouritech.onlinefoodorderapplication.dto;

import java.util.List;

import com.mouritech.onlinefoodorderapplication.entity.Items;

public class CustomerCartsDto {
	
	private String customerPassword;

	private String customerEmail;
	
	private List<Items> items;

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	public CustomerCartsDto(String customerPassword, String customerEmail, List<Items> items) {
		super();
		this.customerPassword = customerPassword;
		this.customerEmail = customerEmail;
		this.items = items;
	}

	public CustomerCartsDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	


}
