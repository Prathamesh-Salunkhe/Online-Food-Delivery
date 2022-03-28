package com.mouritech.onlinefoodorderapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.onlinefoodorderapplication.entity.Orderdetails;
import com.mouritech.onlinefoodorderapplication.exception.ResourceNotFoundException;
import com.mouritech.onlinefoodorderapplication.service.OrderDetailsService;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/orders")
public class OrderDetailsController {
	
	@Autowired
	private OrderDetailsService orderService;
	
	//save an order
		@PostMapping("/Addorders")
		public Orderdetails saveOrder(@Valid @RequestBody Orderdetails order)
		{
			return orderService.saveOrder(order);
		}
		//get all orders
		@GetMapping("/orders")
		public List<Orderdetails> getAllOrders()
		{
			return orderService.getAllOrders();
		}
		//update orders
		@PutMapping("/orders/{orderId}")
		public ResponseEntity<Orderdetails> updateOrder(@PathVariable(value = "orderId") Long orderId,@RequestBody Orderdetails orderdetails) throws ResourceNotFoundException  {
		
			return orderService.updateOrders(orderId,orderdetails);
		
		}
		@DeleteMapping("/orders/{orderId}")
		public ResponseEntity<?> deleteOrder(@PathVariable(value = "orderId") Long orderId) throws ResourceNotFoundException
		{
			return orderService.deleteOrder(orderId);
			
		}

		@GetMapping("/orders/{id}")
	  public ResponseEntity<Orderdetails> getOrderById(@PathVariable(value = "id") long orderId) throws ResourceNotFoundException
	      {
			return orderService.getOrderById(orderId);
			
			
		}
		
		@PostMapping("/createOrderusingCartId/{cartId}")
		public Orderdetails createOrder(@PathVariable(value = "cartId") long cartId) throws ResourceNotFoundException {
			return orderService.createOrder(cartId);
		}
	}