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
	public String save(ModelMap model, UserDto userForm) {

		userForm.setRoles(roleService.findAll());
		model.addAttribute("userForm", userForm);
		
		return ViewUtil.generateView(model, "New User", "user/save");
	}

	@PostMapping("/save")
	public String save(ModelMap model, UserDto userForm, BindingResult bindingResult) {
		userService.save(userForm.getUser());
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
		
		UserDto user = new UserDto();
		user.setUser(userService.findById(id));
		user.setRoles(roleService.findAll());
		
		model.addAttribute("userForm", user);

		return ViewUtil.generateView(model, "Edit", "user/edit");
	}

	@PostMapping("/edit/{id}")
	public String update(ModelMap model, @PathVariable("id") int id, UserDto user) {
		
		User _user = user.getUser();
		userService.update(id, _user);

		return "redirect:/user/index";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		userService.delete(id, null);
		return "redirect:user/index";
	}

}
