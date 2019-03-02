package com.spring.security.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.security.thymeleaf.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	
}
