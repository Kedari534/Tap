package com.tap.dao;

import java.util.List;

import com.tap.model.OrderItems;

public interface OrderItemDao {

	void addOrderItem(OrderItems orderItem);
	OrderItems getOrderItem(int orderItemId);
	void updateOrderItem(OrderItems orderItem);
	void deleteOrderItem(int orderItemId);
	List<OrderItems> getAllOrderItems();
}
