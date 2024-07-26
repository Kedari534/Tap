package com.tap.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.OrderItemDao;
import com.tap.model.OrderItems;

public class OrderItemsDaoImpl implements OrderItemDao{
	
	final static String INSERT_QUERY="INSERT INTO `orderitems`(`orderItemId`,`userId`,`menuId`,`itemName`,"
			+ "`ratings`,`quantity`,`price`) VALUES (?,?,?,?,?,?,?)";
	
	final static String SELECT_QUERY="SELECT * FROM `orderitems` WHERE `orderItemId`=?";
	
	final static String UPDATE_QUERY="UPDATE `orderitems` SET `userId`=?,`menuId`=?,`itemName`=?,"
			+ "`ratings`=?,`quantity`=?,`price`=? WHERE `orderItemId`=?";
	
	final static String DELETE_QUERY="DELETE FROM `orderitems` WHERE `orderItemId`=?";
	
	final static String SELECT_ALL_QUERY="SELECT * FROM `orderitems`";
	
	private Connection connection;
	
	public OrderItemsDaoImpl() {
		String url="jdbc:mysql://localhost:3306/tapfoods";
		String username="root";
		String password="root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,username,password);
			
		}
		catch(ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addOrderItem(OrderItems orderItem) {
		PreparedStatement preparestatement;
		try {
			preparestatement = connection.prepareStatement(INSERT_QUERY);
			
			preparestatement.setInt(1, orderItem.getOrderItemId());
			preparestatement.setInt(2, orderItem.getUserId());
			preparestatement.setInt(3, orderItem.getMenuId());
			preparestatement.setString(4, orderItem.getItemName());
			preparestatement.setFloat(5, orderItem.getRatings());
			preparestatement.setInt(6, orderItem.getQuantity());
			preparestatement.setFloat(7, orderItem.getPrice());
			
			preparestatement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public OrderItems getOrderItem(int orderItemId) {
		
		PreparedStatement preparestatement;
		ResultSet res=null;
		OrderItems orderitem=null;
		try {
			preparestatement=connection.prepareStatement(SELECT_QUERY);
			preparestatement.setInt(1, orderItemId);
			res=preparestatement.executeQuery();
			while(res.next()) {
				int userId = res.getInt("userId");
				int menuId = res.getInt("menuId");
				String itemName = res.getString("itemName");
				float ratings = res.getFloat("ratings");
				int quantity = res.getInt("quantity");
				float price = res.getFloat("price");
				orderitem = new OrderItems(orderItemId, userId, menuId, itemName, ratings, quantity, price);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return orderitem;
	}

	@Override
	public void updateOrderItem(OrderItems orderItem) {
		PreparedStatement preparestatement;
		
		try {
			preparestatement=connection.prepareStatement(UPDATE_QUERY);
			
			preparestatement.setInt(1, orderItem.getUserId());
			preparestatement.setInt(2, orderItem.getMenuId());
			preparestatement.setString(3, orderItem.getItemName());
			preparestatement.setFloat(4, orderItem.getRatings());
			preparestatement.setInt(5, orderItem.getQuantity());
			preparestatement.setFloat(6, orderItem.getPrice());
			preparestatement.setInt(7, orderItem.getOrderItemId());
			preparestatement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOrderItem(int orderItemId) {
		PreparedStatement preparestatement;
		try {
			preparestatement=connection.prepareStatement(DELETE_QUERY);
			
			preparestatement.setInt(1, orderItemId);
			preparestatement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<OrderItems> getAllOrderItems() {
		Statement statement;
		ResultSet res=null;
		OrderItems orderitem=null;
		ArrayList<OrderItems> list = new ArrayList<OrderItems>();
		
		try {
			statement=connection.createStatement();
			res=statement.executeQuery(SELECT_ALL_QUERY);
			
			while(res.next()) {
				int orderItemId=res.getInt("orderItemId");
				int userId = res.getInt("userId");
				int menuId = res.getInt("menuId");
				String itemName = res.getString("itemName");
				float ratings = res.getFloat("ratings");
				int quantity = res.getInt("quantity");
				float price = res.getFloat("price");
				orderitem=new OrderItems(orderItemId, userId, menuId, itemName, ratings, quantity, price);
				list.add(orderitem);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
