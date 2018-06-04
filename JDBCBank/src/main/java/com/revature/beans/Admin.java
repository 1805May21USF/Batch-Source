package com.revature.beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.daoImpl.UserDAOImpl;
import com.revature.driver.Driver;

public class Admin {

	private String username;
	private String password;
	private String superUserName;
	private static UserDAOImpl usd = new UserDAOImpl();
	
	public Admin() {
		super();
		username = "cmiycn";
		password = "RollTide!";
		superUserName = "Da Boss";
	}

	public Admin(String username, String password, String superUserName) {
		super();
		this.username = username;
		this.password = password;
		this.superUserName = superUserName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSuperUserName() {
		return superUserName;
	}

	public void setSuperUserName(String superUserName) {
		this.superUserName = superUserName;
	}

	@Override
	public String toString() {
		return "Admin [username=" + username + ", password=" + password + ", superUserName=" + superUserName + "]";
	}
	
	/*admin can view all the users in the system using this method
	 * prints out the userid, firstname, lastname, username, and password
	 * of all users
	 */
	public void viewUsers() throws SQLException{
		System.out.println("===========================================");
		System.out.println("                 ***Users***               ");
		List<User> users = usd.getUserList();
		for(User user: users) {
			System.out.println("USERID: " + user.getUserID() + " " + "Name: " + user.getFirstName() + " " + 
					user.getLastName() + " " + "Username: " + user.getUsername() + " " + "Password: " + user.getPassword());
		}
		System.out.println("===========================================");
	}
	
	/*using this method the admin can delete an user just by passing the userid
	 * Prompts for userid
	 * Passes the userid to userExist() method
	 * if userExist() method returns true
	 * the user is deleted from the userList()
	 */
	public void deleteUser() throws SQLException{
		List<User> users = null;
		users = usd.getUserList();
		System.out.println("===========================================");
		System.out.println("Enter userID: ");
		int userID = Driver.input.nextInt();
		if(users != null) {
			for(User user: users)
				if((user.getUserID()) == userID) {
					usd.deleteUsers(userID);
					System.out.println("===========================================");
					System.out.println("User with userid:" + userID + " has been deleted");
					System.out.println("===========================================");
				}else {
					System.out.println("===========================================");
					System.out.println("User doesn't exist");
					System.out.println("===========================================");
				}
		}
		
	}
	
	/*admin can use this method to update user info
	 * prompts for user current username
	 * if exists, admin can update username and password for the user
	 * using updateUserInfo() method
	 */
	public void updateUser() throws SQLException{
		List<User> users = null;
		users = usd.getUserList();
		System.out.println("===========================================");
		System.out.println("Enter current username: ");
		System.out.println("===========================================");
		String curUsername = Driver.input.next();
		if(users != null) {
			for(User user: users)
				if(user.getUsername().equals(curUsername)) {
					System.out.println("===========================================");
					System.out.println("        ***Update user credential***       ");
					System.out.println("Enter new username: ");
					String newUsername = Driver.input.next();
					System.out.println("Enter new password: ");
					String newPassword = Driver.input.next();
					usd.updateUserInfo(user,newUsername, newPassword);
					System.out.println("===========================================");
					System.out.println("Username and password are updated for " + 
					user.getFirstName() + " " + user.getLastName());
					System.out.println("===========================================");
				}else {
					System.out.println("===========================================");
					System.out.println("Username doesn't exists");
					System.out.println("===========================================");
				}
		}
		
		
	}
	
}
