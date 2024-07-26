package com.tap.dao;

import java.util.List;

import com.tap.model.Users;

public interface UserDao {

	int addUser(Users user);
	Users getUser(int userId);
	void updateUser(Users user);
	void deleteUser(int userId);
	List<Users> getAllUsers();
}
