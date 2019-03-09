package com.spring.security.thymeleaf.service;

import java.util.Collection;

import com.spring.security.thymeleaf.model.Book;

public interface BookService {
	Book findByName(String name);
	Book findById(long id);
	Collection<Book> findAll();
	void save(Book book);
	void update(long id, Book book);
	void delete(long id);
}
