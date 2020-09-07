package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.Reimb_Service;
import com.revature.services.User_Service;

public class UserController {

	private static User_Service us = new User_Service();
	private static ObjectMapper om = new ObjectMapper();
	private static Reimb_Service rs = new Reimb_Service();

	public void setUserRole(HttpServletRequest req, HttpServletResponse res, User u) throws IOException {
		//log here
		if(u== null) {
			res.setStatus(204);
		}else {
			res.setStatus(200);
			String json = om.writeValueAsString(u);
			res.getWriter().println(json);
		}
	}
}
