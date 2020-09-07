package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.IUser_DAO;
import com.revature.daos.User_DAO;
import com.revature.models.User;

public class User_Service {

	private static final Logger log = LogManager.getLogger(User_Service.class);
	private static IUser_DAO uDao = new User_DAO();

	public boolean updateUser(User u) {
		log.info("Updating User " + u);
		return uDao.updateUser(u);
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
		log.info("Adding User " + u);
		return uDao.addUser(u);
	}

	public User findByUserPassword(String username, String hashed) {
		log.info("Finding user with password");
		User u = uDao.findByEmployee(username, hashed);
		log.debug("The password of the inputted user is " + hashed);
		if (u.getPassword().equals(hashed)) {
			log.info("Login sucessful!");
			return u;
		} else {
			log.error("Incorrect password.");
			return null;
		}
	}
}
