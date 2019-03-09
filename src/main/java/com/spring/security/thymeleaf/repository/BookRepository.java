package com.spring.security.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.security.thymeleaf.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>  {
	
	@Query("SELECT b from Book b where b.bookId = :id")
	Book findById(long id);
}
