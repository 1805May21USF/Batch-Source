package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.util.ConnFactory;

/**
 * Data access object implementation for accessing, editing, and
 * manipulating user accounts.
 * @author Nathaniel Simpson
 *
 */
public class UserDAOImpl implements UserDAO {

	//Connection factory object to connect to the database.
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public void createUser(String userName, String firstName,
			String lastName, String password, int status) throws SQLException {
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "USER_ID";
		String sql = 
				"INSERT INTO USER_ACCOUNT VALUES(USERSEQ.NEXTVAL,?,?,?,?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql,primaryKeys);
			ps.setString(1, userName);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setString(4, password);
			ps.setInt(5, status);
			ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}

		conn.close();
	}

	@Override
	public User retrieveUser(String userName) throws SQLException{
		Connection conn = cf.getConnection();

		// A PreparedStatement should have been used here
		// The current implementation can leave the database
		// vulnerable to SQL injections.
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(
				"SELECT * FROM USER_ACCOUNT WHERE"
						+ " USERNAME = '" + userName + "'");
		User user = null;

		if (rs.next()) {
			//System.out.println("This user exists");
			user = new User(rs.getInt(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5), rs.getInt(6));
			conn.close();
			return user;
		} else {
			//System.out.println("User not found");
		}
		conn.close();
		return null;
	}

	/*
	 * Updates the password for an account
	 */
	@Override
	public void updateUser(String userName,
			String newPassword) throws SQLException {
		Connection conn = cf.getConnection();
		// A PreparedStatement should have been used here
		// The current implementation can leave the database
		// vulnerable to SQL injections.
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(
				"SELECT * FROM USER_ACCOUNT "
						+ "WHERE USERNAME = '" + userName + "'");

		if (rs.next()) {
			String[] primaryKeys = new String[1];
			primaryKeys[0] = "USER_ID";
			String sql =
					"UPDATE USER_ACCOUNT SET PASS_WORD = '" + newPassword 
					+ "' WHERE USERNAME = '" + userName + "'";
			try {
				PreparedStatement ps = conn.prepareStatement(sql, primaryKeys);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("User account not found");
		}
		conn.close();
	}

	@Override
	public void deleteUser(String userName) throws SQLException {
		Connection conn = cf.getConnection();
		// A PreparedStatement should have been used here
		// The current implementation can leave the database
		// vulnerable to SQL injections.
		Statement stmt = conn.createStatement();
		stmt.execute("DELETE FROM USER_ACCOUNT"
				+ " WHERE USERNAME = '" + userName + "'");
		conn.close();
	}

}
