package com.revature.daos;

import com.revature.models.Reimb_Type;

public interface IReimb_Type_DAO {
	
	public Reimb_Type findByType(String type);
}
