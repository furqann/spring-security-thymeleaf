package com.spring.security.thymeleaf.service;

import java.util.Collection;

import com.spring.security.thymeleaf.model.Book;

public interface BookService {
	Book findByName();
	Collection<Book> findAll();
	void save(Book book);
	void update(int id, Book book);
	void delete(int id);
}
