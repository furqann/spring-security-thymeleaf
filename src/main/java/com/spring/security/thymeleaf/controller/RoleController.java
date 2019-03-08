package com.spring.security.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.security.thymeleaf.model.Role;
import com.spring.security.thymeleaf.service.RoleService;
import com.spring.security.thymeleaf.util.ViewUtil;

@Controller
@RequestMapping("role")
public class RoleController {

	@Autowired
	RoleService roleService;
	
	//GET Index
	@GetMapping(value = {"/","/index"})
	public String index(ModelMap model) {
		model.addAttribute("roles", roleService.findAll());
		return ViewUtil.generateView(model, "Roles", "role/index");
	}
	
	//GET Add
	@GetMapping("/save")
	public String save(ModelMap model, Role roleForm) {
		return ViewUtil.generateView(model, "Add", "role/roleform");
	}
	//POST Add
	
	//GET Edit
	//POST Edit
	
	//GET Delete
}
