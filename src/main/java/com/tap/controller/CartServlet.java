package com.tap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.model.CartCreator;
import com.tap.model.CartItem;
import com.tap.model.Menu;

@WebServlet("/CallServletCart")
public class CartServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		List<Menu> list = (List<Menu>)session.getAttribute("menulist");
		int menuId=Integer.parseInt(req.getParameter("menuId"));
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		
		Menu menu=null;
		for(Menu m:list) {
			if(m.getMenuId()==menuId) {
				menu=m;
				break;
			}
		}
		String name = menu.getName();
		String imagePath = menu.getImagePath();
		float price = menu.getPrice();
		int restaurantId = menu.getRestaurantId();
		CartItem c = new CartItem(menuId, imagePath, restaurantId, name, price, quantity);	
		CartCreator cr = new CartCreator();
		cr.addCartItem(c);
		
        session.setAttribute("cartCreator",cr);
        resp.sendRedirect("cart.jsp");
	}
}
