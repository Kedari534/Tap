package com.tap.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.OrderHistoryDao;
import com.tap.model.OrderHistory;

public class OrderHistoryDaoImpl implements OrderHistoryDao {
	
	final static String INSERT_QUERY="INSERT INTO `orderhistory`(`orderHistoryId`,`orderId`,`userId`)"
			+ "VALUES(?,?,?)";
	
	final static String SELECT_QUERY="SELECT * FROM `orderhistory` WHERE `orderHistoryId`=?";
	
	final static String UPDATE_QUERY="UPDATE `orderhistory` SET `orderId`=?,`userId`=? WHERE `orderHistoryId`=?";
	
	final static String DELETE_QUERY="DELETE FROM `orderhistory` WHERE `orderHistoryId`=?";
	
	final static String SELECT_ALL_QUERY="SELECT * FROM `orderhistory`";
	
	
	private Connection connection;
	
	public OrderHistoryDaoImpl() {
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
	public void addOrderHistory(OrderHistory orderHistory) {
		PreparedStatement preparestatement;
		try {
			preparestatement=connection.prepareStatement(INSERT_QUERY);
			
			preparestatement.setInt(1, orderHistory.getOrderHistoryId());
			preparestatement.setInt(2, orderHistory.getOrderId());
			preparestatement.setInt(3, orderHistory.getUserId());
			preparestatement.executeUpdate();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public OrderHistory getOrderHistory(int orderHistoryId) {
		PreparedStatement preparestatement;
		ResultSet res=null;
		OrderHistory orderhistory=null;
		try {
			preparestatement=connection.prepareStatement(SELECT_QUERY);
			
			preparestatement.setInt(1, orderHistoryId);
			res=preparestatement.executeQuery();
			
			while(res.next()) {
				int orderId = res.getInt("orderId");
				int userId = res.getInt("userId");
				orderhistory=new OrderHistory(orderHistoryId, orderId, userId);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return orderhistory;
	}

	@Override
	public void updateOrderHistory(OrderHistory orderHistory) {
		PreparedStatement preparestatement;
		try {
			preparestatement=connection.prepareStatement(UPDATE_QUERY);
			
			preparestatement.setInt(1, orderHistory.getOrderId());
			preparestatement.setInt(2, orderHistory.getUserId());
			preparestatement.setInt(3, orderHistory.getOrderHistoryId());
			preparestatement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOrderHistory(int orderHistoryId) {
		PreparedStatement preparestatement;
		try {
			preparestatement=connection.prepareStatement(DELETE_QUERY);
			
			preparestatement.setInt(1, orderHistoryId);
			preparestatement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<OrderHistory> getAllOrderHistory() {
		Statement statement;
		ResultSet res=null;
		OrderHistory orderHistory=null;
		ArrayList<OrderHistory> list = new ArrayList<OrderHistory>();
		
		try {
			statement=connection.createStatement();
			res=statement.executeQuery(SELECT_ALL_QUERY);
			while(res.next()) {
				int orderHistoryId=res.getInt("orderHistoryId");
				int orderId = res.getInt("orderId");
				int userId = res.getInt("userId");
				orderHistory=new OrderHistory(orderHistoryId, orderId, userId);
				list.add(orderHistory);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
