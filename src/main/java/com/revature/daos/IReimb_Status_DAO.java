package com.revature.daos;

import com.revature.models.Reimb_Status;

public interface IReimb_Status_DAO {
	
	public Reimb_Status findByStatus(String status);

}
