package com.tap.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.RestaurantDao;
import com.tap.model.Restaurant;

public class RestaurantDaoImpl implements RestaurantDao{
	
	final static String INSERT_QUERY="INSERT INTO `restaurant`(`restaurantId`,`name`,"
			+ "`imagePath`,`ratings`,`eta`,`cuisineType`,`address`,`isActive`,`restaurantOwnerId`)"
			+ "values(?,?,?,?,?,?,?,?,?)";
	
	final static String SELECT_QUERY="SELECT * FROM `restaurant` WHERE `restaurantId`=?";
	
	final static String UPDATE_QUERY="UPDATE `restaurant` SET `name`=?,`imagePath`=?,`ratings`=?,`eta`=?,"
			+ "`cuisineType`=?,`address`=?,`isActive`=?,`restaurantOwnerId`=? WHERE `restaurantId`=?";
	
	final static String DELETE_QUERY="DELETE FROM `restaurant` WHERE `restaurantId`=?";
	
	final static String SELECT_ALL_QUERY="SELECT * FROM `restaurant`";
	
	private static Connection connection;
	
	public RestaurantDaoImpl() {
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
	public void addRestaurant(Restaurant restaurant) {
		PreparedStatement preparestatement=null;
		try {
			preparestatement=connection.prepareStatement(INSERT_QUERY);
			
			preparestatement.setInt(1, restaurant.getRestaurantId());
			preparestatement.setString(2, restaurant.getName());
			preparestatement.setString(3, restaurant.getImagePath());
			preparestatement.setFloat(4, restaurant.getRatings());
			preparestatement.setString(5, restaurant.getEta());
			preparestatement.setString(6,restaurant.getCuisineType());
			preparestatement.setString(7, restaurant.getAddress());
			preparestatement.setBoolean(8, restaurant.isActive());
			preparestatement.setInt(9, restaurant.getRestaurantOwnerId());
			
			int update = preparestatement.executeUpdate();
			System.out.println(update);
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Restaurant getRestaurant(int restaurantId) {
		PreparedStatement preparestatement=null;
		ResultSet res=null;
		Restaurant restaurant=null;
		try {
			preparestatement=connection.prepareStatement(SELECT_QUERY);
			
			preparestatement.setInt(1, restaurantId);
			res = preparestatement.executeQuery();
			
			while(res.next()) {
				String name = res.getString("name");
				String imagePath = res.getString("imagePath");
				float ratings = res.getFloat("ratings");
				String eta = res.getString("eta");
				String cuisineType = res.getString("cuisineType");
				String address = res.getString("address");
				boolean isActive = res.getBoolean("isActive");
				int restaurantOwnerId = res.getInt("restaurantOwnerId");
				
				restaurant = new Restaurant(restaurantId, name, imagePath, ratings, eta, cuisineType, address, isActive, restaurantOwnerId);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return restaurant;
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) {
		PreparedStatement preparestatement=null;
		try {
			preparestatement=connection.prepareStatement(UPDATE_QUERY);
			
			preparestatement.setString(1, restaurant.getName());
			preparestatement.setString(2, restaurant.getImagePath());
			preparestatement.setFloat(3, restaurant.getRatings());
			preparestatement.setString(4, restaurant.getEta());
			preparestatement.setString(5, restaurant.getCuisineType());
			preparestatement.setString(6, restaurant.getAddress());
			preparestatement.setBoolean(7, restaurant.isActive());
			preparestatement.setInt(8, restaurant.getRestaurantOwnerId());
			preparestatement.setInt(9, restaurant.getRestaurantId());
			
			preparestatement.executeUpdate();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		PreparedStatement preparestatement=null;
		try {
			preparestatement=connection.prepareStatement(DELETE_QUERY);
			
			preparestatement.setInt(1, restaurantId);
			preparestatement.executeUpdate();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		Statement statement=null;
		ResultSet res=null;
		ArrayList<Restaurant> list = new ArrayList<Restaurant>();
		try {
			statement = connection.createStatement();
			res=statement.executeQuery(SELECT_ALL_QUERY);
			while(res.next()) {
				int restaurantId = res.getInt("restaurantId");
				String name = res.getString("name");
				String imagePath = res.getString("imagePath");
				float ratings = res.getFloat("ratings");
				String eta = res.getString("eta");
				String cuisineType = res.getString("cuisineType");
				String address = res.getString("address");
				boolean isActive = res.getBoolean("isActive");
				int restaurantOwnerId = res.getInt("restaurantOwnerId");
				Restaurant restaurant=new Restaurant(restaurantId, name, imagePath, ratings, eta, cuisineType, address, isActive, restaurantOwnerId);
				list.add(restaurant);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	

}
