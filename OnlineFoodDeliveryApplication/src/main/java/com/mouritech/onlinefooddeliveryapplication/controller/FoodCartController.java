package com.mouritech.onlinefooddeliveryapplication.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.onlinefooddeliveryapplication.exception.ResourceNotFoundException;
import com.mouritech.onlinefooddeliveryapplication.repository.CustomerRepository;
import com.mouritech.onlinefooddeliveryapplication.repository.FoodCartRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController 
@RequestMapping("/api/v1")
public class FoodCartController {
	
	


	@Autowired
	private FoodCartRepository foodcartRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	//get menu for corresponding vendor
	@GetMapping("/customers/{customerId}/menu")
	public List<Cart> getMenuByCustomerId(@PathVariable(value = "customerId") Long customerId)
	{
		return foodcartRepository.findByCustomer_CustomerId(customerId);
	}
	
	//Get all items to create a menu
	@GetMapping("/menu")
	public List<Cart> getMenu()
	{
		return foodcartRepository.findAll();
	}
	@PostMapping("/customers/{customerId}/menu")
	public Cart saveItemByCustomerId(@PathVariable(value = "customerId") Long customerId,
			@Validated @RequestBody Cart cart) throws ResourceNotFoundException
	{
		return customerRepository.findById(customerId).map(customer ->{
			cart.setCustomer(customer);
			return foodcartRepository.save(cart);
		}).orElseThrow(() -> new ResourceNotFoundException("customer not found"));
	}
	
	//Add a new item in menu
	@PostMapping("/menu")
	public Cart createCart(@Validated @RequestBody Cart cart)
	{
		
		return foodcartRepository.save(cart);
	}
	
	
	@GetMapping("/menu/{cartId}")
    public ResponseEntity<Cart> getItemById(@PathVariable(value = "itemId") Long itemId)
        throws ResourceNotFoundException {
        Cart cart = foodcartRepository.findById(cartId)
          .orElseThrow(() -> new ResourceNotFoundException("Cart not found for this id :: " + itemId));
        return ResponseEntity.ok().body(cart);
    }
	
	@PutMapping("/menu/{cartId}")
    public ResponseEntity<Cart> updateCart(@PathVariable(value = "cartId") Long cartId,
         @Validated @RequestBody Cart cartDetails) throws ResourceNotFoundException
	{
        Cart item = foodcartRepository.findById(cartId)
        .orElseThrow(() -> new ResourceNotFoundException("Cart not found for this id :: " + cartId));
        
        cart.setCartList(cartDetails.getCartList());
        
        
        final Cart updatedCart = foodcartRepository.save(cart);
        return ResponseEntity.ok(updatedCart);
    }
	
	@DeleteMapping("/customers/{customerId}/menu/{customerId}")
	public ResponseEntity<?> deleteCart(@PathVariable(value = "cartId") Long cartId, 
			@PathVariable(value = "cartId") Long cartId)
	throws ResourceNotFoundException
	{
		return foodcartRepository.findByCartIdAndCustomer_CustomerId(cartId, customerId).map(cart -> {
			itemRepository.delete(cart);
		return ResponseEntity.ok().build();
		}).orElseThrow(()->new ResourceNotFoundException("cart not found"));
	}
	
}
