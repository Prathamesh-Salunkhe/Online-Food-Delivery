package com.mouritech.onlinefoodorderapplication.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Items {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_Id")
		private long itemId;
		
		private String itemName;
		
		private int itemPrice;
		
		private String itemDescription;
		
		private int itemQuantity;
		
		@ManyToOne(cascade = CascadeType.ALL )
		@JoinColumn(name = "restaurant_id")
		private Restaurant restaurant;

		public Items() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Items(String itemName, int itemPrice, String itemDescription, int itemQuantity) {
			super();
			this.itemName = itemName;
			this.itemPrice = itemPrice;
			this.itemDescription = itemDescription;
			this.itemQuantity = itemQuantity;
		}

		public Items(String itemName, int itemPrice, String itemDescription, int itemQuantity, Restaurant restaurant) {
			super();
			this.itemName = itemName;
			this.itemPrice = itemPrice;
			this.itemDescription = itemDescription;
			this.itemQuantity = itemQuantity;
			this.restaurant = restaurant;
		}

		public long getItemId() {
			return itemId;
		}

		public void setItemId(long itemId) {
			this.itemId = itemId;
		}

		public String getItemName() {
			return itemName;
		}

		public void setItemName(String itemName) {
			this.itemName = itemName;
		}

		public int getItemPrice() {
			return itemPrice;
		}

		public void setItemPrice(int itemPrice) {
			this.itemPrice = itemPrice;
		}

		public String getItemDescription() {
			return itemDescription;
		}

		public void setItemDescription(String itemDescription) {
			this.itemDescription = itemDescription;
		}

		public int getItemQuantity() {
			return itemQuantity;
		}

		public void setItemQuantity(int itemQuantity) {
			this.itemQuantity = itemQuantity;
		}

		public Restaurant getRestaurant() {
			return restaurant;
		}

		public void setRestaurant(Restaurant restaurant) {
			this.restaurant = restaurant;
		}
		
		
	}

