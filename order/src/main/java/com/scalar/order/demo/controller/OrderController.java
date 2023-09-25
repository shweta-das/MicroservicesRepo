package com.scalar.order.demo.controller;

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

import com.scalar.order.demo.model.Orders;
import com.scalar.order.demo.service.OrderService;

@RestController
@RequestMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

	private final Logger logger = LoggerFactory.getLogger(OrderController.class);
	private final static String RESOURCE = "OrderController";

	@Autowired
	private OrderService orderService;

	@GetMapping
	public ResponseEntity<?> getOrders() throws Exception {
		logger.info(RESOURCE +" getOrders() ");
		return ResponseEntity.ok().body(this.orderService.getOrders());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getOrder(@PathVariable Integer id) throws Exception {
		logger.info(RESOURCE +" getOrder() "+id);
		return ResponseEntity.ok().body(this.orderService.getOrder(id));
	}
	
	@PostMapping
	public ResponseEntity<?> addOrder(@RequestBody Orders book) throws Exception {
		logger.info(RESOURCE +" addOrder() " + book);
		return ResponseEntity.ok().body(this.orderService.addOrder(book));
	}

	@PutMapping
	public ResponseEntity<?> updateOrder(@RequestBody Orders book) throws Exception {
		logger.info(RESOURCE +" updateOrder() " + book);
		return ResponseEntity.ok().body(this.orderService.updateOrder(book));
	}

	@DeleteMapping("/{bookid}")
	public ResponseEntity<?> deleteOrder(@PathVariable Integer bookid) throws Exception {
		logger.info(RESOURCE +" deleteOrder() " + bookid);
		return ResponseEntity.ok().body(this.orderService.deleteOrder(bookid));	
	}
//@RequestParam("bookid")
}
