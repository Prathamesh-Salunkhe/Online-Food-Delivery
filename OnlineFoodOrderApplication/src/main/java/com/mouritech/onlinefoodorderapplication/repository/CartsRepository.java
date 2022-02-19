package com.mouritech.onlinefoodorderapplication.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouritech.onlinefoodorderapplication.entity.Carts;

@Repository
public interface CartsRepository extends JpaRepository<Carts, Long>{

	void saveAll(Object carts);

}


