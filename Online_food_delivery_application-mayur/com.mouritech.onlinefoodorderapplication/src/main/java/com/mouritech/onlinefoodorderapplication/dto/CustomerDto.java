package com.mouritech.onlinefoodorderapplication.dto;

public class CustomerDto {
	
	private String customerPassword;

	private String customerEmail;

	public CustomerDto(String customerPassword, String customerEmail) {
		super();
		this.customerPassword = customerPassword;
		this.customerEmail = customerEmail;
	}
    public CustomerDto() {
    	super();
    }
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
    
}
