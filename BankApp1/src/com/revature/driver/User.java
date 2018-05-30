package com.revature.driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class User implements Serializable {
	
	private static final String userFile = "users.txt";
	public static ArrayList<User> userList = new ArrayList<User>();

	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	
	public User() {
		
	}
	
	public User(String username, String password, String firstName, String lastName, String email) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String toString() {
		return "Username: " + username +
				"\nPassword: " + password +
				"\nFirst Name: " + firstName +
				"\nLast Name: " + lastName +
				"\nEmail: " + email;
	}
	
	public void login() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Existing User Login");
		System.out.print("Username: ");
		String user = sc.nextLine();
		System.out.print("Password: ");
		String pass = sc.nextLine();
		
		readUserFile();
		boolean usernameFound = checkUsernames(user);
		if(usernameFound) {
			System.out.println("Username found!");
			boolean passwordFound = checkPasswords(pass);
			if(passwordFound) {
				System.out.println("Password matched!");
			} else {
				System.out.println("Password incorrect!");
			}
		} else {
			System.out.println("Username not found!");
		}
	}
	
	public void newUserLogin() {
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
		User newUser = new User(user, pass, first, last, emailAddress);
		//System.out.println(newUser.toString());
		userList.add(newUser);
		writeUserFile();
	}
	
	public void writeUserFile() {
		try {
			ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(userFile, true));
			objectOut.writeObject(userList);
			objectOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readUserFile() {
		ObjectInputStream objectIn;
		boolean cont = true;
		try {
			objectIn = new ObjectInputStream(new FileInputStream(userFile));
			userList = (ArrayList<User>) objectIn.readObject();
			objectIn.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public boolean checkUsernames(String username) {
		readUserFile();
		for(int i=0; i<userList.size(); i++) {
			String user = userList.get(i).getUsername();
			if(username == user) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkPasswords(String password) {
		readUserFile();
		for(int i=0; i<userList.size(); i++) {
			String pass = userList.get(i).getPassword();
			if(password == pass) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkEmails(String email) {
		readUserFile();
		for(int i=0; i<userList.size(); i++) {
			String addr = userList.get(i).getUsername();
			if(email == addr) {
				return true;
			}
		}
		return false;
	}
	
	public void displayAllUsers() {
		readUserFile();
		System.out.println("User List Size: " + userList.size());
		for(int i=0; i<userList.size(); i++) {
			User u1 = userList.get(i);
			System.out.println(u1.toString());
		}
	}
}
