package com.tap.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.MenuDao;
import com.tap.model.Menu;

public class MenuDaoImpl implements MenuDao {
	
	final static String INSERT_QUERY="INSERT INTO `menu`(`name`,`price`,`description`,"
			+ "`imagePath`,`isAvailable`,`ratings`,`restaurantId`) VALUES(?,?,?,?,?,?,?)";
	
	final static String SELECT_QUERY="SELECT * FROM `menu` WHERE `menuId`=?";
	
	final static String UPDATE_QUERY="UPDATE `menu` SET `name`=?,`price`=?,`description`=?,"
			+ "`imagePath`=?,`isAvailable`=?,`ratings`=?,`restaurantId`=? WHERE `menuId`=?";
	
	final static String DELETE_QUERY="DELETE FROM `menu` WHERE `menuId`=?";
	
	final static String SELECT_ALL_QUERY="SELECT * FROM `menu`";
	
	final static String SELECT_MENU="SELECT * FROM `menu` WHERE `restaurantId`=?";
	

	private Connection connection;
	
	public MenuDaoImpl() {
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
	public void addMenu(Menu menu) {
		PreparedStatement preparestatement;
		
		try {
			preparestatement=connection.prepareStatement(INSERT_QUERY);
			
			preparestatement.setString(1, menu.getName());
			preparestatement.setFloat(2, menu.getPrice());
			preparestatement.setString(3, menu.getDescription());
			preparestatement.setString(4, menu.getImagePath());
			preparestatement.setBoolean(5, menu.isAvailable());
			preparestatement.setFloat(6, menu.getRatings());
			preparestatement.setInt(7,menu.getRestaurantId());
			
			preparestatement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Menu getMenu(int menuId) {
		PreparedStatement preparestatement;
		ResultSet res=null;
		Menu menu=null;
		
		try {
			preparestatement=connection.prepareStatement(SELECT_QUERY);
			
			preparestatement.setInt(1, menuId);
			res = preparestatement.executeQuery();
			
			while(res.next()) {
				String name = res.getString("name");
				float price = res.getFloat("price");
				String description = res.getString("description");
				String imagePath = res.getString("imagePath");
				boolean isAvailable = res.getBoolean("isAvailable");
				float ratings = res.getFloat("ratings");
				int restaurantId = res.getInt("restaurantId");
				menu = new Menu(menuId, name, price, description, imagePath, isAvailable, ratings, restaurantId);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return menu;
	}

	@Override
	public void updateMenu(Menu menu) {
		PreparedStatement preparestatement;
		
		try {
			preparestatement = connection.prepareStatement(UPDATE_QUERY);
			
			preparestatement.setString(1, menu.getName());
			preparestatement.setFloat(2, menu.getPrice());
			preparestatement.setString(3, menu.getDescription());
			preparestatement.setString(4, menu.getImagePath());
			preparestatement.setBoolean(5, menu.isAvailable());
			preparestatement.setFloat(6, menu.getRatings());
			preparestatement.setInt(7, menu.getRestaurantId());
			preparestatement.setInt(8, menu.getMenuId());
			
			preparestatement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteMenu(int menuId) {
		PreparedStatement preparestatement;
		try {
			preparestatement=connection.prepareStatement(DELETE_QUERY);
			
			preparestatement.setInt(1, menuId);
			preparestatement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Menu> getAllMenus() {
		Statement statement;
		ResultSet res=null;
		Menu menu=null;
		ArrayList<Menu> list = new ArrayList<Menu>();
		
		
		try {
			statement=connection.createStatement();
			res = statement.executeQuery(SELECT_ALL_QUERY);
			while(res.next()) {
				int menuId = res.getInt("menuId");
				String name = res.getString("name");
				float price = res.getFloat("price");
				String description = res.getString("description");
				String imagePath = res.getString("imagePath");
				boolean isAvailable = res.getBoolean("isAvailable");
				float ratings = res.getFloat("ratings");
				int restaurantId = res.getInt("restaurantId");
				menu=new Menu(menuId, name, price, description, imagePath, isAvailable, ratings, restaurantId);
				list.add(menu);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Menu> getMenuByRestaurantId(int restaurantId) {
		PreparedStatement preparestatement;
		ResultSet res;
		Menu menu = null;
		ArrayList<Menu> list = new ArrayList<Menu>();
		
		try {
			preparestatement = connection.prepareStatement(SELECT_MENU);
			preparestatement.setInt(1, restaurantId);
			res = preparestatement.executeQuery();
			while(res.next()) {
				int menuId = res.getInt("menuId");
				String name = res.getString("name");
				float price = res.getFloat("price");
				String description = res.getString("description");
				String imagePath = res.getString("imagePath");
				boolean isAvailable = res.getBoolean("isAvailable");
				float ratings = res.getFloat("ratings");
				menu=new Menu(menuId, name, price, description, imagePath, isAvailable, ratings, restaurantId);
				list.add(menu);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
