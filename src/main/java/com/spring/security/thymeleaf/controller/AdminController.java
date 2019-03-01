package com.spring.security.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {

	@GetMapping(value = {"/", "/index"})
	public String index(ModelMap model) {
		model.addAttribute("view", "admin/index");
		return "fragments/main";
	}
}
