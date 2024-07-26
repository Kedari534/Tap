package com.tap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoImpl.UserDaoImpl;
import com.tap.model.Users;
@WebServlet("/CallingLoginServlet1")
public class LoginServlet extends HttpServlet{
	
	private static int max_attempts=3; 

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		HttpSession session = req.getSession();
		session.setAttribute("username", username);
		String pwd = req.getParameter("password");
		UserDaoImpl udi = new UserDaoImpl();
		String password = udi.getUserByUserName(username);
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		if(password.equals(pwd)) {			
			req.setAttribute("username", username);
			RequestDispatcher rd = req.getRequestDispatcher("restaurantHomepage1");
			rd.forward(req, resp);
		}else if(max_attempts>0){
			out.print("invalid details you entered try again..., "+max_attempts+ "attempts left");
			max_attempts--;
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.include(req, resp);
		}else {
			out.print("contact admin");
		}
	}
	public static String encrypted(String s) {
		String res="";
		for(int i=0;i<s.length();i++) {
			res+=(char)(s.charAt(i)+1);
		}
		
		return res;
	}
}
