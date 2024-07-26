package com.tap.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CartCreator {

	static Map<Integer,CartItem> cart=new HashMap<>();;
	
	public CartCreator() {
		
	}
	public void addCartItem(CartItem ci) {
		if(cart.containsKey(ci.getMenuId())){
			int n1 = cart.get(ci.getMenuId()).getQuantity();
			int n2 = ci.getQuantity();
			cart.get(ci.getMenuId()).setQuantity(n1+n2);
		}else {
			cart.put(ci.getMenuId(), ci);
		}
	}
	public void update(int menuId,int quantity) {
		cart.get(menuId).setQuantity(quantity);
	}
	
	public void delete(int menuId) {
		cart.remove(menuId);
	}
	public Map<Integer,CartItem> getAll(){
		
		return cart;
	}
}
