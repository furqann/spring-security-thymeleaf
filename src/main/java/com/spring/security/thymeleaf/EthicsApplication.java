package com.spring.security.thymeleaf;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.security.thymeleaf.model.Role;
import com.spring.security.thymeleaf.model.User;
import com.spring.security.thymeleaf.repository.UserRepository;
import com.spring.security.thymeleaf.service.*;
import com.spring.security.thymeleaf.service.UserService;

@SpringBootApplication/*(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class})*/
public class EthicsApplication implements CommandLineRunner {

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(EthicsApplication.class, args);
	}
	
	//Whenever a spring application starts this method will run automatically.
	//Function of a implemented interface CommandLineRunner
	@Override
	public void run(String... args) {
		//userRepository.save(new User);
//		User u = new User();
//		Role role = new Role();
//		role.setRoleId(9);
//		u.setFullName("Robert James");
//		u.setUsername("james");
//		u.setEmail("james@r.com");
//		u.setActive(true);
//		u.setRole(role);
//		userService.save(u);
		//User u = userService.findByEmail("robert@r.com");
		//System.out.println(u.toString());
//		Role r1 = new Role();
//		r1.setName("Admin");
//		
//		Role r2 = new Role();
//		r2.setName("User");
//		
//		roleService.save(r1);
//		roleService.save(r2);
	}

}

