package com.scalar.order.demo.service.impl;

import java.rmi.UnexpectedException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.scalar.order.demo.exception.ResourceNotFoundException;
import com.scalar.order.demo.model.Orders;
import com.scalar.order.demo.repository.OrderRepository;
import com.scalar.order.demo.service.OrderService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepo;
	
	private final static String RESOURCE = "Order";
	
	private final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Override
	public String deleteOrder(Integer orderid) throws Exception {
		logger.info("delete  "+RESOURCE + orderid);

		try {
			
			this.orderRepo.deleteById(orderid);
			//.orElseThrow(() -> new ResourceAccessException("Delete Process Fail") );
			
		}catch(Exception ex) {
			throw new UnexpectedException("Exception in "+RESOURCE+" Method");
		}
		return RESOURCE + " deleted.";
	}

	@Override
	public Orders updateOrder(Orders order) throws Exception {
		logger.info("add  "+RESOURCE + order);

		try {
			
			return Optional.of(this.orderRepo.save(order)).orElseThrow(() -> new ResourceAccessException("Incomplete Add Process") );
			
		}catch(Exception ex) {
			throw new UnexpectedException("Exception in "+RESOURCE+" Method");
		}
	}

	@Override
	public Orders addOrder(Orders order) throws Exception {
		logger.info("add  "+RESOURCE + order);

		try {
			
			return Optional.of(this.orderRepo.save(order)).orElseThrow(() -> new ResourceAccessException("Incomplete Add Process") );
			
		}catch(Exception ex) {
			throw new UnexpectedException("Exception in "+RESOURCE+" Method");
		}
	}

	@Override
	public Orders getOrder(Integer id) throws Exception {
		try {
			return this.orderRepo.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException(RESOURCE + id + " not found"));
			
		} catch (Exception ex) {
			throw new UnexpectedException("Exception in "+ RESOURCE +" Method " +  id);
		}
	}

	@Override
	public List<Orders> getOrders() throws Exception {
		try {
			return (List<Orders>) this.orderRepo.findAll();
			
		} catch (Exception ex) {
			throw new UnexpectedException("Exception in "+ RESOURCE +" list Method. " );
		}
	}


}
