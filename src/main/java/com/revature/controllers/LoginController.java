package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.models.LoginDTO;
import com.revature.models.User;
import com.revature.services.LoginService;

public class LoginController {

	private static LoginService ls = new LoginService();
	private static ObjectMapper om = new ObjectMapper();

	public void login(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		if (req.getMethod().equals("GET")) {

			if(req.getParameterMap().containsKey("username")&& req.getParameterMap().containsKey("password")) {
				User u = new User();
				u.username = req.getParameter("username");
				u.password = req.getParameter("password");
			
				if(ls.login(u)) {
					HttpSession ses = req.getSession();
					
					ses.setAttribute("user", u);
					ses.setAttribute("login", true);
					res.setStatus(200);
					res.getWriter().println("Login Successful");
					
				} else {
					HttpSession ses = req.getSession();
					ses.setAttribute("login", false);
					
					if(ses!=null) {
						ses.invalidate();
					}
					res.setStatus(401);
					res.getWriter().println("Login Fail.");
				}
			}

		} else if (req.getMethod().equals("POST")) {
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
			User u = om.readValue(body, User.class);

			if (ls.login(u)) {
				HttpSession ses = req.getSession();
				ses.setAttribute("user", u);
				ses.setAttribute("loggedin", true);
				res.setStatus(200);
				res.getWriter().println("Login Successful");
			} else {
				HttpSession ses = req.getSession(false);
				if (ses != null) {
					ses.invalidate();
				}
				res.setStatus(401);
				res.getWriter().println("Login Fail.");
			}

		}
	}

	public void logout(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession ses = req.getSession(false);

		if (ses != null) {
			User u = (User) ses.getAttribute("user");
			ses.invalidate();
			res.setStatus(200);
			res.getWriter().println(u.username + "has logged out successfully.");
		} else {
			res.setStatus(400);
			res.getWriter().println("You must be logged in to logout.");
		}
	}
}
