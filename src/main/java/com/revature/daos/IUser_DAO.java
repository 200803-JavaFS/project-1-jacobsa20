package com.revature.daos;

import java.util.List;

import com.revature.models.User;

public interface IUser_DAO {

	public User findById(int id);

	public User findByUsername(String username);

}
