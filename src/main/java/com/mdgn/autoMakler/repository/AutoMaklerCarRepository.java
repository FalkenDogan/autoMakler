package com.mdgn.autoMakler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mdgn.autoMakler.model.AutoMaklersCar;

@Repository
public interface AutoMaklerCarRepository extends JpaRepository <AutoMaklersCar, Long> {

}
