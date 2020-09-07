package com.revature.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.User;
import com.revature.models.User_Role;
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
		Session ses = HibernateUtil.getSession();
		User u = ses.createQuery("FROM ers_users WHERE ers_username = " + username + ".", User.class).uniqueResult();
		return u;
	}

	@Override
	public boolean addUser(User u) {
		Session ses = HibernateUtil.getSession();
		try {
			Transaction t = ses.beginTransaction();
			ses.save(u);
			// System.out.println("Adding user.");
			t.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User_Role findByRole(User_Role userRole) {
		Session ses = HibernateUtil.getSession();
		User_Role ur = ses.createQuery("FROM ers_users WHERE user_role_id = " + userRole + ".", User_Role.class)
				.getSingleResult();
		return ur;
	}

	@Override
	public boolean updateUser(User u) {
		Session ses = HibernateUtil.getSession();
		Transaction t = ses.beginTransaction();
		try {
			ses.merge(u);
			t.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			t.rollback();
			return false;
		}
	}

	@Override
	public List<User> findAll() {
		Session ses = HibernateUtil.getSession();
		List<User> list = ses.createQuery("FROM ers_users").list();
		return list;
	}

	@Override
	public User findByEmployee(String username, String password) {
		Session ses = HibernateUtil.getSession();
		return (User) ses.createQuery("FROM User U WHERE U.username = :userName").setParameter("userName", username)
				.uniqueResult();
		
		
		//		Session ses = HibernateUtil.getSession();
//		User list = ses.createQuery("FROM User WHERE username = " + username, User.class).uniqueResult();
//		if (list.getPassword().equals(password)) {
//			return list;
//		} else {
//			return null;
//		}
	}

}
