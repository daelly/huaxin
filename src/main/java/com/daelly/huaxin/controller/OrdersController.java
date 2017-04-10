package com.daelly.huaxin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.daelly.huaxin.domain.Orders;
import com.daelly.huaxin.service.OrdersService;

@RestController
@RequestMapping(value="/api/orders")
public class OrdersController {
	
	@Autowired
	private OrdersService service;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public List<Orders> findAll() {
		return service.findAll();
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public Integer insert(@ModelAttribute Orders order) {
		return service.insertOrder(order);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public Integer update(Integer id, String state) {
		return service.updateOrderState(id, state);
	}
	@RequestMapping(value="/query", method=RequestMethod.GET)
	public List<Orders> query() {
		return service.findAll();
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public Integer delete(Integer id) {
		return service.deleteOrder(id);
	}
	
}
