package com.mdgn.autoMakler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mdgn.autoMakler.model.SaledCar;

@Repository
public interface SaledCarRepository extends JpaRepository<SaledCar, Long> {

	
}
