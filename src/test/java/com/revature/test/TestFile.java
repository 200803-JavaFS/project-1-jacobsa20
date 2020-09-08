package com.revature.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.models.Reimb;
import com.revature.models.Reimb_Status;
import com.revature.models.Reimb_Type;
import com.revature.models.User;
import com.revature.models.User_Role;
import com.revature.services.LoginService;
import com.revature.services.Reimb_Service;
import com.revature.services.User_Service;

public class TestFile {

	public static LoginService ls;
	public static User_Service us;
	public static Reimb_Service rs;

	public static User_Role testRole;
	public static User_Role testRoleMan;
	public static User testUser;
	public static User testUserMan;
	public static Reimb_Status testReimbStatus;
	public static Reimb_Type testReimbType;
	public static Reimb testReimb;
	public static LocalDateTime ldt;

	public TestFile() {
		super();
	}

	@BeforeClass
	public static void set() {
		System.out.println("In Before Class");
		ls = new LoginService();
		us = new User_Service();
		rs = new Reimb_Service();
	}

	@Before
	public void startup() {
		// 2== employee, 3== manager
		testRole = new User_Role(2, "Employee");
		testRoleMan = new User_Role(3, "Manager");
		// user we want add
		testUser = new User(10, "testUsername", "testPassword", "testFirstName", "testLastName", "test@test.com",
				testRole);
		testUserMan = new User(20, "testUsername", "testPassword", "testFirstName", "testLastName", "test@test.com",
				testRoleMan);

		testReimbStatus = new Reimb_Status(1, "Pending");
		testReimbType = new Reimb_Type(1, "Lodging");
//		testReimb = new Reimb(12.34, ldt.now(), null, "testDescription", us.findById(1), null,
//				rs.findByReimbStatus("Pending"), rs.findByReimbType("Other"));
	}
//
//	@Test
//	public void testLogin() {
//		System.out.println("in login");
//
//		User u = new User(1, "P.Halpert123", "CecePhil2", "Pamela", "Halpert", "p.halpert@dm.com", testRole);
//		System.out.println(u);
//		boolean login = ls.login(u);
//		assertTrue(login);
//	}
//
//	@Test
//	public void addUserTest() {
//		boolean userAdd = us.addUser(testUser);
//		assertEquals(userAdd, true);
//	}
//
//	@Test
//	public void addReimbTest() {
//		boolean reimbAdd = rs.addReimb(testReimb);
//		assertTrue(reimbAdd);
//	}
//
//	@Test
//	public void getReimbById() {
//		// 13 id testReimb
//		Reimb r = rs.findById(15);
//		System.out.println(r);
//		// it doesn't like timestamp
//		Reimb rTest = new Reimb(15, 67.86, r.getSubmitted(), null, "testDescription", us.findById(1), null,
//				rs.findByReimbStatus("Pending"), rs.findByReimbType("Other"));
//		System.out.println(rTest);
//		assertEquals(r, rTest);
//	}
//
//	@Test
//	public void findUserById() {
//		System.out.println("In find by user ID");
//		User u = us.findById(15);
//		System.out.println(u.password);
//		User testAgainst = new User(15, "kc2009", u.password, "Kassandra", "Rodriguez", "kc2009@gmail.com", testRole);
//		assertEquals(u, testAgainst);
//	}
//
//	@Test
//	public void findUserByUsername() {
//		System.out.println("In find by username");
//		User u = us.findByUsername("kc2009");
//		System.out.println(u.password);
//		User testAgainst = new User(15, "kc2009", u.password, "Kassandra", "Rodriguez", "kc2009@gmail.com", testRole);
//		assertEquals(u, testAgainst);
//	}
//
//	public void findUserByCredentials() {
//		System.out.println("In find by credentials");
//		User u = us.findByUserPassword("kc2009", "bestie");
//		System.out.println(u.password);
//		User testAgainst = new User(15, "kc2009", u.password, "Kassandra", "Rodriguez", "kc2009@gmail.com", testRole);
//		assertEquals(u, testAgainst);
//	}
//
//	@Test
//	public void findReimbTypeByType() {
//		System.out.println("in find reimb by type test");
//
//		Reimb_Type rt = rs.findByReimbType("Lodging");
//		assertEquals(testReimbType, rt);
//	}
//
//	@Test
//	public void findReimbByUser() {
//		User u = us.findById(5);
//		List<Reimb> rList = rs.findByUser(u);
//		assertTrue(rList != null);
//	}
//
//	@Test
//	public void findAllReimb() {
//		List<Reimb> rList = rs.findAll();
//		assertTrue(rList != null);
//	}
//
//	@Test
//	public void findReimbByStatus() {
//		List<Reimb> rListStatus = rs.findByStatus(1);
//		for (Reimb r : rListStatus) {
//			Reimb_Status status = r.getStatusId();
//			assertEquals(status, testReimbStatus);
//		}

	// }

	/**
	 * 
	 */
//	@AfterClass
//	public static void shutdown() {
//		testRole = null;
//		testUser = null;
//		testReimbStatus = null;
//		testReimbType = null;
//		testReimb = null;
//		ls = null;
//		us = null;
//		rs = null;

}
