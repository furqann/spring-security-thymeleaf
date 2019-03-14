package com.spring.security.thymeleaf.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping(value = {"/","/index"})
	public String index(ModelMap model) {
		model.addAttribute("books", bookService.findAll());
		return ViewUtil.generateView(model, "Book Rack", "book/index");
	}
	
	@GetMapping("/add")
	public String save(ModelMap model, Book bookForm) {
		model.addAttribute("bookForm", bookForm);
		return ViewUtil.generateView(model,"Add Book", "book/save");
	}
	
	@PostMapping("/add")
	public String save(ModelMap model, @Valid @ModelAttribute("bookForm") Book bookForm, BindingResult result) {
		
		if(result.hasErrors()) {
			model.addAttribute("bookForm", bookForm);
			return ViewUtil.generateView(model,"Add Book", "book/save");
		}
		
		bookService.save(bookForm);
		return "redirect:index";
	}
	
	@GetMapping("/details/{id}")
	public String details(ModelMap model,@PathVariable("id") String id) {
		Book book = null;
		try {
			book = bookService.findById(Long.parseLong(id));
		}
		catch(NumberFormatException ex) {
			System.out.println(ex);
		}
//		Book book = bookService.findById(id);
		model.addAttribute("book", book);
		return ViewUtil.generateView(model, "Book Detail", "book/details");
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable String id) {
		try {
			bookService.delete(Long.parseLong(id));
		}
		catch(NumberFormatException ex) {
			System.out.println(ex);
		}
		return "redirect:/book/index";
	}
}
