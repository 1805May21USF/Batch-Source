package com.revature.DAOImp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.banking_app.User;
import com.revature.banking_app.User.LevelOfAccess;
import com.revature.dao.UsersDAO;
import com.revature.util.ConnFactory;

public class UserDAOImp implements UsersDAO {

	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public void createUser(User user) throws SQLException 
	{
		Connection conn = cf.getConnection();
		
		String sql ="call INSERTUSERS(?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, user.getLoginName());
		call.setString(2, user.getPassword());
		call.setString(3, user.getFullName());
		call.setString(4, user.permissions.name());
		call.execute();

	}

	@Override
	public void updateUser(User user) throws SQLException 
	{
		Connection conn = cf.getConnection();
		
		String sql ="call UPDATEUSERS(?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, user.getLoginName());
		call.setString(2, user.getPassword());
		call.setString(3, user.getFullName());
		call.setString(4, user.permissions.name());
		call.execute();

	}

	/*@Override
	public void deleteUser(User user) throws SQLException 
	{
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		String sql ="DELETE FROM USERS WHERE LOGINNAME="+ user.getLoginName();
		stmt.executeQuery(sql);

	}*/

	@Override
	public ArrayList<User> getUsers() throws SQLException 
	{
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ArrayList<User> users = new ArrayList<>();
		User user = null;
		ResultSet rs = stmt.executeQuery("SELECT * FROM USERS");
		while(rs.next())
		{
			user = new User(rs.getString(1), rs.getString(2), rs.getString(3), LevelOfAccess.valueOf(rs.getString(4)));
			
			users.add(user);
		}
		
		return users;
	}

}
