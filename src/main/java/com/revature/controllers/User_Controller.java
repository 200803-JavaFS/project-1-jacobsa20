package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.models.User;
import com.revature.models.User_Role;
import com.revature.services.User_Role_Service;
import com.revature.services.User_Service;

public class User_Controller {

	private static User_Service us = new User_Service();
	private static User_Role_Service urs = new User_Role_Service();
	
	public void login(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		System.out.println("inside login user controller");
		//"this guy" is from html, not implemented yet
		String username= req.getParameter("username");
		String password= req.getParameter("password");
		
		User u = us.findByUserPassword(username, password);
		RequestDispatcher rd = null;
		
		PrintWriter out = res.getWriter();
		
		
		if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
			User_Role ur= urs.findById(u.getId());
			if (ur.getRole().equals("Employee")) {
				System.out.println("inside login as employee");
				rd =  req.getRequestDispatcher("employeeSuccess.html");
			}
			else if (ur.getRole().equals("Manager")) {
				System.out.println("inside login as manager");
				rd =  req.getRequestDispatcher("managerSuccess.html");
			}
			
			rd.forward(req, res);
		} else {
			rd =  req.getRequestDispatcher("index.html");
			rd.include(req, res);
			out.print("<span style= 'color:red; text-align:center'> Invalid Username/Password</span>");
		}
	}
}
