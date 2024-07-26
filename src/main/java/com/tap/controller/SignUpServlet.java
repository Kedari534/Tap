package com.tap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daoImpl.UserDaoImpl;
import com.tap.model.Users;


@WebServlet("/CallingSignUpServlet")
public class SignUpServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDaoImpl udi = new UserDaoImpl();
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		Long phoneNumber = Long.parseLong(req.getParameter("phone"));
		String userName = req.getParameter("username");
		String password = req.getParameter("password");

		Users users = new Users(name, email, phoneNumber, userName, password);
		int i = udi.addUser(users);
		
		PrintWriter out = resp.getWriter();
		
		if(i>0) {
			resp.sendRedirect("login.jsp");
		}else {
			out.print("registration fails");
			resp.setContentType("text/html");
		}
	}
	
}
