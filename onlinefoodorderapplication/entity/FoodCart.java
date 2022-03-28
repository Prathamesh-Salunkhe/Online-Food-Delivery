package com.mouritech.onlinefoodorderapplication.entity;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "foodcart")
public class FoodCart {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cartid")
	private Long cartId;
	
	
	@OneToMany(cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
	@JoinColumn(name = "foodcard_id")
	private List<Items> items;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customerId")
	private Customer customer;

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public FoodCart(Long cartId, List<Items> items, Customer customer) {
		super();
		this.cartId = cartId;
		this.items = items;
		this.customer = customer;
	}

	public FoodCart() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	

}
