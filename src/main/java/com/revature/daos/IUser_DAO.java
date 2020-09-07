package com.revature.daos;

import java.util.List;

import com.revature.models.User;
import com.revature.models.User_Role;

public interface IUser_DAO {

	public User findById(int id);

	public User findByUsername(String username);

	public List<User> findAll();

	public boolean addUser(User u);

	boolean updateUser(User u);

	User_Role findByRole(User_Role userRole);
	
	public User findByEmployee(String username, String password);
}
