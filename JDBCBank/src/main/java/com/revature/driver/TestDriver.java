package com.revature.driver;

import java.sql.SQLException;

import com.revature.beans.User;
import com.revature.daoimpl.UserDAOImpl;

public class TestDriver {
	
	public static void main(String[] args) {
		UserDAOImpl udi = new UserDAOImpl();
		try {
//			udi.createUser("adminini", "admin", "admin", "admin", 3);
//			udi.createUser("nathan", "admin", "admin", "admin", 3);
			User user = udi.retrieveUser("adminini");
			System.out.println(user.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
