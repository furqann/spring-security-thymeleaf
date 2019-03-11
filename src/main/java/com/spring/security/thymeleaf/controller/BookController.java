package com.spring.security.thymeleaf.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.security.thymeleaf.model.Book;
import com.spring.security.thymeleaf.service.BookService;
import com.spring.security.thymeleaf.util.ViewUtil;

@Controller
@RequestMapping("book")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping(value = {"/","/index","**"})
	public String index(ModelMap model) {
		model.addAttribute("books", bookService.findAll());
		return ViewUtil.generateView(model, "Book Rack", "book/index");
	}
	
	@GetMapping("/add")
	public String save(ModelMap model, Book book) {
		//model.addAttribute("bookForm", bookForm);
		return ViewUtil.generateView(model,"Add Book", "book/save");
	}
	
	@PostMapping("/add")
	public String save(ModelMap model, @Valid Book book, BindingResult result) {
		
		if(result.hasErrors()) {
			return ViewUtil.generateView(model,"Add Book", "book/save");
		}
		
		bookService.save(book);
		return "redirect:index";
	}
}
