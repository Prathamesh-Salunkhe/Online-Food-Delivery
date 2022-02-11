package com.mouritech.onlinefooddeliveryapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouritech.onlinefooddeliveryapplication.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
//	Optional<Customer> findByEmailAndPassword(String email, String password);

}
