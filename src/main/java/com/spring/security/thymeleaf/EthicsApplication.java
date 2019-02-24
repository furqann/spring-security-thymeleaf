package com.spring.security.thymeleaf;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.security.thymeleaf.model.Role;
import com.spring.security.thymeleaf.model.User;
import com.spring.security.thymeleaf.repository.UserRepository;
import com.spring.security.thymeleaf.service.UserService;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class})
public class EthicsApplication implements CommandLineRunner {

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
		User u = new User();
		u.setFullName("Robert Chuwaza");
		u.setUsername("robert");
		u.setActive(false);
		//u.setRole(new Role());
		//userService.save(u);
	}

}

