package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Reimb_Type;
import com.revature.utils.HibernateUtil;

public class Reimb_Type_DAO implements IReimb_Type_DAO {

	@Override
	public Reimb_Type findByType(String type) {
		Session ses = HibernateUtil.getSession();
		List<Reimb_Type> list = (List<Reimb_Type>) ses.createQuery("FROM ers_reimbursement_type WHERE reimb_type = " +type+".", Reimb_Type.class).list();
		return list.get(0);
	}

}
