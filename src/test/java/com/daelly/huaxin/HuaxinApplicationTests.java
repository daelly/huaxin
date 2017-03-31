package com.daelly.huaxin;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.daelly.huaxin.domain.Orders;
import com.daelly.huaxin.service.OrdersService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HuaxinApplicationTests {
	
	@Autowired
	OrdersService service;

	@Test
	public void contextLoads() {
		Orders order = new Orders();
		order.setUsername("daelly");
		order.setPhone("15902096411");
		order.setProduct("卫衣");
		order.setSize("M");
		order.setNum(2);
		order.setCreatetime(new Date());
		order.setState("1");
		order.setAddress("广州车陂大塘中街东八巷");
		service.insertOrder(order);
		
		Orders o = service.findOne(1);
		System.out.println(o);
	}
	
	@Test
	public void testFindAll() {
		List<Orders> orders = service.findAll();
		System.out.println(orders);
	}
	
	@Test
	public void testUpdateState() {
		Orders order = service.findOne(5);
		if(order != null) {
			service.updateOrderState(order.getId(), "2");
		}
	}

}
