package com.revature.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.IUserRole_DAO;
import com.revature.daos.UserRole_DAO;
import com.revature.models.User_Role;

public class User_Role_Service {
	private static final Logger log = LogManager.getLogger(User_Service.class);
	private static IUserRole_DAO urDao = new UserRole_DAO();

	public User_Role findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
