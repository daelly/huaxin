package com.daelly.huaxin.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daelly.huaxin.domain.Orders;
import com.daelly.huaxin.domain.OrdersExample;
import com.daelly.huaxin.mapper.OrdersMapper;

@Service
@Transactional
public class OrdersService {
	
	@Autowired
	OrdersMapper dao;

	/**
	 * 新增一条订单
	 * @param order
	 * @return
	 */
	public int insertOrder(Orders order) {
		order.setCreatetime(new Date());
		order.setState("1");
		return dao.insert(order);
	}
	
	/**
	 * 获取一条订单
	 * @param id
	 * @return
	 */
	public Orders findOne(Integer id) {
		return dao.selectByPrimaryKey(id);
	}
	
	/**
	 * 更新订单状态
	 * @param id
	 * @param state
	 * @return
	 */
	public int updateOrderState(Integer id, String state) {
		Orders order = new Orders();
		order.setId(id);
		order.setState(state);
		return dao.updateByPrimaryKeySelective(order);
	}
	
	/**
	 * 获取全部订单
	 * @return
	 */
	public List<Orders> findAll() {
		return dao.selectByExample(new OrdersExample());
	}
	
	/**
	 * 删除一条订单
	 * @param id
	 * @return
	 */
	public int deleteOrder(Integer id) {
		return dao.deleteByPrimaryKey(id);
	}
}
