package com.mdgn.autoMakler.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mdgn.autoMakler.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
	Optional<User> findByUsername(String username);
}
