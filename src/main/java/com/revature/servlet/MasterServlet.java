package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.LoginController;
import com.revature.controllers.Reimb_Controller;
import com.revature.controllers.User_Controller;

public class MasterServlet extends HttpServlet {

	private static User_Controller uc = new User_Controller();
	private static Reimb_Controller rc = new Reimb_Controller();
	private static final long serialVersionUID = 1L;
	
	public MasterServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		res.setStatus(404);

		final String URI = req.getRequestURI().replace("/project1/", "");
		String[] portions = URI.split("/");

		System.out.println(Arrays.toString(portions));
		System.out.println("portions[0]:" + portions[0]);
		// get first section of URI: Employee/FM/1
		try {
			switch (portions[0]) {
			case "login":
				if (req.getMethod().equals("POST")) {
					System.out.println("login");
					uc.login(req, res);
					break;
				}

			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
			res.getWriter().print("Not an Int");
			res.setStatus(400);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		res.setStatus(404);
		
		LoginController lc= new LoginController();
		lc.login(req,res);
		
		doGet(req, res);
	}

}
