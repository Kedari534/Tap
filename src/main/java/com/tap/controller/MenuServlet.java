package com.tap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daoImpl.MenuDaoImpl;
import com.tap.model.Menu;

@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int restaurantId=Integer.parseInt(req.getParameter("restaurantId"));
		MenuDaoImpl mdi = new MenuDaoImpl();
		List<Menu> menus = mdi.getMenuByRestaurantId(restaurantId);
		
		req.setAttribute("menus", menus);
		RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
		rd.forward(req, resp);
	}
	
}
