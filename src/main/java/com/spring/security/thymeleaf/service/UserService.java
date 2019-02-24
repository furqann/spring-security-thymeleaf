package com.spring.security.thymeleaf.service;

import java.util.Collection;
import com.spring.security.thymeleaf.model.*;
public interface UserService {
	Collection<User> findAll();
	User findById(int id);
	void save(User user);
	void update(int id, User user);
	void delete(int id, User user);
}
