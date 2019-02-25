package com.spring.security.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.security.thymeleaf.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
}
