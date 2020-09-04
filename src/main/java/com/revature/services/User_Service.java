package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.IUser_DAO;
import com.revature.daos.User_DAO;
import com.revature.models.LoginDTO;
import com.revature.models.User;

public class User_Service {

	private static final Logger log = LogManager.getLogger(User_Service.class);
	private static IUser_DAO uDao = new User_DAO();

	public List<User> findAll(){
		log.info("Find Users.");
		return uDao.findAll();
	}
	
	public User findById(int id) {
		log.info("Finding User " + id);
		return uDao.findById(id);
	}

	public User findByUsername(String username) {
		log.info("Finding User " + username);
		return uDao.findByUsername(username);
	}
	
	public boolean addUser(User u) {
		log.info("Adding User "+u);
		return uDao.addUser(u);
	}

	public boolean login(LoginDTO l) {
		User u = uDao.findByUsername(l.username);
		if (u.getPassword().equals(l.password)) {
			return true;
		}
		return false;
	}
}
