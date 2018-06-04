package com.revature.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.User;
import com.revature.dao.UserDao;
import com.revature.util.ConnFactory;

public class UserDaoImp implements UserDao {
	
	public static ConnFactory cf = ConnFactory.getInstance();

	public void createUser(User user) throws SQLException {
		
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "UserID";
		
		String sql = "INSERT INTO BANKUSER VALUES(USERIDSEQ.NEXTVAL, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = conn.prepareStatement(sql, primaryKeys);
		ps.setString(1, user.getFirstName());
		ps.setString(2, user.getLastName());
		ps.setString(3, user.getEmail());
		ps.setString(4, user.getUsername());
		ps.setString(5, user.getPassword());
		ps.executeUpdate();
		
		System.out.println("New user successfully added!");
		
		
	}

	public void deleteUser(int userID) throws SQLException {
		
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		stmt.executeQuery("DELETE FROM BANKUSER WHERE USERID = '" + userID + "'");
		
	}

	public User getUserByID(int userID) throws SQLException {
		
		User u = null;
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT FROM BANKUSER WHERE USERID = '" + userID + "'");
		u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
		
		return u;
	}

	public User getUserByName(String firstName, String lastName) throws SQLException {
		
		User u = null;
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT FROM BANKUSER WHERE FIRSTNAME = '" + firstName + "' AND LASTNAME = '" + lastName + "'");
		u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
		
		return u;
	}

	public User getUserByEmail(String email) throws SQLException {
		
		User u = null;
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT FROM BANKUSER WHERE EMAIL = '" + email + "'");
		u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
		
		return u;
	}

	public List<User> getAllUsers() throws SQLException {
		
		List<User> userList = new ArrayList<User>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM BANKUSER");
		User u = null;
		
		while(rs.next()) {
			u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			userList.add(u);
		}
			
		return userList;
	}
	
	public User checkLoginCredentials(String username, String password) throws SQLException {
		
		User u = null;
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT FROM BANKUSER WHERE USERNAME = '" + username + "'");
		u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
		
		if(u.getPassword() == password) {
			return u;
		} else {
			return null;
		}
		
		
		
	}
	
	public void login() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Existing User Login");
		System.out.print("Username: ");
		String user = sc.nextLine();
		System.out.print("Password: ");
		String pass = sc.nextLine();
		
		User u = checkLoginCredentials(user, pass);
		
		if(u != null) {
			System.out.println("Login Successfull!");
			//show user menu
		} else {
			System.out.println("Invalid username or password!");
			//retry login
		}
		
	}
	
	public void newUserLogin() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("New User Login");
		System.out.print("Username: ");
		String user = sc.nextLine();
		System.out.print("Password: ");
		String pass = sc.nextLine();
		System.out.print("First Name: ");
		String first = sc.nextLine();
		System.out.print("Last Name: ");
		String last = sc.nextLine();
		System.out.print("Email: ");
		String emailAddress = sc.nextLine();
		
		User u = new User(first, last, emailAddress, user, pass);
		createUser(u);
		
	}

}
