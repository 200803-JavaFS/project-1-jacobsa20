package com.revature;

import java.util.List;

import com.revature.daos.CharacterDAO;
import com.revature.daos.DirectorDAO;
import com.revature.daos.MovieDAO;
import com.revature.models.CharacterEx;
import com.revature.models.DirectorEx;
import com.revature.models.Movie;

public class Driver {
	public static CharacterDAO charDao = new CharacterDAO();

	public static MovieDAO mDao = new MovieDAO();

	public static DirectorDAO dirDao = new DirectorDAO();

	public static void main(String[] args) {

		insertValues();
		
		List<Movie> movies= mDao.findAll();
		for(Movie m:movies) {
			System.out.println(m);
		}

	}

	public static void insertValues() {
		DirectorEx dir1 = new DirectorEx("Christopher", "Nolan", null);
		DirectorEx dir2 = new DirectorEx("Steven", "Speilberg", null);
		DirectorEx dir3 = new DirectorEx("Wes", "Anderson", null);
		dirDao.insert(dir1);
		dirDao.insert(dir2);
		dirDao.insert(dir3);

		Movie m1 = new Movie("Jurassic Park", "Don't feed the lizards", dir2);
		Movie m2 = new Movie("Dark Night Rises", "DC", dir1);
		Movie m3 = new Movie("Moonrise Kingdom", "IDK", dir3);
		Movie m4 = new Movie("ET", "Phone Home", dir2);

		mDao.insert(m1);
		mDao.insert(m2);
		mDao.insert(m3);
		mDao.insert(m4);

		CharacterEx c1 = new CharacterEx("T-Rex", "female", "terror");
		CharacterEx c2 = new CharacterEx("Batman", "male", "protec, attac, snac");
		CharacterEx c3 = new CharacterEx("ET", "female", "find home");

		charDao.insert(c1);
		charDao.insert(c2);
		charDao.insert(c3);

	}

}
