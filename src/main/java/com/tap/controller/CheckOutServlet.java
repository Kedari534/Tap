package com.tap.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.model.CartCreator;

@WebServlet("/CheckoutServlet")
public class CheckOutServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
        CartCreator cartCreator = (CartCreator) session.getAttribute("cartCreator");
        String username = (String) session.getAttribute("username");

        if (cartCreator == null || username == null) {
            // Handle missing attributes
            resp.sendRedirect("login.jsp"); // Redirect user to login or error page as appropriate
            return;
        }

        // Set attributes for the view
        req.setAttribute("username", username);
        req.setAttribute("cartItems", cartCreator.getAll().values());

        // Forward to the checkout page
        RequestDispatcher dispatcher = req.getRequestDispatcher("checkOut.jsp");
        dispatcher.forward(req, resp);
	}
	
}
