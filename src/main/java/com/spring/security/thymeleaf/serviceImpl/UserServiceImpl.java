package com.spring.security.thymeleaf.serviceImpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.security.thymeleaf.model.User;
import com.spring.security.thymeleaf.repository.UserRepository;
import com.spring.security.thymeleaf.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRespository; 
	
	@Override
	public Collection<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userRespository.save(user);
	}

	@Override
	public void update(int id, User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id, User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findByEmail(String emailAddress) {
		// TODO Auto-generated method stub
		return userRespository.findByEmail(emailAddress);
	}

}
