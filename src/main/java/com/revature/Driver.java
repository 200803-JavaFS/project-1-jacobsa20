package com.revature;

import java.util.List;

import com.revature.daos.Reimb_DAO;
import com.revature.daos.User_DAO;
//import com.revature.models.CharacterEx;
//import com.revature.models.DirectorEx;
//import com.revature.models.Movie;
import com.revature.models.Reimb;

public class Driver {
	public static Reimb_DAO rDao = new Reimb_DAO();

	public static User_DAO uDao = new User_DAO();

	public static void main(String[] args) {

		insertValues();

		List<Reimb> list = rDao.findAll();
		for (Reimb r : list) {
			System.out.println(r);
		}

	}

	public static void insertValues() {
		User_DAO dir1 = new User_DAO();
		User_DAO dir2 = new User_DAO();
		User_DAO dir3 = new User_DAO();
//		uDao.insert(dir1);
//		uDao.insert(dir2);
//		uDao.insert(dir3);
//
//		Movie m1 = new Movie("Jurassic Park", "Don't feed the lizards", dir2);
//		Movie m2 = new Movie("Dark Night Rises", "DC", dir1);
//		Movie m3 = new Movie("Moonrise Kingdom", "IDK", dir3);
//		Movie m4 = new Movie("ET", "Phone Home", dir2);
//
//		mDao.insert(m1);
//		mDao.insert(m2);
//		mDao.insert(m3);
//		mDao.insert(m4);
//
//		CharacterEx c1 = new CharacterEx("T-Rex", "female", "terror");
//		CharacterEx c2 = new CharacterEx("Batman", "male", "protec, attac, snac");
//		CharacterEx c3 = new CharacterEx("ET", "female", "find home");
//
//		charDao.insert(c1);
//		charDao.insert(c2);
//		charDao.insert(c3);

	}

}
