package com.library.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    
	Optional<User>findByName(String username);
}
