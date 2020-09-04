package com.revature.services;

import com.revature.daos.IUser_DAO;
import com.revature.daos.User_DAO;
import com.revature.models.LoginDTO;
import com.revature.models.User;

public class LoginService {

	private static User_Service us = new User_Service();

	public boolean login(LoginDTO l) {
		try {
			String username = l.username;
			String password = l.password;
			User u = us.findByUsername(username);

			if (u != null) {
				StringBuilder sb = new StringBuilder();
				sb.append(password.hashCode());
				String hashed = new String(sb);

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
