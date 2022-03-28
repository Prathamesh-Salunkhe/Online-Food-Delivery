package com.mouritech.onlinefoodorderapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.onlinefoodorderapplication.entity.FoodCart;
import com.mouritech.onlinefoodorderapplication.exception.ResourceNotFoundException;
import com.mouritech.onlinefoodorderapplication.service.FoodCartService;

@RestController
@RequestMapping("/foodcart")
public class FoodCartController {
	@Autowired
	private FoodCartService cartService;
	
	@PostMapping("Cart")
	public FoodCart insertCart(@RequestBody FoodCart newCart) {
		return cartService.insertCart(newCart);
	}
	@GetMapping("Cart")
	public List<FoodCart> showAllCarts() {
		return cartService.showAllCarts();
	}
	@GetMapping("Cart/{cid}")
	public FoodCart showCartById(@PathVariable("cid") Long CartId) throws ResourceNotFoundException  {
		return cartService.showCartById(CartId);
	}
	@PutMapping("Cart/{cid}")
	public FoodCart updateCartById(@PathVariable("cid") Long CartId, @RequestBody FoodCart Cart) throws ResourceNotFoundException
			{
		return cartService.updateCartById(CartId, Cart);
	}
	@DeleteMapping("Cart/{cid}")
	public String deleteCartById(@PathVariable("cid") long CartId) throws ResourceNotFoundException  {
		cartService.deleteCartById(CartId);
		return "deleted the Cart";
	}
	
	@PostMapping("/createcartusingcustNameanditem/{customerName}/{restaurantName}/{itemName}")
	public FoodCart createCart(@PathVariable("customerName") String customerName,@PathVariable("restaurantName") String restaurantName,@PathVariable("itemName") String itemName)
	{
		return cartService.createCart(customerName,restaurantName,itemName);
	}
	
	@PutMapping("/updateCartAddNewItems/{cartId}/{restaurantName}/{itemName}")
	public FoodCart addItemsInCart(@PathVariable("cartId") Long cartId,@PathVariable("restaurantName") String restaurantName,@PathVariable("itemName") String itemName) throws ResourceNotFoundException {
		return cartService.addItemsInCart(cartId,restaurantName,itemName);
	}
	

}