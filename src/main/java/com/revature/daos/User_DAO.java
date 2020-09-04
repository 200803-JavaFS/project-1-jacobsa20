package com.revature.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Reimb;
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
		Session ses = HibernateUtil.getSession();
		User u = ses.createQuery("FROM ers_users WHERE username = " + username + ".", User.class).uniqueResult();
		return u;
	}

	@Override
	public boolean addUser(User u) {
		Session ses = HibernateUtil.getSession();
		try {
			Transaction t = ses.beginTransaction();
			ses.save(u);
			System.out.println("Adding user.");
			t.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
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
	public List<Reimb> findUserReimb(User u) {
		Session ses = HibernateUtil.getSession();
		List<Reimb> list = (List<Reimb>) ses
				.createNativeQuery("SELECT * FROM ers_reimbursement WHERE reimb_author =" + u.getId(), Reimb.class).list();
		return list;
	}

}
