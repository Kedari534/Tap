package com.tap.model;

import java.time.LocalDateTime;

public class Users {

	private int userId;
	private String name;
	private String email;
	private long phoneNumber;
	private String address;
	private String userName;
	private String password;
	private String role;
	private LocalDateTime createDate;
	private LocalDateTime lastLogin;

	public Users() {

	}

	public Users(int userId,String name, String email, long phoneNumber, String address, String userName,
			String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.userName = userName;
		this.password = password;
	}

	public Users(String name,String email,long phoneNumber,String userName,String password) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
