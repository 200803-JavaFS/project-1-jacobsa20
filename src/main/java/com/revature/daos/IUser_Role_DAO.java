package com.revature.daos;

import com.revature.models.User_Role;

public interface IUser_Role_DAO {

	public User_Role findById(int id);
	
	public void addUser_Role(User_Role ur);
}
