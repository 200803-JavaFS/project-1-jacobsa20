package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimb;
import com.revature.models.ReimbDTO;
import com.revature.services.Reimb_Service;

public class Reimb_Controller {
	private static Reimb_Service rs = new Reimb_Service();

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

		if (rs.addReimbursement(rDto)) {
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

		Reimb r = om.readValue(body, Reimb.class);

		if (rs.updateReimb(r)) {
			res.setStatus(202);
			res.getWriter().println("Reimbursement Ticket updated");
		} else {
			res.setStatus(304);
		}
	}
}
