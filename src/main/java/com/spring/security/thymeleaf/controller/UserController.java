package com.spring.security.thymeleaf.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.security.thymeleaf.model.User;
import com.spring.security.thymeleaf.service.UserService;
import com.spring.security.thymeleaf.util.ViewUtil;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(value = {"/", "/index" })
	public String index(ModelMap model) {
		
		Collection<User> users = userService.findAll(); 
		model.addAttribute("users", users);

		return ViewUtil.generateView(model, "User Management", "user/index");
	}
	
	@GetMapping("/details/{id}")
	public String details(ModelMap model, @PathVariable("id") int userId) {
		model.addAttribute("id", userId);
		return ViewUtil.generateView(model, "User Details", "user/details");
	}
	
}
