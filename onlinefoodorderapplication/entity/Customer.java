package com.mouritech.onlinefoodorderapplication.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_Id")
	private Long customerId;
	
	@Column(name="customer_name")
	private String customerName;
	
	
	@Column(name = "customer_age", nullable = false)
	private int customerAge;
	
	@Column(name = "customer_Email", nullable = false)
	private String customerEmail;
	
	@Column(name = "customer_password")
	private String customerPassword;
	
	
	@Column(name = "customer_mobileNumber", nullable = false)
	private String customerMobileNumber;
	
	@Column(name = "customer_address", nullable = false)
	private String customerAddress;
	
	@Column(name = "customer_city", nullable = false)
	private String customerCity;

	@Column(name = "customer_state", nullable = false)
	private String customerState;
	
	@Column(name = "customer_country", nullable = false)
	private String customerCountry;
	
	@Column(name = "customer_pincode", nullable = false)
	private String customerPincode;
	
	@OneToOne(mappedBy = "customer" , orphanRemoval = true, cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	private FoodCart foodCart;
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerMobileNumber() {
		return customerMobileNumber;
	}

	public void setCustomerMobileNumber(String customerMobileNumber) {
		this.customerMobileNumber = customerMobileNumber;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public String getCustomerState() {
		return customerState;
	}

	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}

	public String getCustomerCountry() {
		return customerCountry;
	}

	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
	}

	public String getCustomerPincode() {
		return customerPincode;
	}

	public void setCustomerPincode(String customerPincode) {
		this.customerPincode = customerPincode;
	}
	
	

	public FoodCart getFoodCart() {
		return foodCart;
	}

	public void setFoodCart(FoodCart foodCart) {
		this.foodCart = foodCart;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Long customerId, String customerName, int customerAge, String customerEmail,
			String customerPassword, String customerMobileNumber, String customerAddress, String customerCity,
			String customerState, String customerCountry, String customerPincode) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAge = customerAge;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.customerMobileNumber = customerMobileNumber;
		this.customerAddress = customerAddress;
		this.customerCity = customerCity;
		this.customerState = customerState;
		this.customerCountry = customerCountry;
		this.customerPincode = customerPincode;
	}

	public Customer(String customerName, int customerAge, String customerEmail, String customerPassword,
			String customerMobileNumber, String customerAddress, String customerCity, String customerState,
			String customerCountry, String customerPincode) {
		super();
		this.customerName = customerName;
		this.customerAge = customerAge;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.customerMobileNumber = customerMobileNumber;
		this.customerAddress = customerAddress;
		this.customerCity = customerCity;
		this.customerState = customerState;
		this.customerCountry = customerCountry;
		this.customerPincode = customerPincode;
	}

	
	

	
}