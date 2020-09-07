package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimb;
import com.revature.models.ReimbDTO;
import com.revature.models.Reimb_Status;
import com.revature.models.Reimb_Type;
import com.revature.models.User;
import com.revature.services.Reimb_Service;
import com.revature.services.User_Service;

public class Reimb_Controller {
	private static Reimb_Service rs = new Reimb_Service();
	private static User_Service us = new User_Service();
	private static ObjectMapper om = new ObjectMapper();

	public void getReimbursement(HttpServletResponse res, int id) throws IOException {

		Reimb r = rs.findById(id);

		if (r == null) {
			res.setStatus(204);
		} else {

			res.setStatus(200);
			String json = om.writeValueAsString(r);
			res.getWriter().println(json);
		}
	}

	public void getAllTickets(HttpServletResponse res) throws IOException {

		List<Reimb> allTickets = rs.findAll();

		res.getWriter().println(om.writeValueAsString(allTickets));
		res.setStatus(200);
	}

	public void getByStatus(HttpServletResponse res, String status) throws IOException {

		// should come in verified that the response is of a correct type for the db

		List<Reimb> specTickets = rs.findByStatus(status);

		res.getWriter().println(om.writeValueAsString(specTickets));
		res.setStatus(200);
	}

	public void addTicket(HttpServletRequest req, HttpServletResponse res) throws IOException {
		BufferedReader reader = req.getReader();

		StringBuilder s = new StringBuilder();

		String line = reader.readLine();

		while (line != null) {
			s.append(line);
			line = reader.readLine();
		}

		String body = new String(s);

		ReimbDTO rDto = om.readValue(body, ReimbDTO.class);

		double amount = rDto.getAmount();
		String description = rDto.getDescription();
		LocalDateTime ldt = LocalDateTime.now();
		Reimb_Status newRS = rs.findByReimbStatus("Pending");
		User author = us.findById(rDto.getAuthorID());

		String type = rDto.getType();
		System.out.println(type);

		Reimb_Type rt = null;
		type.toLowerCase();
		if (type.contains("lodging")) {
			rt = rs.findByReimbType("Lodging");
		} else if (type.contains("travel")) {
			rt = rs.findByReimbType("Travel");
		} else if (type.contains("food")) {
			rt = rs.findByReimbType("Food");
		} else if (type.contains("other") || type.contains(" ")) {
			rt = rs.findByReimbType("Other");
		}

		Reimb addingReimb = new Reimb(amount, ldt, author, newRS, rt);
		if (rs.addReimb(addingReimb)) {
			res.setStatus(201);
			res.getWriter().println("Reimbursement Ticket created");
		} else {
			res.setStatus(403);
		}
	}

	public void updateTicket(HttpServletRequest req, HttpServletResponse res) throws IOException {
		BufferedReader reader = req.getReader();
		StringBuilder s = new StringBuilder();
		String line = reader.readLine();

		while (line != null) {
			s.append(line);
			line = reader.readLine();
		}

		String body = new String(s);
		ReimbDTO rDto = om.readValue(body, ReimbDTO.class);

		int reimbID = rDto.getId();
		Reimb r =rs.findById(reimbID);
		String stats = rDto.getStatus();
		stats.toLowerCase();
		Reimb_Status rStats = null;
		if(stats.contains("approved")) {
			rStats = new Reimb_Status(2, "Approved");
		} else if(stats.contains("denied")) {
			rStats = new Reimb_Status(3, "Denied");	
		}
		
		int resolveID = rDto.getAuthorID();
		r.setStatusId(rStats);
		r.setResolved(LocalDateTime.now());
		User resolver = us.findById(resolveID);
		
		if (rs.updateReimb(r)) {
			res.setStatus(202);
			res.getWriter().println("Reimbursement Ticket updated");
		} else {
			res.setStatus(304);
		}
	}
}
