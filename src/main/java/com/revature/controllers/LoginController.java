package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.models.LoginDTO;
import com.revature.services.LoginService;

public class LoginController {

	private static LoginService ls = new LoginService();
	private static ObjectMapper om = new ObjectMapper();

	public void login(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		if (req.getMethod().equals("GET")) {
			// shows logging in with query params. DONT DO THIS!!!!
			if (req.getParameterMap().containsKey("username") && req.getParameterMap().containsKey("password")) {
				LoginDTO l = new LoginDTO();
				l.username = req.getParameter("username");// req.getparam is bad practice
				l.password = req.getParameter("password");
				// send JSON in here to get username and password

				if (ls.login(l)) {
					HttpSession ses = req.getSession();
					ses.setAttribute("user", l);
					ses.setAttribute("loggedin", true);
					res.setStatus(200);
					res.setContentType("text/html");
					// req.getRequestDispatcher("reimbursements.html").forward(req,res);
					// res.getWriter().println("Login Successful");
				} else {
					HttpSession ses = req.getSession(false);
					if (ses != null) {
						ses.invalidate();
					}
					res.setStatus(401);
					res.getWriter().println("Login Failed");
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
				LoginDTO l = om.readValue(body, LoginDTO.class);
				if (ls.login(l)) {
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

	public void logout(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession ses = req.getSession(false);

		if (ses != null) {
			LoginDTO l = (LoginDTO) ses.getAttribute("user");
			ses.invalidate();
			res.setStatus(200);
			res.getWriter().println(l.username + "has logged out successfully.");
		} else {
			res.setStatus(400);
			res.getWriter().println("You must be logged in to logout.");
		}
	}
}
