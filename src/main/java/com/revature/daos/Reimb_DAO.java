package com.revature.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Reimb;
import com.revature.models.User;
import com.revature.utils.HibernateUtil;

public class Reimb_DAO implements IReimb_DAO {

//	public Reimb_DAO() {
//		super();
//	}

	@Override
	public List<Reimb> findAll() {
		Session ses = HibernateUtil.getSession();

		List<Reimb> list = ses.createQuery("FROM Reimb").list();
		return list;
	}

	@Override
	public Object findById(int id) {
		Session ses = HibernateUtil.getSession();
		Reimb r = ses.get(Reimb.class, id);
		return r;

	}

	@Override
	public List<Reimb> findByStatus(int statusId) {
		Session ses = HibernateUtil.getSession();
		List<Reimb> list = ses.createQuery("FROM Reimb WHERE reimb_status_id_fk =" + statusId, Reimb.class).list();
		return list;
	}

	@Override
	public boolean addReimb(Reimb r) {
		Session ses = HibernateUtil.getSession();
		Transaction t = ses.beginTransaction();

		try {
			ses.save(r);
			t.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			t.rollback();
			return false;
		}

	}

	@Override
	public boolean updateReimb(Reimb r) {
		Session ses = HibernateUtil.getSession();
		Transaction t = ses.beginTransaction();

		try {
			ses.merge(r);
			t.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			t.rollback();
			return false;
		}

	}

	@Override
	public List<Reimb> findByUser(User u) {
		Session ses = HibernateUtil.getSession();
		List<Reimb> list = ses.createQuery("FROM Reimb WHERE reimb_author ='" + u.getId() + "'", Reimb.class).list();
		return list;
	}


}
