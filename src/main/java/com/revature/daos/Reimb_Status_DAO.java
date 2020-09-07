package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Reimb_Status;
import com.revature.utils.HibernateUtil;

public class Reimb_Status_DAO implements IReimb_Status_DAO {

	@Override
	public Reimb_Status findByStatus(String status) {
		Session ses = HibernateUtil.getSession();
		List<Reimb_Status> list = (List<Reimb_Status>)ses.createQuery("FROM ers_reimbursement_status WHERE reimb_status = "+status+".", Reimb_Status.class).list();
		return list.get(0);
	}

}
