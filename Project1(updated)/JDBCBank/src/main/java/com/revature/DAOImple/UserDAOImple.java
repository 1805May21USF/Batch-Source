package com.revature.DAOImple;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.revature.beans.User;
import com.revature.dao.UserDao;
import com.revature.util.ConnFactory;

public class UserDAOImple implements UserDao {
	public static ConnFactory cf = ConnFactory.getInstance();
	public void createUser(String userName, String password)  {
		Connection conn = cf.getConnection();
		String sql = "{call INSERTUSER(?,?)}";
		
		CallableStatement call;
		try {
			call = conn.prepareCall(sql);
			call.setString(1, userName);
			call.setString(2, password);
			call.execute();
			conn.close();
		} catch (SQLException e) {
			System.out.println("Bank is currently closed for scheduled maintainence "+e.getMessage());
		}
		

	}
	public int getUserID(String username)  {
		Connection conn= cf.getConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT userid FROM Users where users.username ='"+username+"'");
			rs.next();
			int userID = rs.getInt(1);
			rs.close();
			conn.close();
			return userID;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Bank is currently closed for scheduled maintainence "+e.getMessage());
		}
		return 0;
	}
	public List<User> getUserList() {
		List<User> userList = new ArrayList<User>();
		Connection conn= cf.getConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Users");
			User u = null;
			
			while(rs.next()) {
				u = new User(rs.getString(2),rs.getString(3),rs.getInt(1));
				userList.add(u);
			}
			rs.close();
			conn.close();
			return userList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Bank is currently closed for scheduled maintainence "+e.getMessage());
		}
		return userList;
		
	}
	public  boolean isUserName(String username) {
		List<User> users = getUserList();
		for(User u:users) {
			if(username.equals(u.getUsername())){
			//	System.out.println("user exist");
				return true;
			}
		}
		return false;
	}
	
	public boolean login(String username,String password)  {
		List<User> users = getUserList();
		for(User u:users) {
			if(username.equals(u.getUsername())&&password.equals(u.getPassword())) {
				return true;
			}
		}
		return false;
		
	}
	public void delete(int UserID) {
		Connection conn = cf.getConnection();
		String sql = "{call DELETEUSER(?)";
		
		CallableStatement call;
		try {
			call = conn.prepareCall(sql);
			call.setInt(1, UserID);
			call.execute();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Bank is currently closed for scheduled maintainence "+e.getMessage());
		}
	}

}
