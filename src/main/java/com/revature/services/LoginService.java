package com.revature.services;

import com.revature.daos.IUser_DAO;
import com.revature.daos.User_DAO;
import com.revature.models.User;

public class LoginService {

	private static User_Service us = new User_Service();

	public boolean login(User u) {

			StringBuilder sb = new StringBuilder();
			int hashed=u.password.hashCode();
			sb.append(hashed);
			String hashedPassword= sb.toString();
			
			User uSer = us.findByUserPassword(u.username,hashedPassword);
			System.out.println("hashed: "+ hashedPassword);
			System.out.println(uSer.getPassword());
			
			
			if (u.username.equals(uSer.getUsername()) && hashedPassword.equals(uSer.getPassword())) {
				
				return true;
			}
			return false;
	}

}
