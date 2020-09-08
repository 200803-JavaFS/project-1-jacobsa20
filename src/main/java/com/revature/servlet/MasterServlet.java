package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.LoginController;
import com.revature.controllers.Reimb_Controller;
import com.revature.controllers.UserController;
import com.revature.models.User;
import com.revature.models.User_Role;
import com.revature.services.User_Service;

public class MasterServlet extends HttpServlet {

	private static Reimb_Controller rc = new Reimb_Controller();
	private static LoginController lc = new LoginController();
	private static User_Service us = new User_Service();
	private static UserController uc = new UserController();

	public MasterServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		res.setStatus(404);
		RequestDispatcher rd = null;

		final String URI = req.getRequestURI().replace("/project1/", "");
		String[] portions = URI.split("/");

		System.out.println(Arrays.toString(portions));
		System.out.println("portions[0]:" + portions[0]);
		// get first section of URI: Employee/FM/1
		try {
			switch (portions[0]) {
			case "login":
				lc.login(req, res);
				break;
			case "reimbursement":
				if (req.getSession(false) != null && (boolean) req.getSession().getAttribute("logged in")) {
					if (req.getMethod().equals("GET")) {
						if (portions.length == 2) {
							int id = Integer.parseInt(portions[1]);
							rc.getReimbursement(res, id);
						} else if (portions.length == 1) {
							rc.addTicket(req, res);
						}
					}
				} else {
					res.setStatus(403);
					res.getWriter().println("You must be logged in first.");
				}
				break;
			case "logout":
				lc.logout(req, res);
				break;
			case "success":
				User u = (User) req.getSession().getAttribute("user");
				System.out.println(u);
				u = us.findByUsername(u.username); 
				User_Role ur = u.getUserRoleId();
				if (req.getMethod().equals("GET")) {
					uc.setUserRole(req, res, u);
				}
				break;
			case "updateStatus":
				rc.updateTicket(req, res);
				break;
			case "addReimbursement":
				rc.addTicket(req, res);
				break;
			case "filter":
				System.out.println("in filter");
				if (portions.length == 2) {
					int statusId = Integer.parseInt(portions[1]);
					rc.getByStatus(res, statusId);
				} else {
					rc.getAllTickets(res);
				}

				break;

			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
			res.getWriter().print("Not an Int");
			res.setStatus(400);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doGet(req, res);
	}

}
