package com.mouritech.onlinefooddeliveryapplication.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouritech.onlinefooddeliveryapplication.model.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
	
//	Optional<Customer> findByEmailAndPassword(String email, String password);



}
