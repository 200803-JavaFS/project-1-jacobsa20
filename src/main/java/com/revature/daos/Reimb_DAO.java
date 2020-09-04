package com.revature.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.models.Reimb;
import com.revature.models.User;
import com.revature.utils.HibernateUtil;

public class Reimb_DAO implements IReimb_DAO {

	public Reimb_DAO() {
		super();
	}

	@Override
	public List<Reimb> findAll() {
		Session ses = HibernateUtil.getSession();

		List<Reimb> list = ses.createQuery("FROM Reimb").list();
		return list;
	}

	@Override
	public Object findById(int id) {
		Session ses = HibernateUtil.getSession();

		try {
			Reimb r = ses.get(Reimb.class, id);
			return r;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List findByStatus(String status) {
		Session ses = HibernateUtil.getSession();

		try {
			List<Reimb> list = ses.createQuery("FROM Reimb WHERE r_status =" + status, Reimb.class).list();

			return list;
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean addReimb(Object r) {
		Session ses = HibernateUtil.getSession();

		try {
			ses.save(r);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean updateReimb(Object r) {
		Session ses = HibernateUtil.getSession();

		try {
			ses.merge(r);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return false;
	}

	public Object findByType(int i) {
		
		return null;
	}

	@Override
	public List findByUser(User u) {

		return null;
	}

}
