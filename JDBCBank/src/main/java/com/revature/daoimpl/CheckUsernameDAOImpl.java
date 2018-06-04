package com.revature.daoimpl;

import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.util.ArrayList;
//import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet;

import com.revature.dao.CheckUsernameDAO;
import com.revature.util.ConnFactory;

public class CheckUsernameDAOImpl implements CheckUsernameDAO {
	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public boolean checkUsername(String username) {
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			String queryString = "Select * from person where person.username = '" + username + "'";
			ResultSet result = stmt.executeQuery(queryString);
			if (result.next()) {
				//Return true if username does exist
				return true;
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println("Error caught at checking username in CheckUsernameDAOimpl: " + ex.getMessage());
		}
		//Return false if username doesn't exist
		return false;

	}

}
