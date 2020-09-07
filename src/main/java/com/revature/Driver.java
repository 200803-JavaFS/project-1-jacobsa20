package com.revature;

import java.time.LocalDateTime;
import java.util.List;

import com.revature.daos.Reimb_DAO;
import com.revature.daos.User_DAO;
import com.revature.models.Reimb;
import com.revature.models.Reimb_Status;
import com.revature.models.User;
import com.revature.models.User_Role;

public class Driver {
	public static Reimb_DAO rDao = new Reimb_DAO();

	public static User_DAO uDao = new User_DAO();

	public static User_Role uRole = new User_Role();

	public static void main(String[] args) {

		insertValues();

		List<Reimb> list = rDao.findAll();
		for (Reimb r : list) {
			System.out.println(r);
		}
//		Reimb r = rDao.findById(0);
//		System.out.println(r.getStatusId());

	}

	public static void insertValues() {

		User_Role ur2 = new User_Role(2,"Employee");
		User_Role ur3 = new User_Role(3,"Manager");
		
		User u2= new User("abc", "123", "Alli", "Jacobs", "aj@gmail.com", ur2);
		User u3= new User("abcd", "1234", "Al", "Ja", "aj123@gmail.com", ur3);
		
		uDao.addUser(u2);
		uDao.addUser(u3);
		
		
//		System.out.println("Insert Values");
//		String p1 = "CecePhil2";
//		StringBuilder sb1 = new StringBuilder();
//		sb1.append(p1.hashCode());
//		String p1HashCode = new String(sb1);
//		User u1 = new User("P.Halpert123", p1HashCode, "Pamela", "Halpert", "p.halpert@dm.com", uDao.findByRole(uRole), null);
//
//		String p2 = "1234";
//		StringBuilder sb2 = new StringBuilder();
//		sb2.append(p2.hashCode());
//		System.out.println(p2.hashCode());
//		String p2HashCode = new String(sb2);
//		User u2 = new User("WorldsBestBo$$", p2HashCode, "Michael", "Scott", "m.scott@dm.com", uDao.findByRole(uRole), null);
//
//		String p3 = "SchruteFarms4";
//		StringBuilder sb3 = new StringBuilder();
//		sb3.append(p3.hashCode());
//		String p3HashCode = new String(sb3);
//		User u3 = new User("AssistantRgMgr", p3HashCode, "Dwight", "Schrute", "d.schrute@dm.com",uDao.findByRole(uRole), null);
//
//		String p4 = "B!g_Tuna";
//		StringBuilder sb4 = new StringBuilder();
//		sb3.append(p4.hashCode());
//		String p4HashCode = new String(sb4);
//		User u4 = new User("Jimothy_Hal246", p4HashCode, "Jim", "Halpert", "j.halpert@dm.com", uDao.findByRole(uRole), null);
//
//		uDao.addUser(u1);
//		uDao.addUser(u2);
//		uDao.addUser(u3);
//		uDao.addUser(u4);
//
//		LocalDateTime time = LocalDateTime.MIN;
//
//		LocalDateTime t1 = LocalDateTime.now();
//		Reimb r1 = new Reimb(150.00, t1, time, null, u1, null, rDao.findById(), null);
//
//		LocalDateTime t2 = LocalDateTime.now();
//		Reimb r2 = new Reimb(520.00, t2, time, u2, null, rdao.findStatusId(3), rdao.findTypeId(4));
//
//		LocalDateTime t3 = LocalDateTime.now();
//		Reimb r3 = new Reimb(3500.00, t3, time, u3, null, rdao.findStatusId(2), rdao.findTypeId(1));
//
//		LocalDateTime t4 = LocalDateTime.now();
//		Reimb r4 = new Reimb(11.00, t4, time, u3, null, rdao.findStatusId(1), rdao.findTypeId(3));
//
//		rDao.addReimb(r1);
//		rDao.addReimb(r2);
//		rDao.addReimb(r3);
//		rDao.addReimb(r4);

	}
	
//	public static void updateReimb() {
//		Reimb r = rDao.findById(id);
//		Reimb_Status rStats= new Reimb_Status(2, "Approved");
//		r.setStatusId(rStats);
//		rDao.updateReimb(r);
//		
//	}

}
