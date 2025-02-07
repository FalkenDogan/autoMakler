package com.mdgn.autoMakler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mdgn.autoMakler.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	

}
