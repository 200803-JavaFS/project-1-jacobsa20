package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.User;
import com.revature.utils.Connection_Util;

public class User_DAO implements IUser_DAO {

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUserPassword(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUsername(String username) {
		User u = new User();
		try (Connection conn = Connection_Util.getConnection()) {
			String sql = "SELECT * FROM ers_users WHERE ers_username = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				//keep this in order!
				u.setId(rs.getInt("ers_users_id"));
				u.setUsername(rs.getString("ers_username"));
				u.setPassword(rs.getString("ers_password"));
				u.setFirst(rs.getString("user_first_name"));
				u.setLast(rs.getString("user_last_name"));
				u.setEmail(rs.getString("user_email"));
								
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(u);
		return u;
	}

	@Override
	public boolean updateUser(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUser(User u) {
		// TODO Auto-generated method stub
		return false;
	}

}
