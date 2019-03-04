package com.spring.security.thymeleaf.serviceImpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.security.thymeleaf.model.Role;
import com.spring.security.thymeleaf.repository.RoleRepository;
import com.spring.security.thymeleaf.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public Collection<Role> findAll() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}
	
	@Override
	public Role findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Role role) {
		// TODO Auto-generated method stub
		roleRepository.save(role);
	}

	@Override
	public void update(int id, Role role) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id, Role role) {
		// TODO Auto-generated method stub

	}

}
