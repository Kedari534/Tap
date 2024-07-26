package com.tap.model;

public class OrderItems {

	private int orderItemId;
	private int userId;
	private int menuId;
	private String itemName;
	private float ratings;
	private int quantity;
	private float price;

	public OrderItems() {

	}

	
	public OrderItems(int orderItemId, int userId, int menuId, String itemName, float ratings, int quantity,
			float price) {
		super();
		this.orderItemId = orderItemId;
		this.userId = userId;
		this.menuId = menuId;
		this.itemName = itemName;
		this.ratings = ratings;
		this.quantity = quantity;
		this.price = price;
	}
	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getRatings() {
		return ratings;
	}

	public void setRatings(float ratings) {
		this.ratings = ratings;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	

}
