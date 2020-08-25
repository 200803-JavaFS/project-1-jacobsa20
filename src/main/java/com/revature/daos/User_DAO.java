package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.models.User_Role;
import com.revature.utils.Connection_Util;

public class User_DAO implements IUser_DAO {
	
	@Override
	public List<User> findAll() {
		try (Connection conn = Connection_Util.getConnection()) {
			String sql = "SELECT * FROM ers_users;";
			Statement statement = conn.createStatement();
			List<User> list = new ArrayList<>();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt("ers_users_id"));
				u.setUsername(rs.getString("ers_username"));
				u.setPassword(rs.getString("ers_password"));
				u.setFirst(rs.getString("user_first_name"));
				u.setLast(rs.getString("user_last_name"));
				u.setEmail(rs.getString("user_email"));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

				// keep this in order!
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
		try(Connection conn= Connection_Util.getConnection()){
			String sql = "INSERT INTO ers_user (ers_username, ers_password, user_first_name, user_last_name, user_email)"
					+"VALUES (?,?,?,?,?);";
			PreparedStatement ps= conn.prepareStatement(sql);
			int index = 0;
			ps.setString(++index, u.getUsername());
			ps.setString(++index, u.getPassword());
			ps.setString(++index, u.getFirst());
			ps.setString(++index, u.getLast());
			ps.setString(++index, u.getEmail());
//			if(u.getUserRoleId()!=0) {
//				User_Role ur= u.getUserRoleId();
//			}else {
//				ps.setInt(++index, 0);
//			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
