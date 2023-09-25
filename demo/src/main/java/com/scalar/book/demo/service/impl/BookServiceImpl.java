package com.scalar.book.demo.service.impl;

import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.scalar.book.demo.exception.ResourceNotFoundException;
import com.scalar.book.demo.model.Books;
import com.scalar.book.demo.repository.BookRepository;
import com.scalar.book.demo.service.BookService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepo;
	
	private final static String RESOURCE = "Book";
	
	private final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

	@Override
	public String deleteBook(Integer bookid) throws Exception {
		logger.info("delete  "+RESOURCE + bookid);

		try {
			
			this.bookRepo.deleteById(bookid);
			//.orElseThrow(() -> new ResourceAccessException("Delete Process Fail") );
			
		}catch(Exception ex) {
			throw new UnexpectedException("Exception in "+RESOURCE+" Method");
		}
		return RESOURCE + " deleted.";
	}

	@Override
	public Books updateBook(Books book) throws Exception {
		logger.info("add  "+RESOURCE + book);

		try {
			
			return Optional.of(this.bookRepo.save(book)).orElseThrow(() -> new ResourceAccessException("Incomplete Add Process") );
			
		}catch(Exception ex) {
			throw new UnexpectedException("Exception in "+RESOURCE+" Method");
		}
	}

	@Override
	public Books addBook(Books book) throws Exception {
		logger.info("add  "+RESOURCE + book);

		try {
			
			return Optional.of(this.bookRepo.save(book)).orElseThrow(() -> new ResourceAccessException("Incomplete Add Process") );
			
		}catch(Exception ex) {
			throw new UnexpectedException("Exception in "+RESOURCE+" Method");
		}
	}

	@Override
	public Books getBook(Integer id) throws Exception {
		try {
			return this.bookRepo.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException(RESOURCE + id + " not found"));
			
		} catch (Exception ex) {
			throw new UnexpectedException("Exception in "+ RESOURCE +" Method " +  id);
		}
	}

	@Override
	public List<Books> getBooks() throws Exception {
		try {
			return (List<Books>) this.bookRepo.findAll();
			
		} catch (Exception ex) {
			throw new UnexpectedException("Exception in "+ RESOURCE +" list Method. " );
		}
	}


}
