package com.spring.security.thymeleaf.util;

import org.springframework.ui.ModelMap;

public class ViewUtil {
	
	private static final String MAIN_VIEW = "fragments/main";
	
	public static String generateView(ModelMap model, String pageTitle, String view) {
		model.addAttribute("pageTitle", pageTitle);
		model.addAttribute("view", view);
		return MAIN_VIEW;
	}
}
