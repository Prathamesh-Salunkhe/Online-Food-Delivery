package com.mouritech.onlinefoodorderapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouritech.onlinefoodorderapplication.entity.FoodCart;

@Repository
public interface FoodCartRepository extends JpaRepository<FoodCart, Long>{

	List<FoodCart> findByItems_ItemId(long itemId);


}
