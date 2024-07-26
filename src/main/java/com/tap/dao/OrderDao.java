package com.tap.dao;

import java.util.List;

import com.tap.model.Orders;

public interface OrderDao {

	void addOrder(Orders order);
	Orders getOrder(int orderId);
	void updateOrder(Orders order);
	void deleteOrder(int orderId);
	List<Orders> getAllOrders();
}
