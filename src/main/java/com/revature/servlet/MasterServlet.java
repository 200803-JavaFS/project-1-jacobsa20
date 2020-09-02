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

public class MasterServlet extends HttpServlet {

	private static Reimb_Controller rc = new Reimb_Controller();
	private static LoginController lc = new LoginController();
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
					lc.login(req, res);
					break;
				}
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

			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
			res.getWriter().print("Not an Int");
			res.setStatus(400);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//res.setContentType("application/json");
//		res.setStatus(404);
//
//		LoginController lc = new LoginController();
//		lc.login(req, res);

		doGet(req, res);
	}

}
