package com.revature.services;

import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import com.revature.daos.IReimb_DAO;
import com.revature.daos.Reimb_DAO;
import com.revature.models.Reimb;

public class Reimb_Service {
	private static final Logger log = LogManager.getLogger(Reimb_Service.class);
	private static IReimb_DAO rDao = new Reimb_DAO();

	public List<Reimb> findAll() {
		log.info("Retrieving all reimbursements");
		return rDao.findAll();
	}

	public Reimb findById(int id) {
		log.info("Finding Reimbursement " + id);
		return rDao.findById(id);
	}

	public List<Reimb> findByUser(int userId) {
		log.info("Retrieving all reimbursements tied to user with user_id=" + userId);
		return rDao.findByUser(userId);
	}

	public List<Reimb> findByStatus(String status) {
		return rDao.findByStatus(status);
	}

	public boolean addReimbursement(Reimb r) {
		log.info("Adding reimbursements: " + r);
		return rDao.addReimb(r);
	}

	public boolean updateReimb(Reimb r) {
		log.info("Updating reimbursement: " + r);
		return rDao.updateReimb(r);

	}
}
