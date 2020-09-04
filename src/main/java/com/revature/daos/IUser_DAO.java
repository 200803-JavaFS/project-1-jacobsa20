package com.revature.daos;

import java.util.List;

import com.revature.models.Reimb;
import com.revature.models.User;

public interface IUser_DAO {

	public User findById(int id);

	public User findByUsername(String username);

	public List<User> findAll();

	public boolean addUser(User u);

	List<Reimb> findUserReimb(User u);
}
