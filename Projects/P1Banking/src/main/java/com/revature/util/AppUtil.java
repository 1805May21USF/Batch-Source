package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.revature.JDBCBank.App;
import com.revature.beans.User;
import com.revature.exceptions.NullUserException;
import com.revature.implementdao.ImpUserDAO;

public class AppUtil {

	public AppUtil() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static String[] getCredentials() {
		System.out.print("Username: ");
    	String username = App.sc.nextLine();
    	System.out.print("Password: ");
    	String password = App.sc.nextLine();
    	String[] cred = new String[2];
    	cred[0] = username;
    	cred[1] = password;
    	return cred;
	}
	
	public static User login(String [] cred) throws SQLException, NullUserException, FileNotFoundException, IOException {
		String username = cred[0];
		String password = cred[1];
		ImpUserDAO iud = new ImpUserDAO();
		User usr = iud.getUserByCredentials(username, password);
		if(usr==null) {
			System.out.println("Username or password was not found.");
			throw new NullUserException();
		}
		else{
			return usr;
		}
	}
	
	public static boolean checkSuperUser(String username, String password) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileReader("database.properties"));
		//check if admin first
		if(username.equals(prop.getProperty("superusr")) && password.equals(prop.getProperty("superpass"))) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkForMatch(String username) throws SQLException {
		ImpUserDAO iud = new ImpUserDAO();
		List<User> users = iud.getUserList();
		for(User u: users) {
			if(u.getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}
	public static void register() throws SQLException {
		System.out.print("Username: ");
    	String username = App.sc.nextLine();
    	System.out.print("Password: ");
    	String password = App.sc.nextLine();
    	System.out.print("First Name: ");
		String firstname = App.sc.nextLine();
		System.out.print("Last Name: ");
		String lastname = App.sc.nextLine();
		
		ImpUserDAO iud = new ImpUserDAO();
		if(checkForMatch(username)) {
			System.out.println("The username has been taken. Please try another username.");
		}
		else {
			iud.insertUser(firstname, lastname, username, password);
			System.out.println("The user account has been created");
		}
	}
}
