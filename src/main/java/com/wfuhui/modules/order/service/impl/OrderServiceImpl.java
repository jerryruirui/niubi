package com.wfuhui.modules.order.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wfuhui.common.utils.NumberUtil;
import com.wfuhui.modules.member.dao.MemberDao;
import com.wfuhui.modules.order.dao.OrderDao;
import com.wfuhui.modules.order.dao.OrderScenicDao;
import com.wfuhui.modules.order.entity.OrderEntity;
import com.wfuhui.modules.order.entity.OrderScenicEntity;
import com.wfuhui.modules.order.service.OrderService;



@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderScenicDao orderScenicDao;
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public OrderEntity queryObject(Integer id){
		OrderEntity order = orderDao.queryObject(id);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orderId", order.getId());
		List<OrderScenicEntity> orderscenicList = orderScenicDao.queryList(params);
		order.setOrderscenicList(orderscenicList);
		order.setMember(memberDao.queryObject(order.getMemberId()));
		return order;
	}
	
	@Override
	public List<OrderEntity> queryList(Map<String, Object> map){
		List<OrderEntity> orderList = orderDao.queryList(map);
		for (OrderEntity orderEntity : orderList) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("orderId", orderEntity.getId());
			List<OrderScenicEntity> orderscenicList = orderScenicDao.queryList(params);
			orderEntity.setOrderscenicList(orderscenicList);
		}
		return orderList;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return orderDao.queryTotal(map);
	}
	
	@Override
	public void save(OrderEntity order){
		orderDao.save(order);
	}
	
	@Override
	public void update(OrderEntity order){
		orderDao.update(order);
	}
	
	@Override
	public void delete(Integer orderId){
		orderDao.delete(orderId);
	}
	
	@Override
	public void deleteBatch(Integer[] orderIds){
		orderDao.deleteBatch(orderIds);
	}

	@Override
	@Transactional
	public void createOrder(OrderEntity order) {
		order.setOrderNumber(NumberUtil.getOrderNumber());
		orderDao.save(order);
		List<OrderScenicEntity> orderscenicList = order.getOrderScenicList();
		for (OrderScenicEntity orderScenic : orderscenicList) {
			orderScenic.setOrderId(order.getId());
			orderScenicDao.save(orderScenic);
		}
	}

	@Override
	public void updateByOrderNumber(OrderEntity order) {
		orderDao.updateByOrderNumber(order);
	}

	@Override
	public List<Map<String, String>> queryOrderCount() {
		return orderDao.queryOrderCount();
	}
	
}
