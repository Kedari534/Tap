package com.tap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.model.CartCreator;
import com.tap.model.CartItem;
@WebServlet("/CallServletCart10")
public class CallServletPlus extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.getAttribute("userId") !=null) {
			int userId =(int) session.getAttribute("userId");
			session.setAttribute("userId", userId);
		}
		String name=req.getParameter("name");
		String imagepath=req.getParameter("imagepath");
		float price=Float.parseFloat(req.getParameter("price"));
		int menuId = Integer.parseInt(req.getParameter("menuId")); 
		int restaurantId= Integer.parseInt(req.getParameter("restaurantId"));  
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		CartItem c = new CartItem(menuId, imagepath, restaurantId, name, price, quantity);
		CartCreator creator = new CartCreator();
		creator.addCartItem(c);
		  
		 session.setAttribute("cartCreator", creator);
		 
		 resp.sendRedirect("cart.jsp");
	}
	
}
