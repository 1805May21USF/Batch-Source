package com.revature.implementdao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.util.ConnFactory;

public class ImpUserDAO implements UserDAO{
	public static ConnFactory cf = ConnFactory.getInstance();
	
	/*
	 * Name: insertUser()
	 * Input:String firstname, String lastname, String username, String password
	 * Output:None
	 * Description: Calls procedure to create a user account in SQL Table USERS
	 */
	@Override
	public void insertUser(String firstname, String lastname, String username, String password) throws SQLException {
		Connection conn = cf.getConnection();
		
		String sql = "{call INSERTUSER(?,?,?,?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, firstname);
		call.setString(2, lastname);
		call.setString(3, username);
		call.setString(4, password);
		call.execute();
		conn.close();
	}

	/*
	 * Name: getUserByCredentials()
	 * Input:String username, String password
	 * Output:User
	 * Description: Calls prepared statement to get a user account by username and password in SQL Table USERS
	 */
	@Override
	public User getUserByCredentials(String username, String password) throws SQLException {
		User usr = new User();
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM USERS WHERE USERNAME=? AND PASSWORD=? FETCH FIRST 1 ROWS ONLY";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			usr.setId(rs.getInt(1));
			usr.setFirstname(rs.getString(2));
			usr.setLastname(rs.getString(3));
			usr.setUsername(rs.getString(4));
			usr.setPassword(rs.getString(5));
		}
		conn.close();
		return usr;
	}
	
	/*
	 * Name: getUserByUsername()
	 * Input:String username
	 * Output:User
	 * Description: Calls prepared statement to get a user account by username in SQL Table USERS
	 */
	@Override
	public User getUserByUsername(String username) throws SQLException {
		User usr = new User();
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM USERS WHERE USERNAME=? FETCH FIRST 1 ROWS ONLY";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			usr.setId(rs.getInt(1));
			usr.setFirstname(rs.getString(2));
			usr.setLastname(rs.getString(3));
			usr.setUsername(rs.getString(4));
			usr.setPassword(rs.getString(5));
		}
		conn.close();
		return usr;
	}
	
	/*
	 * Name: getUserList()
	 * Input:None
	 * Output:List<User>
	 * Description: Calls prepared statement to get all users in SQL Table USERS
	 */
	@Override
	public List<User> getUserList() throws SQLException {
		// TODO Auto-generated method stub
		List<User> userList = new ArrayList<User>();
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM USERS";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			User u = null;
			
			while(rs.next()) {
				u=new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				userList.add(u);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		conn.close();
		return userList;
	}

	/*
	 * Name: deleteUser()
	 * Input:String username
	 * Output:None
	 * Description: Calls procedure to delete a user account in SQL Table USERS
	 */
	@Override
	public void deleteUser(String username) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		
		String sql = "{call DELETEUSER(?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, username);
		call.execute();
		conn.close();
	}
	
	/*
	 * Name: updateUser()
	 * Input: User
	 * Output:None
	 * Description: Calls procedure to update a user account in SQL Table USERS
	 */
	@Override
	public void updateUser(User u) throws SQLException {
		Connection conn = cf.getConnection();
		
		String sql = "{call UPDATEUSER(?,?,?,?,?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, u.getId());
		call.setString(2, u.getFirstname());
		call.setString(3, u.getLastname());
		call.setString(4, u.getUsername());
		call.setString(5, u.getPassword());
		call.execute();
		conn.close();
	}
}
