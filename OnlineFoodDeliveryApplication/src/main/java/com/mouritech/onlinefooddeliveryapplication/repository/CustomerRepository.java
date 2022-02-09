package com.mouritech.onlinefooddeliveryapplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouritech.onlinefooddeliveryapplication.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	Optional<Customer> findByUsernameAndEmail(String username, String email);

}
