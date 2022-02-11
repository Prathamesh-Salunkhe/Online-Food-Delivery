package com.mouritech.onlinefooddeliveryapplication.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="restaurants")
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "restaurantId", nullable = false)
	private Long restaurantId;
	
	@Column(name="restaurant_name", nullable = false)
	private String restaurantName;
	
	@Column(name = "managerName", nullable = false)
	private String managerName;
	
	@Column(name = "contactNumber", nullable = false)
	private String contactNumber;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "city", nullable = false)
	private String city;

	@Column(name = "state", nullable = false)
	private String state;
	
	@Column(name = "country", nullable = false)
	private String country;
	
	@Column(name = "pincode", nullable = false)
	private String pincode;
	
   public Restaurant() {
	   super();
   }

public Restaurant(String restaurantName, String managerName, String address, String city,
		String state, String country, String pincode) {
	super();
	this.restaurantName = restaurantName;
	this.managerName = managerName;
	this.address = address;
	this.city = city;
	this.state = state;
	this.country = country;
	this.pincode = pincode;
}

public Restaurant(String restaurantName, String managerName, String contactNumber, String address, String city,
		String state, String country, String pincode) {
	super();
	this.restaurantName = restaurantName;
	this.managerName = managerName;
	this.contactNumber = contactNumber;
	this.address = address;
	this.city = city;
	this.state = state;
	this.country = country;
	this.pincode = pincode;
}

public Long getRestaurantId() {
	return restaurantId;
}

public void setRestaurantId(Long restaurantId) {
	this.restaurantId = restaurantId;
}

public String getRestaurantName() {
	return restaurantName;
}

public void setRestaurantName(String restaurantName) {
	this.restaurantName = restaurantName;
}

public String getManagerName() {
	return managerName;
}

public void setManagerName(String managerName) {
	this.managerName = managerName;
}

public String getContactNumber() {
	return contactNumber;
}

public void setContactNumber(String contactNumber) {
	this.contactNumber = contactNumber;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public String getPincode() {
	return pincode;
}

public void setPincode(String pincode) {
	this.pincode = pincode;
}

@Override
public String toString() {
	return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", managerName="
			+ managerName + ", contactNumber=" + contactNumber + ", address=" + address + ", city=" + city + ", state="
			+ state + ", country=" + country + ", pincode=" + pincode + "]";
}
   
   

}
