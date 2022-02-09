package com.mouritech.onlinefooddeliveryapplication.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import antlr.collections.List;

@Entity
@Table(name="FoodCart")
public class FoodCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartId", nullable = false)
	private Long cartId;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "customerId")
	private Customer customer;

	@Column(name = "itemList", nullable = false)
	private List itemList;
	
	public FoodCart() {
		super();
	}
	
	public FoodCart(Customer customer, List itemList) {
		super();
		this.customer = customer;
		this.itemList = itemList;
	}

	public FoodCart(Long cartId, Customer customer, List itemList) {
		super();
		this.cartId = cartId;
		this.customer = customer;
		this.itemList = itemList;
	}


	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List getItemList() {
		return itemList;
	}

	public void setItemList(List itemList) {
		this.itemList = itemList;
	}

	@Override
	public String toString() {
		return "FoodCart [cartId=" + cartId + ", customer=" + customer + ", itemList=" + itemList + "]";
	}

	

}
