package com.mouritech.onlinefoodorderapplication.entity;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "cart")
public class Carts{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartId")
	          private long cartId;
	
	@OneToOne(cascade = CascadeType.ALL )
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	/*
	 * @OneToMany(cascade = CascadeType.ALL )
	 * 
	 * @JoinColumn(name = "item_Id") private List<Items> items;
	 */
	
	public Carts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Carts(Customer customer) {
		super();
		this.customer = customer;
	}

	/*
	 * public Carts(Customer customer List<Items> items ) { super(); this.customer =
	 * customer; //this.items = items; }
	 */

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/*
	 * public List<Items> getItems() { return items; }
	 * 
	 * public void setItems(List<Items> items) { this.items = items; }
	 */
	@Override
	public String toString() {
		return "Carts [cartId=" + cartId + ", customer=" + customer + "]";
	}
	
	
	
	
}
