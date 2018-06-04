package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.B_User;
import com.revature.dao.B_UserDAO;
import com.revature.util.ConnFactory;

public class B_UserDAOImpl implements B_UserDAO {

	public static ConnFactory cf = ConnFactory.getInstance();

	public void createUser(String firstName, String lastName, String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		String sql = "{call INSERTUSER(?, ?, ?, ?, ?, ?, ?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, username);
		call.setString(2, firstName );
		call.setString(3, lastName );
		call.setString(4, password );
		call.setInt(5, 0);
		call.setInt(6, 0);
		call.setString(7, "N");
		call.execute();
		
		conn.close();
	}

	public List<B_User> getUserList() throws SQLException {
		// TODO Auto-generated method stub
		List<B_User> userList = new ArrayList<B_User>();
		Connection conn = cf.getConnection();
		Statement stmt1 = conn.createStatement();
		ResultSet rs = stmt1.executeQuery("SELECT * FROM B_USER");
		B_User s = null;
		
		while(rs.next()) {
			//System.out.println(rs.getString(8));
			boolean temp1 = (rs.getInt(6) == 1) ? true : false;
			boolean temp2 = (rs.getInt(7) == 1) ? true : false;
			s = new B_User(rs.getInt(1), rs.getString(2), rs.getString(3), 
					rs.getString(4), rs.getString(5), temp1, temp2, rs.getString(8));
			userList.add(s);
		}
		conn.close();
		return userList;
	}
	
	public List<B_User> getUnapprovedUserList() throws SQLException {
		// TODO Auto-generated method stub
		List<B_User> userList = new ArrayList<B_User>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM B_USER WHERE USER_APPROVED = 'N'");

		
		while(rs.next()) {
			B_User s = null;
			System.out.println(rs.getInt(6));
			boolean temp1 = (rs.getInt("ADMIN_STATUS") == 1) ? true : false;
			boolean temp2 = (rs.getInt("LOGGED_IN") == 1) ? true : false;
			s = new B_User(rs.getInt(1), rs.getString(2), rs.getString(3), 
					rs.getString(4), rs.getString(5), temp1, temp2, rs.getString(8));
			userList.add(s);
		}
		conn.close();
		return userList;

	}

	
}
