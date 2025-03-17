package com.pontta.hardware_shopping.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pontta.hardware_shopping.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    Boolean existsByEmail(String email);

    List<User> findByNameContainingIgnoreCase(String name);

}
