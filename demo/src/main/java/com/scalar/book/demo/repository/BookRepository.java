package com.scalar.book.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.scalar.book.demo.model.Books;

public interface BookRepository extends CrudRepository<Books, Integer>{

	public Books findByTitle(String bookTitle);

}
