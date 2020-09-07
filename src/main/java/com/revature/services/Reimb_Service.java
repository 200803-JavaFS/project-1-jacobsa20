package com.revature.services;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;

import com.revature.daos.IReimb_DAO;
import com.revature.daos.IReimb_Status_DAO;
import com.revature.daos.IReimb_Type_DAO;
import com.revature.daos.IUser_DAO;
import com.revature.daos.Reimb_DAO;
import com.revature.daos.Reimb_Status_DAO;
import com.revature.daos.Reimb_Type_DAO;
import com.revature.daos.User_DAO;
import com.revature.models.Reimb;
import com.revature.models.ReimbDTO;
import com.revature.models.Reimb_Status;
import com.revature.models.Reimb_Type;
import com.revature.models.User;

public class Reimb_Service {
	private static final Logger log = LogManager.getLogger(Reimb_Service.class);

	private static IReimb_DAO iRDao = new Reimb_DAO();
	private static IUser_DAO uDao = new User_DAO();
	private static IReimb_Type_DAO rtDao = new Reimb_Type_DAO();
	private static IReimb_Status_DAO rsDao = new Reimb_Status_DAO();

	public List<Reimb> findAll() {
		log.info("Retrieving all reimbursements");
		return iRDao.findAll();
	}

	public Reimb findById(int id) {
		log.info("Finding Reimbursement " + id);
		return (Reimb) iRDao.findById(id);
	}

	public List<Reimb> findByStatus(String status) {
		log.info("Finding Reimb by Status");
		return iRDao.findByStatus(status);
	}
	
	public Reimb_Status findByReimbStatus(String status) {
		log.info(status);
		return rsDao.findByStatus(status);
	}
	
	public Reimb_Type findByReimbType(String type) {
		log.info(type);
		return rtDao.findByType(type);
	}

	public boolean addReimb(Reimb r) {
		log.info("Adding reimbursements: " + r);
		return iRDao.addReimb(r);
//		User u = uDao.findByUsername(r.author);
//		Reimb_Status rs = rsDao.findByStatus(r.status);
//		Reimb_Type rt = rtDao.findByType(r.type);
//		Reimb re = new Reimb(r.amount, r.submitted, r.resolved, r.description, u, null, rs, rt);
//		return iRDao.addReimb(re);
	}

	public boolean updateReimb(Reimb r) {
		log.info("Updating reimbursement: " + r);
//		User ur = uDao.findByUsername(r.author);
//		User ua = uDao.findByUsername(r.resolver);
//		Reimb_Status rs = rsDao.findByStatus(r.status);
//		Reimb_Type rt = rtDao.findByType(r.type);
//		Reimb re = new Reimb(r.id, r.amount, r.submitted, r.resolved, r.description, ua, ur, rs, rt);

		return iRDao.updateReimb(r);

	}
	
	public List<Reimb> findByUser(User u) {
		log.info("find User "+ u.getId());
		return iRDao.findByUser(u);
	}
}
