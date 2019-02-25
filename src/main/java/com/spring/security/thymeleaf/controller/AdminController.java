package com.spring.security.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("admin")
public class AdminController {

	@GetMapping("/index")
	public String index(ModelMap model) {
		model.addAttribute("view", "admin/index");
//	ModelAndView view = new ModelAndView();
//	view.setViewName("fragments/main");
//	view.addObject("view", "admin/index");
		return "fragments/main";
	}
}
