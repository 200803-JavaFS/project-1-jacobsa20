package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.models.User;
import com.revature.services.LoginService;

public class LoginController {

	private static LoginService ls = new LoginService();
	private static ObjectMapper om = new ObjectMapper();
	private User user;

	public boolean login(HttpServletRequest req, HttpServletResponse res) throws IOException {

		if (req.getMethod().equals("POST")) {
			// this is how login should be handled, sending credentials in the body of a
			// post request
			BufferedReader br = req.getReader();

			StringBuilder sb = new StringBuilder();

			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				line = br.readLine();

			}
			String body = new String(sb);
			User u = om.readValue(body, User.class);
			//user= ls.login(u);

			if (ls.login(u)) {
				HttpSession ses = req.getSession();
				ses.setAttribute("loggedin", true);
				res.setStatus(200);
				res.getWriter().println("Login Successful");
				return true;
			} else {
				HttpSession ses = req.getSession(false);
				if (ses != null) {
					ses.invalidate();
					res.setStatus(401);
					res.getWriter().println("Login Fail.");
					return false;
				}
				
			}
		}else {
			res.getWriter().println("Nope");
			return false;
		}
		return false;

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
