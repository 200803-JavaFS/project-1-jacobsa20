package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.revature.models.Reimb;
import com.revature.utils.Connection_Util;

public class Reimb_DAO implements IReimb_DAO {
	
	
	@Override
	public List<Reimb> findAll() {
		try (Connection conn = Connection_Util.getConnection()) {
			String sql = "SELECT * FROM reimbursement;";
			Statement statement = conn.createStatement();
			List<Reimb> list = new ArrayList<>();

			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				Reimb r = new Reimb(result.getInt("reimb_id"), result.getDouble("reimb_amount"),
						result.getString("reimb_submitted"), result.getString("reimb_resolved"),
						result.getString("reimb_description"), result.getInt("reimb_author"),
						result.getInt("reim_resolver"), result.getInt("reim_status_id"), result.getInt("reim_type_id"));

				list.add(r);
			}

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Reimb findById(int id) {
		try (Connection conn = Connection_Util.getConnection()) {
			String sql = "SELECT * FROM reimbursement WHERE reimb_id =" + id + ";";
			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			if (result.next()) {
				Reimb r = new Reimb(result.getInt("reimb_id"), result.getDouble("reimb_amount"),
						result.getString("reimb_submitted"), result.getString("reimb_resolved"),
						result.getString("reimb_description"), result.getInt("reimb_author"),
						result.getInt("reim_resolver"), result.getInt("reim_status_id"), result.getInt("reim_type_id"));

				return r;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addReimb(Reimb r) {
		try (Connection conn = Connection_Util.getConnection()) {
			
			String sql = "INSERT INTO reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, "
					+ "reimb_author, reim_resolver, reim_status_id,	reim_type_id) "
					+ "VALUES (?, ?, ?, ?, ?, ?,?, ?, ?);";
			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0;
			statement.setDouble(++index, r.getAmount());
			statement.setString(++index, r.getSubmitted());
			statement.setString(++index, r.getResolved());
			statement.setString(++index, r.getDescription());
			statement.setInt(++index, r.getAuthor());
			statement.setInt(++index, r.getResolver());
			statement.setInt(++index, r.getStatusId());
			statement.setInt(++index, r.getTypeId());

			statement.execute();
			// execute returns true only if it brings back data
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateReimb(Reimb r) {
		try (Connection conn = Connection_Util.getConnection()) {
			String sql = "UPDATE reimbursement SET reimb_amount= ?, reimb_submitted= ?,"
					+ " reimb_resolved= ?, reimb_description= ?, reimb_author= ?, reim_resolver= ? "
					+ "reim_status_id=?,reim_type_id=? WHERE reimb_id=?;";

			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0;
			statement.setDouble(++index, r.getAmount());
			statement.setString(++index, r.getSubmitted());
			statement.setString(++index, r.getResolved());
			statement.setString(++index, r.getDescription());
			statement.setInt(++index, r.getAuthor());
			statement.setInt(++index, r.getResolver());
			statement.setInt(++index, r.getStatusId());
			statement.setInt(++index, r.getTypeId());
			statement.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Reimb> findByUser(int userId) {
		try (Connection conn = Connection_Util.getConnection()) {
			String sql = "SELECT * FROM reimbursement WHERE reimb_author =" + userId + ";";
			Statement statement = conn.createStatement();
			List<Reimb> list = new ArrayList<>();
			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				Reimb r = new Reimb(result.getInt("reimb_id"), result.getDouble("reimb_amount"),
						result.getString("reimb_submitted"), result.getString("reimb_resolved"),
						result.getString("reimb_description"), result.getInt("reimb_author"),
						result.getInt("reim_resolver"), result.getInt("reim_status_id"), result.getInt("reim_type_id"));

				list.add(r);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	@Override
	public List<Reimb> findByStatus(String status) {
		try (Connection conn = Connection_Util.getConnection()) {
			String sql = "SELECT * FROM reimbursement" + "JOIN reimb_status" + "ON r.reim_status_id =rs.reimb_status_id"
					+ "WHERE reimb_status= ?;";
			List<Reimb> list = new ArrayList<>();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, status);
			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				Reimb r = new Reimb(result.getInt("reimb_id"), result.getDouble("reimb_amount"),
						result.getString("reimb_submitted"), result.getString("reimb_resolved"),
						result.getString("reimb_description"), result.getInt("reimb_author"),
						result.getInt("reim_resolver"), result.getInt("reim_status_id"), result.getInt("reim_type_id"));

				list.add(r);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
}
