package com.revature.services;

import com.revature.daos.IUser_DAO;
import com.revature.daos.User_DAO;
import com.revature.models.User;

public class LoginService {

	private static User_Service us = new User_Service();

	public boolean login(User u) {
		try {
//			String username = l.username;
//			String password = l.password;
//			User u = us.findByUsername(username);

			if (u != null) {
				StringBuilder sb = new StringBuilder();
				int hc = u.getPassword().hashCode();
				sb.append(hc);
				String hashed = sb.toString();

				if (u.getPassword().equals(hashed)) {
					return true;
				} else {
					System.out.println("Login Credentials are wrong.");
				}
			} else {
				System.out.println("User is not identified.");
			}
		} catch (NullPointerException e) {
			System.out.println("Login Failed.");
			e.printStackTrace();
		}
		return false;
	}

}
