package com.tap.daoImpl;

import java.util.List;

import com.tap.model.Orders;
import com.tap.model.Restaurant;

public class Demo {

	public static void main(String[] args) {
//		UserDaoImpl udi = new UserDaoImpl();
//		Users u=new Users(2,"ravi","ravi@gmail.com",966620232,"komarolu","ravi kumar","ravi@123");
//		Users user = udi.getUser(2);
//		System.out.println(user.getName());
		
		RestaurantDaoImpl rdi = new RestaurantDaoImpl();
		//Restaurant r = new Restaurant(2,"golden","Hi",4.5f,"20-25mins","indian","BTM",true,1);
		
		List<Restaurant> allRestaurants = rdi.getAllRestaurants();
		for (Restaurant restaurant : allRestaurants) {
			System.out.println(restaurant.getName());
			System.out.println(restaurant.getEta());
			System.out.println(restaurant.getImagePath());
		}
//		
//		
//		MenuDaoImpl mdi = new MenuDaoImpl();
//		Menu m = new Menu(1,"veg&non-veg",245.0f,"very delicious","waiting",true,3.5f,1);
//		mdi.deleteMenu(1);
//		
//		OrderDaoImpl odi = new OrderDaoImpl();
//		Orders o = new Orders(1,1,1,249,"cashOnDelivery","delivered");
//		odi.deleteOrder(1);
//		
		
		
		
//		OrderItemsDaoImpl oidi = new OrderItemsDaoImpl();
//		OrderItems oi=new OrderItems(101,1,1,"biriyani",4.5f,2,249);
//		oidi.addOrderItem(oi);
		
//		OrderHistoryDaoImpl ohdi = new OrderHistoryDaoImpl();
//		OrderHistory oh = new OrderHistory(1001,1,2);
//		List<OrderHistory> orderHistory = ohdi.getAllOrderHistory();
//		
//		for(OrderHistory ohi:orderHistory) {
//			System.out.println(ohi.getUserId());
//		}
//		
	}

}
