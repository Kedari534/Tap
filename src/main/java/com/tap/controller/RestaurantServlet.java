package com.tap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daoImpl.RestaurantDaoImpl;
import com.tap.model.Restaurant;

@WebServlet("/ANUfoods")
public class RestaurantServlet extends HttpServlet{

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		RestaurantDaoImpl rdi = new RestaurantDaoImpl();
		
		List<Restaurant> restaurant = rdi.getAllRestaurants();
		
		req.setAttribute("restaurants", restaurant);
		
		RequestDispatcher rd = req.getRequestDispatcher("restaurant.jsp");
		
		rd.forward(req, resp);
		
		
	}
}
