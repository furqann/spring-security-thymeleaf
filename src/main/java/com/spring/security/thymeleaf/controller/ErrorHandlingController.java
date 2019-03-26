package com.spring.security.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.security.thymeleaf.util.ViewUtil;

@Controller
public class ErrorHandlingController {
	@GetMapping("/403")
	public String accessDeniedPage(ModelMap model) {
		return ViewUtil.generateView(model, "Access Denied 403", "errors/accessdenied");
	}
}
