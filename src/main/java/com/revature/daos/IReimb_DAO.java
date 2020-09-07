package com.revature.daos;

import java.util.List;
import com.revature.models.Reimb;
import com.revature.models.User;

public interface IReimb_DAO<Reimb> {

	public List<Reimb> findAll();

	public Reimb findById(int id);

	public List<Reimb> findByStatus(int statusId);

	public List<Reimb> findByUser(User u);

	boolean updateReimb(com.revature.models.Reimb r);

	boolean addReimb(com.revature.models.Reimb r);


}
