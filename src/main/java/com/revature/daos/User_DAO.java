package com.revature.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.models.User;
import com.revature.utils.HibernateUtil;

public class User_DAO implements IUser_DAO {

	public User_DAO() {
		super();
	}

	@Override
	public User findById(int id) {
		Session ses = HibernateUtil.getSession();

		User u = ses.get(User.class, id);
		return u;
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
