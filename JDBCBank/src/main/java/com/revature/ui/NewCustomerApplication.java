package com.revature.ui;

import java.sql.SQLException;

import com.revature.beans.User;
import com.revature.daoimpl.UserDAOImpl;

public class NewCustomerApplication {

	private UserDAOImpl udi = new UserDAOImpl();

	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private final int STATUS = 0;

	private boolean isValidUserName = false;
	private boolean isValidPassword = false;

	public void createApplication() {

		System.out.println("Thank you for choosing Bank of Roll Tide!");
		System.out.println("We just need to collection some information"
				+ " before processing your application");
		System.out.println();

		//Username
		while (!isValidUserName) {
			User existingUser = null;

			System.out.print("Please enter your desired username: ");
			String desiredUserName = Menu.in.next();

			try {
				existingUser = udi.retrieveUser(desiredUserName);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			if (existingUser == null || 
					(!desiredUserName.equalsIgnoreCase
							(existingUser.getUserName()))) {
				isValidUserName = true;
				System.out.println("Username is available!\n");
				userName = desiredUserName;
			} else {
				System.out.println("Username is unavailable.");
			}
		}

		//Customer name
		System.out.print("Please enter your first name: ");
		firstName = Menu.in.next();
		System.out.print("Please enter your last name: ");
		lastName = Menu.in.next();

		//Password
		System.out.println("Please create a password"
				+ " (Must contain a number)");
		while (!isValidPassword) {
			System.out.print("Password: ");
			password = Menu.in.next();
			if (password.matches(".*\\d.*")) {
				System.out.println("Password is valid!");
				isValidPassword = true;
			} else {
				System.out.println("The password must contain"
						+ " at least one number.");
			}
		}	
		
		//Send application
		try {
			udi.createUser(userName, firstName, lastName, password, STATUS);
			System.out.println("Application sent successfully!");
			System.out.println("Please be patient as your "
					+ "application is reviewed.");
		} catch (SQLException e) {
			System.out.println("Application unsuccessful");
			e.printStackTrace();
		}
	}
}
