package com.scalar.order.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.scalar.order.demo.model.Orders;

@Service
public interface OrderService{

	public String deleteOrder(Integer bookid) throws Exception;
	public Orders updateOrder(Orders book) throws Exception;
	public Orders addOrder(Orders book) throws Exception;
	public Orders getOrder(Integer id) throws Exception;
	public List<Orders> getOrders() throws Exception;
	
}
