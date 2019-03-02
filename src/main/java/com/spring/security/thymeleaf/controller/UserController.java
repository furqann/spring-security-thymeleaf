package com.spring.security.thymeleaf.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.security.thymeleaf.model.User;
import com.spring.security.thymeleaf.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(value = {"/", "/index" })
	public String index(ModelMap model) {
		
		Collection<User> users = userService.findAll(); 
		model.addAttribute("users", users);
		
		model.addAttribute("view", "user/index");
		return "fragments/main";
	}
	
}
