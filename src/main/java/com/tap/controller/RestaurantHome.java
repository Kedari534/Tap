package com.tap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoImpl.RestaurantDaoImpl;
import com.tap.model.Restaurant;

@WebServlet("/restaurantHomepage1")

public class RestaurantHome extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		
		String un = (String)req.getAttribute("username");
		if(un==null) {
			HttpSession session = req.getSession();
			String username = (String)session.getAttribute("username");
			un=username;
		}
		RestaurantDaoImpl rdi = new RestaurantDaoImpl();
		
		List<Restaurant> restaurant = rdi.getAllRestaurants();
		
		req.setAttribute("restaurants", restaurant);
		req.setAttribute("username", un);
		
		RequestDispatcher rd = req.getRequestDispatcher("restaurantHome.jsp");
		
		rd.forward(req, resp);
		
		
	}
}
