package com.mouritech.onlinefooddeliveryapplication.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouritech.onlinefoodorderapplication.entity.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

	Restaurant findByRestaurantNameAndRestaurantPassword(String restaurantName, String restaurantPassword);

	Restaurant findByRestaurantName(String restaurantName);

}
