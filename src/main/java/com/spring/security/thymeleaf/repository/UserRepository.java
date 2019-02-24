package com.spring.security.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.security.thymeleaf.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
