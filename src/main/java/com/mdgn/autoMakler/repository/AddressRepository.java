package com.mdgn.autoMakler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mdgn.autoMakler.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
