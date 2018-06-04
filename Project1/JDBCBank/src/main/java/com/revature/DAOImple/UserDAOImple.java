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
	public void createUser(String userName, String password) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call INSERTUSER(?,?)}";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, userName);
		call.setString(2, password);
		call.execute();
		conn.close();
		

	}
	public int getUserID(String username) throws SQLException {
		Connection conn= cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT userid FROM Users where users.username ='"+username+"'");
		rs.next();
		int userID = rs.getInt(1);
		rs.close();
		conn.close();
		return userID;
	}
	public List<User> getUserList() throws SQLException {
		List<User> userList = new ArrayList<User>();
		Connection conn= cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Users");
		User u = null;
		
		while(rs.next()) {
			u = new User(rs.getString(2),rs.getString(3),rs.getInt(1));
			userList.add(u);
		}
		rs.close();
		conn.close();
		return userList;
		// TODO Auto-generated method stub
		/*
		 * List<SuperHero> superHeroList = new ArrayList<SuperHero>();
		Connection conn= cf.getConnection();//line needed in each method
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM SUPERHERO");
		SuperHero s = null;
		
		while(rs.next()) {
			s = new SuperHero(rs.getInt(1),rs.getString(2));//resultset starts from 1, not 0
			superHeroList.add(s);
		}
		return superHeroList;
		 */
	}
	public boolean isUserName(String username) throws SQLException {
		List<User> users = getUserList();
		for(User u:users) {
			if(username.equals(u.getUsername())){
				System.out.println("user exist");
				return true;
			}
		}
		return false;
	}
	
	public boolean login(String username,String password) throws SQLException {
		List<User> users = getUserList();
		for(User u:users) {
			if(username.equals(u.getUsername())&&password.equals(u.getPassword())) {
				return true;
			}
		}
		return false;
		
	}

}
