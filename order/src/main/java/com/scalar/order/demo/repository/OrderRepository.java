package com.scalar.order.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.scalar.order.demo.model.Orders;

public interface OrderRepository extends CrudRepository<Orders, Integer>{

	public List<Orders> findByStatus(String status);
	public Orders findByBookid(Integer bookId);

}
