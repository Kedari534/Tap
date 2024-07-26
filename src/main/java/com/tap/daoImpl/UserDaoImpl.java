package com.tap.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.UserDao;
import com.tap.model.Users;

public class UserDaoImpl implements UserDao {

	final static String INSERT_QUERY="INSERT INTO `users`(`userId`,"
			+ "`name`,`email`,`phoneNumber`,`address`,`userName`,`password`)"
					+ "VALUES(?,?,?,?,?,?,?)";
	
	final static String SELECT_QUERY="SELECT * FROM `users` WHERE userId=?";
	
	final static String UPDATE_QUERY="UPDATE `users` SET `name`=?,`email`=?,`phoneNumber`=?,"
				+ "`address`=?,`userName`=?,`password`=? WHERE userId=?";
	
	final static String DELETE_QUERY="DELETE from `users` WHERE `userId`=?";
	
	final static String SELECT_ALL_QUERY="SELECT * from `users`";
	
	final static String SELECT_USER="SELECT * FROM `users` WHERE `userName`=?";
	
	private Connection connection;
	
	public UserDaoImpl() {
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
	public int addUser(Users user) {
		PreparedStatement preparestatement=null;
		int n=0;
		
		try {
			preparestatement=connection.prepareStatement(INSERT_QUERY);
			
			preparestatement.setInt(1, user.getUserId());
			preparestatement.setString(2, user.getName());
			preparestatement.setString(3, user.getEmail());
			preparestatement.setLong(4, user.getPhoneNumber());
			preparestatement.setString(5, user.getAddress());
			preparestatement.setString(6, encrypted(user.getUserName()));
			preparestatement.setString(7, encrypted(user.getPassword()));
			
			n = preparestatement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public Users getUser(int userId) {
		PreparedStatement preparestatement=null;
		ResultSet res=null;
		Users user=null;
		
		try {
			preparestatement = connection.prepareStatement(SELECT_QUERY);
			
			preparestatement.setInt(1, userId);
			res=preparestatement.executeQuery();
			
			if(res.next()) {
				String name=res.getString("name");
				String email = res.getString("email");
				long phoneNumber = res.getLong("phoneNumber");
				String address = res.getString("address");
				String userName = res.getString("userName");
				String password = res.getString("password");
				user=new Users(userId, name, email, phoneNumber, address, userName, password);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public void updateUser(Users user) {
		PreparedStatement preparestatement=null;
		try {
			preparestatement = connection.prepareStatement(UPDATE_QUERY);
			
			preparestatement.setString(1, user.getName());
			preparestatement.setString(2, user.getEmail());
			preparestatement.setLong(3, user.getPhoneNumber());
			preparestatement.setString(4, user.getAddress());
			preparestatement.setString(5, user.getUserName());
			preparestatement.setString(6, user.getPassword());
			preparestatement.setInt(7, user.getUserId());
			
			preparestatement.executeUpdate();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(int userId) {
		PreparedStatement preparestatement=null;
		try {
			preparestatement = connection.prepareStatement(DELETE_QUERY);
			preparestatement.setInt(1, userId);
			preparestatement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Users> getAllUsers() {
		
		Statement statement=null;
		ResultSet res=null;
		Users user=null;
		ArrayList<Users> usersList = new ArrayList<Users>();
		try {
			statement = connection.createStatement();
			res = statement.executeQuery(SELECT_ALL_QUERY);
			while(res.next()) {
				int userId = res.getInt("userId");
				String name = res.getString("name");
				String email = res.getString("email");
				Long phoneNumber = res.getLong("phoneNumber");
				String address = res.getString("address");
				String userName = res.getString("userName");
				String password = res.getString("password");
				user = new Users(userId, name, email, phoneNumber, address, userName, password);
				usersList.add(user);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return usersList;
	}
	
	public String  getUserByUserName(String userName) {
		PreparedStatement preparestatement;
		ResultSet res=null;
		String password="";
		try {
			preparestatement=connection.prepareStatement(SELECT_USER);
			preparestatement.setString(1, encrypted(userName));
			res = preparestatement.executeQuery();
			while(res.next()) {
				
				password = res.getString("password");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return decrypted(password);
	}
	public static String encrypted(String s) {
		String res="";
		for(int i=0;i<s.length();i++) {
			res=res+(char)(s.charAt(i)+1);
		}
		return res;
	}
	public static String decrypted(String s) {
		String t="";
		for(int i=0;i<s.length();i++) {
			t=t+(char)(s.charAt(i)-1);
		}
		return t;
	}
	

}
