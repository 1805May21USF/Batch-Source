package com.revature.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.util.Connect2DB;

public class UserDAOImpl implements UserDAO {
	
	public static Connect2DB cdb = Connect2DB.getInstance();

	/*this method accepts four parameters:
	 * firstname, lastname, username, and password
	 * creates the user if user doesn't already exist
	 */
	public void registerUser(String firstName, String lastName, String username, String password) throws SQLException {
		
		Connection conn = cdb.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "USERID";
		String sql = "INSERT INTO BANK_USER VALUES(USER_ID.NEXTVAL, ?, ?, ?, ?)";
		
		PreparedStatement ps = conn.prepareStatement(sql, primaryKeys);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setString(3, username);
		ps.setString(4, password);
		ps.executeUpdate();
	}

	//returns the userlist
	public List<User> getUserList() throws SQLException {
		List<User> userList = new ArrayList<User>();
		Connection conn = cdb.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM BANK_USER");
		User user = null;
		
		while(rs.next()) {
			user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), 
					rs.getString(4), rs.getString(5));
			userList.add(user);
		}
		return userList;
	}

	//this method validates login for users
	//checks the login info against the database to make sure that the user exists
	public boolean validateLogin(String username, String password) throws SQLException{
		
		String dbusername, dbpassword;
		boolean success = false;
		Connection conn = cdb.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT USERNAME, PASSWORD FROM BANK_USER");
		
		while(rs.next()) {
			dbusername = rs.getString("USERNAME");
			dbpassword = rs.getString("PASSWORD");
			
			if(dbusername.equals(username) && dbpassword.equals(password)) {
				success = true;
			}
			
		}
		conn.close();
		return success;
	}
	
	/*admin can pass a userid to this method to delete that user
	 */
	public void deleteUsers(int userID) throws SQLException {
		Connection conn = cdb.getConnection();
		String sql = "{call DELETE_USER(?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, userID);
		call.execute();
		conn.close();
	}
	
	/*this method updates user info
	 * accepts a user, new username, and new password of the user
	 * and updates it in the database
	 */
	public void updateUserInfo(User user, String username, String password) throws SQLException{
		Connection conn = cdb.getConnection();
		String sql = "{call UPDATE_USER_INFO(?,?,?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, user.getUserID());
		call.setString(2, username);
		call.setString(3, password);
		call.execute();
		conn.close();
	}
}
