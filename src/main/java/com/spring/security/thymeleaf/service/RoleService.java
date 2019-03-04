package com.spring.security.thymeleaf.service;

import java.util.Collection;

import com.spring.security.thymeleaf.model.Role;

public interface RoleService {
	Collection<Role> findAll();
	Role findById(int id);
	void save(Role role);
	void update(int id, Role role);
	void delete(int id, Role role);
}
