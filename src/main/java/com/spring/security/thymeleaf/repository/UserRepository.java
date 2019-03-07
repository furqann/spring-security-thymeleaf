package com.spring.security.thymeleaf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.security.thymeleaf.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("SELECT u FROM User u where u.userId = :id")
	User findById(int id);
	
	@Query("SELECT u from User u order by u.userId desc")
	List<User> findAll();
	
	@Query("SELECT u FROM User u where u.email = :emailAddress")
	User findByEmail(String emailAddress);
}
