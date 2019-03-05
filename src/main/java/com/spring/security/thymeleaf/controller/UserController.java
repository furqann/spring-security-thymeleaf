package com.spring.security.thymeleaf.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.security.thymeleaf.dto.UserDto;
import com.spring.security.thymeleaf.model.Role;
import com.spring.security.thymeleaf.model.User;
import com.spring.security.thymeleaf.service.RoleService;
import com.spring.security.thymeleaf.service.UserService;
import com.spring.security.thymeleaf.util.ViewUtil;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;

	@GetMapping(value = { "/", "/index" })
	public String index(ModelMap model) {

		Collection<User> users = userService.findAll();
		model.addAttribute("users", users);

		return ViewUtil.generateView(model, "User Management", "user/index");
	}

	@GetMapping("/save")
	public String save(ModelMap model) {
		UserDto user = new UserDto();
		user.setRoles(roleService.findAll());

		Collection<Role> roles = user.getRoles();
		for (Role role : roles) {
			System.out.println( role.getName() );
		}

		model.addAttribute("userDto", user);
		return ViewUtil.generateView(model, "New User", "user/save");
	}

	@PostMapping("/save")
	public String save(ModelMap model, UserDto userDto, BindingResult bindingResult) {
		Role role = new Role();
		System.out.println(userDto.getUser().toString());
		userService.save(userDto.getUser());
		return "redirect:index";
	}

	@GetMapping("/details/{id}")
	public String details(ModelMap model, @PathVariable("id") int userId) {

		User user = userService.findById(userId);
		model.addAttribute("user", user);

		return ViewUtil.generateView(model, "User Details", "user/details");
	}

	@GetMapping("/edit/{id}")
	public String update(ModelMap model, @PathVariable("id") int id) {

		User user = userService.findById(id);
		model.addAttribute("user", user);

		return ViewUtil.generateView(model, "Edit", "user/edit");
	}

	@PostMapping("/edit/{id}")
	public String update(ModelMap model, @PathVariable("id") int id, User user) {

		System.out.println(user.toString());

		userService.update(id, user);

		return "redirect:/user/index";
	}

}
