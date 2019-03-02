package com.spring.security.thymeleaf.util;

import org.springframework.ui.ModelMap;

/**
 * @author Furqan
 */
public class ViewUtil {
	
	/**
	 * Set the master page address
	 */
	private static final String MAIN_VIEW = "fragments/main";
	
	
	/**
	 * @param model Should be of type ModelMap.
	 * @param pageTitle Title you want to display on browser tab.
	 * @param view Location of the view e.g view/user/index
	 * @return main view location.
	 */
	public static String generateView(ModelMap model, String pageTitle, String view) {
		model.addAttribute("pageTitle", pageTitle);
		model.addAttribute("view", view);
		return MAIN_VIEW;
	}
}
