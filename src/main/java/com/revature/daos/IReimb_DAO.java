package com.revature.daos;

import java.util.List;
import com.revature.models.Reimb;
import com.revature.models.User;

public interface IReimb_DAO<Reimb> {

	public List<Reimb> findAll();

	public Reimb findById(int id);

	public List<Reimb> findByStatus(String status);

//	public boolean addReimb(Reimb r);

//	public boolean updateReimb(Reimb r);
	
	public List<Reimb> findByUser(User u);

	boolean addReimb(com.revature.models.Reimb r);

	boolean updateReimb(com.revature.models.Reimb r);

}
