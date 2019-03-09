package com.spring.security.thymeleaf.serviceImpl;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.security.thymeleaf.model.Book;
import com.spring.security.thymeleaf.repository.BookRepository;
import com.spring.security.thymeleaf.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public Book findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Book> findAll() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	@Override
	public void save(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Book findById(long id) {
		// TODO Auto-generated method stub
		Book book =  bookRepository.findById(id); 
		return book;
	}

	@Override
	public void update(long id, Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(id);
	}

}
