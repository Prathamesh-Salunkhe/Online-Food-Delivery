package com.mouritech.onlinefoodorderapplication.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mouritech.onlinefoodorderapplication.entity.Customer;
import com.mouritech.onlinefoodorderapplication.entity.FoodCart;
import com.mouritech.onlinefoodorderapplication.entity.Items;
import com.mouritech.onlinefoodorderapplication.entity.Restaurant;
import com.mouritech.onlinefoodorderapplication.exception.ResourceNotFoundException;
import com.mouritech.onlinefoodorderapplication.repository.CustomerRepository;
import com.mouritech.onlinefoodorderapplication.repository.FoodCartRepository;
import com.mouritech.onlinefoodorderapplication.repository.ItemsRepository;
import com.mouritech.onlinefoodorderapplication.repository.RestaurantRepository;
import com.mouritech.onlinefoodorderapplication.service.FoodCartService;
@Service
public class FoodCartServiceImpl implements FoodCartService {
	
	@Autowired
	private FoodCartRepository cartRepository;
	@Autowired
	private ItemsRepository itemRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	public FoodCart insertCart(FoodCart newCart) {
		// TODO Auto-generated method stub
		return cartRepository.save(newCart);
	}
	public FoodCart showCartById(Long cartId) throws ResourceNotFoundException{
		// TODO Auto-generated method stub
		return cartRepository.findById(cartId).orElseThrow(
				() -> new ResourceNotFoundException());
	}
	public List<FoodCart> showAllCarts() {
		// TODO Auto-generated method stub
		return cartRepository.findAll();
	}
	public FoodCart updateCartById(Long cartId, FoodCart cart) throws ResourceNotFoundException  {
		// TODO Auto-generated method stub
		FoodCart existingCart = cartRepository.findById(cartId).orElseThrow(()-> new ResourceNotFoundException());
		existingCart.setItems(cart.getItems());
		cartRepository.save(existingCart);
		return existingCart;
	}
	public void deleteCartById(Long cartId) throws ResourceNotFoundException {
		FoodCart existingCart = cartRepository.findById(cartId).orElseThrow(() -> new ResourceNotFoundException());
						cartRepository.delete(existingCart);
		
	}

	
	

	public ResponseEntity<List<FoodCart>> getAllCartsByitemId(long itemId) {
		List<FoodCart> carts = cartRepository.findByItems_ItemId(itemId);
		return new ResponseEntity<List<FoodCart>>(carts,HttpStatus.OK);
	}
	
	
	@Override
	public void deleteCartById(long cartId) throws ResourceNotFoundException {

		FoodCart existingCart = cartRepository.findById(cartId).orElseThrow(()-> new ResourceNotFoundException());

		cartRepository.delete(existingCart);
	}
	@Override
	public FoodCart createCart(String customerName, String restaurantName, String itemName) {
		
		List<Items> myList = new ArrayList<>();

		Customer existingcustomer = customerRepository.findByCustomerName(customerName);
		Restaurant restaurant = restaurantRepository.findByRestaurantName(restaurantName);
		List<Items> restItems = restaurant.getItems();
		for (Items result : restItems) {
			if(result.getItemName().equals(itemName)) {
				FoodCart foodCart = new FoodCart();
				myList.add(result);
				foodCart.setCartId(generateCustId());
				foodCart.setItems(myList);
				foodCart.setCustomer(existingcustomer);
				
				cartRepository.save(foodCart);
				
				return foodCart;
			}
			
		}
		return null;
	}
	
	public long generateCustId() {
		Random rand = new Random(); //instance of random class
	      int upperbound = 255;
	        //generate random values from 0-254
	      Long cId = (long) rand.nextInt(upperbound);
		return  cId; 
	
	}
	@Override
	public FoodCart addItemsInCart(Long cartId, String restaurantName, String itemName) throws ResourceNotFoundException {

		FoodCart cart =	cartRepository.findById(cartId).orElseThrow(() -> new ResourceNotFoundException());
		Restaurant restaurant = restaurantRepository.findByRestaurantName(restaurantName);
		List<Items> restItems = restaurant.getItems();
		for (Items result : restItems) {
			if(result.getItemName().equals(itemName)) {
				List<Items> items = cart.getItems();
				items.add(result);

		
				cartRepository.save(cart);
				return cart;
			}
			
		}
		return null;
	
}
}


