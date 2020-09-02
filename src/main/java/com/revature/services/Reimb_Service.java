package com.revature.services;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.IReimb_DAO;
import com.revature.daos.IUser_DAO;
import com.revature.daos.Reimb_DAO;
import com.revature.daos.User_DAO;
import com.revature.models.Reimb;
import com.revature.models.ReimbDTO;
import com.revature.models.User;

public class Reimb_Service {
	private static final Logger log = LogManager.getLogger(Reimb_Service.class);
	private static IReimb_DAO iRDao = new Reimb_DAO();
	private static IUser_DAO uDao = new User_DAO();

	public List<Reimb> findAll() {
		log.info("Retrieving all reimbursements");
		return iRDao.findAll();
	}

	public Reimb findById(int id) {
		log.info("Finding Reimbursement " + id);
		return (Reimb) iRDao.findById(id);
	}

	public List<Reimb> findByStatus(String status) {
		return iRDao.findByStatus(status);
	}

	public boolean addReimbursement(ReimbDTO r) {
		log.info("Adding reimbursements: " + r);
		User u = uDao.findByUsername(r.author);
		Reimb re = new Reimb(r.amount, r.submitted, u, r.status, r.type);
		return iRDao.addReimb(re);
	}

	public boolean updateReimb(Reimb r) {
		log.info("Updating reimbursement: " + r);
		return iRDao.updateReimb(r);

	}
}
