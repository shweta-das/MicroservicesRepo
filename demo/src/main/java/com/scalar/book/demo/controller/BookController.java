package com.scalar.book.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scalar.book.demo.model.Books;
import com.scalar.book.demo.service.BookService;

@RestController
@RequestMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {

	private final Logger logger = LoggerFactory.getLogger(BookController.class);
	private final static String RESOURCE = "BookController";

	@Autowired
	private BookService bookService;

	@GetMapping
	public ResponseEntity<?> getBooks() throws Exception {
		logger.info(RESOURCE +" getBooks() ");
		return ResponseEntity.ok().body(this.bookService.getBooks());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getBook(@PathVariable Integer id) throws Exception {
		logger.info(RESOURCE +" getBook() "+id);
		return ResponseEntity.ok().body(this.bookService.getBook(id));
	}
	
	@PostMapping
	public ResponseEntity<?> addBook(@RequestBody Books book) throws Exception {
		logger.info(RESOURCE +" addBook() " + book);
		return ResponseEntity.ok().body(this.bookService.addBook(book));
	}

	@PutMapping
	public ResponseEntity<?> updateBook(@RequestBody Books book) throws Exception {
		logger.info(RESOURCE +" updateBook() " + book);
		return ResponseEntity.ok().body(this.bookService.updateBook(book));
	}

	@DeleteMapping("/{bookid}")
	public ResponseEntity<?> deleteBook(@PathVariable Integer bookid) throws Exception {
		logger.info(RESOURCE +" deleteBook() " + bookid);
		return ResponseEntity.ok().body(this.bookService.deleteBook(bookid));	
	}
//@RequestParam("bookid")
}
