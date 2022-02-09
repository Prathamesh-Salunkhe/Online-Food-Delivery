package com.mouritech.onlinefooddeliveryapplication.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouritech.onlinefooddeliveryapplication.entity.FoodCart;


@Repository
public interface FoodCartRepository  extends JpaRepository<FoodCart, Long>{
	
	List<FoodCart> findByCustomer_CustomerId(Long customerId);
	Optional<FoodCart> findByCartIdAndCustomer_CustomerId(Long cartId, Long customerId);

}



