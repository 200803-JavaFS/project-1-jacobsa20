package com.revature.services;

import com.revature.models.LoginDTO;

public class LoginService {
	
	public boolean login(LoginDTO l) {
		if(l.username.equals("agent")&& l.password.equals("12345")) {
			return true;
		}
		return false;
	}

}
