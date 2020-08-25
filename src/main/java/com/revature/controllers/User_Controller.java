package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.LoginDTO;
import com.revature.models.User;
import com.revature.models.User_Role;
import com.revature.services.LoginService;
import com.revature.services.User_Role_Service;
import com.revature.services.User_Service;

public class User_Controller {

	private static User_Service us = new User_Service();
	private static User_Role_Service urs = new User_Role_Service();
	private static ObjectMapper om = new ObjectMapper();

	public void login(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		if (req.getMethod().equals("POST")) {
			// this is how login should be handled, sending credentials in the body of a
			// post request
			BufferedReader reader = req.getReader();

			StringBuilder sb = new StringBuilder();

			String line = reader.readLine();
			while (line != null) {
				sb.append(line);
				line = reader.readLine();
			}
			String body = new String(sb);
			LoginDTO l = om.readValue(body, LoginDTO.class);
			System.out.println(l.username +" "+ l.password);
			if (us.login(l)) {
				HttpSession ses = req.getSession();
				ses.setAttribute("user", l);
				ses.setAttribute("loggedin", true);
				res.setStatus(200);
				res.getWriter().println("Login Successful");
			} else {
				HttpSession ses = req.getSession(false);
				if (ses != null) {
					ses.invalidate();
				}
				res.setStatus(401);
				res.getWriter().println("Login Failed");
			}
		}
	}
}
