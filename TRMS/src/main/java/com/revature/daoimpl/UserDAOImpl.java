package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.util.ConnFactory;

/**
 * Data access object implementation for accessing, editing, and
 * manipulating user accounts and data.
 * @author Nathaniel Simpson
 *
 */
public class UserDAOImpl implements UserDAO {
	
	
	private String[] arr;
	
	public UserDAOImpl(String[] arr) {
	
		this.arr = arr;
	
	}
	
	//Connection factory object for connecting to the database
	public static ConnFactory cf = ConnFactory.getInstance();

	
	/*
	 * Creates a new user in the database
	 */
	public void createUser(String fName, String lName, 
			String email, String password, int tid) throws SQLException {
		
		Connection conn = cf.getConnection(arr);
		String sql = "{call CREATE_USER(?,?,?,?,?)";
		
		System.out.println("Begin call");
		
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, fName);
		call.setString(2, lName);
		call.setString(3, email);
		call.setString(4, password);
		call.setInt(5, tid);
		call.execute();
		conn.close();
		
		System.out.println("Call complete");
		
	}

	/*
	 * Retrieves a user from the database
	 */
	public User retrieveUser(String email) throws SQLException {
		
		Connection conn = cf.getConnection(arr);
		String sql = "SELECT * FROM USERS WHERE EMAIL = ?";
		ResultSet rs = null;
		User user = null;
		
		
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
		
		
		if (rs.next()) {
			user = new User(rs.getInt(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5), rs.getInt(6));
			conn.close();
			return user;
		}
		
		return null;

	}
	
	public boolean userExist(String email) throws SQLException {
		Connection conn = cf.getConnection(arr);
		String sql = "SELECT * FROM USERS WHERE EMAIL = ?";
		ResultSet rs = null;
		User user = null;
		
		
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			boolean tf = rs.next();
			conn.close();
		
		
		return tf;
	}

	
	/*
	 * Updates the title of a user in the database
	 */
	public void updateUser(String email, int tid) throws SQLException {
		
		Connection conn = cf.getConnection(arr);
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "USER_ID";
		String sql = "UPDATE USERS SET TID = ? WHERE EMAIL = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql, primaryKeys);
			ps.setInt(1, tid);
			ps.setString(2, email);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		conn.close();
	}

	/*
	 * Deletes a user from the database
	 */
	public void deleteUser(String email) throws SQLException {
		
		Connection conn = cf.getConnection(arr);
		String sql = "{call DELETE_USER(?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, email);
		call.execute();
		conn.close();
		
	}
	
	public int getUserTitle(String email) throws SQLException {
		Connection conn = cf.getConnection(arr);
		
		String sql = "SELECT TID FROM USERS WHERE EMAIL = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		int i = 1;
		if(rs.next()) {
			i = rs.getInt(1);
		}
		conn.close();
		return i;
 	}

}