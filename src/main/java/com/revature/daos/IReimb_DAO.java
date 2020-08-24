package com.revature.daos;

import java.awt.List;

public class IReimb_DAO {
	
	public List<Reimb> findAll();
	
	public Reimb findById(int id);
	
	public List<Reimb> findByUser(int userId);
	
	public List<Reimb> findByStatus(String status);
	
	public boolean addReimb(Reimb r);
	
	public boolean updateReimb(Reimb r);
}
