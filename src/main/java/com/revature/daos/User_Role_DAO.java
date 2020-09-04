package com.revature.daos;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.User_Role;
import com.revature.utils.HibernateUtil;

public class User_Role_DAO implements IUser_Role_DAO{

	@Override
	public User_Role findById(int id) {
		Session ses = HibernateUtil.getSession();
		User_Role ur = ses.get(User_Role.class, id);
		return ur;
	}

	@Override
	public void addUser_Role(User_Role ur) {
		Session ses = HibernateUtil.getSession();
		Transaction t = ses.beginTransaction();
		ses.save(ur);
		t.commit();
		
	}

}
