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
@WebServlet("/CallServletCart3")
public class CartServletRemove extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int menuId = Integer.parseInt(req.getParameter("menuId"));
		CartItem cart = new CartItem();
		CartCreator creator = new CartCreator();
		creator.delete(menuId);
		   HttpSession session = req.getSession();
		 session.setAttribute("cartCreator", creator);
		 resp.sendRedirect("cart.jsp"); 
		
	}
}
