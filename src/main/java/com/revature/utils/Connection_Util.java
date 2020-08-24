package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection_Util {

	public static Connection getConnection() throws SQLException {

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// never ever do this. don't hardcode your creds into your code.
		// but it's fine to do for this project.
		String url = "jdbc:postgresql://reimb.cbjkqgslef2x.us-east-2.rds.amazonaws.com:5432/projectone";
		String username = "postgres";
		String password = "password";

		return DriverManager.getConnection(url, username, password);

	}

//	public static void main(String[] args) {
//		try (Connection conn = Connection_Util.getConnection()) {
//			System.out.println("Connection successful.");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

}
