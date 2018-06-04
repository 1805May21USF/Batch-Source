package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.revature.dao.CheckUserDAO;
import com.revature.util.ConnFactory;

public class CheckUserDAOImpl implements CheckUserDAO {
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public boolean checkUser(String username) {
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			String queryString = "Select * from person where person.username = '" + username + "'";
			ResultSet result = stmt.executeQuery(queryString);
			if (result.next()) {
				// Return true if the user name is found in the database
				return true;
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println("Error caught at checking username in CheckUsernameDAOimpl: " + ex.getMessage());
		}
		// Return false if the user name is found in the database
		return false;
	}

	@Override
	public boolean checkUserAndPassword(String username, String password) {
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			String queryString = "Select person.username, person.userpassword from person where person.username = '"
					+ username + "'";
			ResultSet result = stmt.executeQuery(queryString);
			while (result.next()) {
				// Return true if the user name is found in the database
				if (result.getString(1).equals(username) && result.getString(2).equals(password)) {
					return true;
				}
			}
			return false;

		} catch (Exception ex) {
			System.out.println("Error caught at checkUserAndPassword in CheckUsernameDAOimpl: " + ex.getMessage());
		}
		// Return false if the user name is found in the database
		return false;
	}

}
