package com.revature.daos;

import java.util.List;
import com.revature.models.Reimb;

public interface IReimb_DAO<Reimb> {

	public List<Reimb> findAll();

	public Reimb findById(int id);

	public List<Reimb> findByStatus(String status);

	public boolean addReimb(Reimb r);

	public boolean updateReimb(Reimb r);

}
