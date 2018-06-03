package com.revature.driver;

import java.sql.SQLException;

import com.revature.beans.User;
import com.revature.daoimpl.UserDAOImpl;

public class TestDriver {
	
	public static void main(String[] args) {
		UserDAOImpl udi = new UserDAOImpl();
		try {
			//udi.createUser("adminini", "admin", "admin", "admin", 3);
			//udi.createUser("nathan", "admin", "admin", "admin", 3);
			udi.createUser("bobross", "bob", "ross", "password", 1);
			udi.updateUser("bobross", "password");
			User user = udi.retrieveUser("bobross");
			System.out.println(user.toString());
			udi.updateUser("bobross", "happytrees");
			user = udi.retrieveUser("bobross");
			System.out.println(user.toString());
			udi.deleteUser("bobross");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
