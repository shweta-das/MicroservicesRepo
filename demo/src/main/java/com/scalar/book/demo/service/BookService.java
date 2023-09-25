package com.scalar.book.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.scalar.book.demo.model.Books;

@Service
public interface BookService{

	public String deleteBook(Integer bookid) throws Exception;
	public Books updateBook(Books book) throws Exception;
	public Books addBook(Books book) throws Exception;
	public Books getBook(Integer id) throws Exception;
	public List<Books> getBooks() throws Exception;
	
}
