package com.tap.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.OrderDao;
import com.tap.model.Orders;

public class OrderDaoImpl implements OrderDao{
	
	final static String INSERT_QUERY="INSERT INTO `orders`(`restaurantId`,"
			+ "`userId`,`totalAmount`,`modeOfPayment`,`status`) VALUES(?,?,?,?,?)";
	
	final static String SELECT_QUERY="SELECT * FROM `orders` WHERE `orderId`=?";
	
	final static String UPDATE_QUERY="UPDATE `orders` SET `restaurantId`=?,`userId`=?,`totalAmount`=?,"
			+ "`modeOfPayment`=?,`status`=? WHERE `orderId`=?";
	
	final static String DELETE_QUERY="DELETE FROM `orders` WHERE `orderId`=?";
	
	final static String SELECT_ALL_QUERY="SELECT * FROM `orders`";
	
	private Connection connection;
	
	public OrderDaoImpl() {
		String url="jdbc:mysql://localhost:3306/tapfoods";
		String username="root";
		String password="root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,username,password);
			
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addOrder(Orders order) {
		PreparedStatement preparestatement;
		try {
			preparestatement=connection.prepareStatement(INSERT_QUERY);
			
			preparestatement.setInt(1, order.getRestaurantId());
			preparestatement.setInt(2, order.getUserId());
			preparestatement.setFloat(3, order.getTotalAmount());
			preparestatement.setString(4, order.getModeOfPayment());
			preparestatement.setString(5, order.getStatus());
			preparestatement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Orders getOrder(int orderId) {
		PreparedStatement preparestatement;
		ResultSet res=null;
		Orders order=null;
		
		try {
			preparestatement=connection.prepareStatement(SELECT_QUERY);
			preparestatement.setInt(1, orderId);
			res=preparestatement.executeQuery();
			while(res.next()) {
				int restaurantId = res.getInt("restaurantId");
				int userId = res.getInt("userId");
				float totalAmount = res.getFloat("totalAmount");
				String modeOfPayment = res.getString("modeOfPayment");
				String status = res.getString("status");
				order=new Orders(orderId, restaurantId, userId, totalAmount, modeOfPayment, status);
			}
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public void updateOrder(Orders order) {
		PreparedStatement preparestatement;
		try {
			preparestatement=connection.prepareStatement(UPDATE_QUERY);
			
			preparestatement.setInt(1, order.getRestaurantId());
			preparestatement.setInt(2, order.getUserId());
			preparestatement.setFloat(3, order.getTotalAmount());
			preparestatement.setString(4, order.getModeOfPayment());
			preparestatement.setString(5, order.getStatus());
			preparestatement.setInt(6, order.getOrderId());
			
			preparestatement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOrder(int order) {
		PreparedStatement preparestatement;
		try {
			preparestatement=connection.prepareStatement(DELETE_QUERY);
			
			preparestatement.setInt(1, order);
			preparestatement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Orders> getAllOrders() {
		Statement statement;
		ResultSet res=null;
		Orders order=null;
		ArrayList<Orders> list = new ArrayList<Orders>();
		try {
			statement=connection.createStatement();
			res=statement.executeQuery(SELECT_ALL_QUERY);
			
			while(res.next()) {
				int orderId = res.getInt("orderId");
				int restaurantId = res.getInt("restaurantId");
				int userId = res.getInt("userId");
				float totalAmount = res.getFloat("totalAmount");
				String modeOfPayment = res.getString("modeOfPayment");
				String status = res.getString("status");
				order = new Orders(orderId, restaurantId, userId, totalAmount, modeOfPayment, status);
				list.add(order);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
