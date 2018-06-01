package com.revature.project0;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Bank implements Serializable {
	public static final String dataFile="data.bin";
	public transient User currentUser = User.defaultUser;
	final static Logger logger = Logger.getLogger(Bank.class);

	
	public HashMap<String,User> users = new HashMap<String, User>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Bank b = new Bank();
		
		if (Files.exists(Paths.get(dataFile))) {

		  try
	        {   
	            // Reading the object from a file
	            FileInputStream file = new FileInputStream(dataFile);
	            ObjectInputStream in = new ObjectInputStream(file);
	             
	            // Method for deserialization of object
	            b = (Bank)in.readObject();
	             
	            in.close();
	            file.close();
	  	        }
	         
	        catch(IOException ex)
	        {
	            System.out.println("IOException is caught");
	        }
	         
	        catch(ClassNotFoundException ex)
	        {
	            System.out.println("ClassNotFoundException is caught");
	        }
		}
		if (b.currentUser== null) {
			b.currentUser= User.defaultUser;
		}

	    
		System.out.println("\nWelcome to The National Bank of Hell.\nYour soul has been logged.\n\n		Please login with command login, or type help for a list of commands");

		while (true) {
			//Display user prompt
		System.out.print("\n$" + b.currentUser.balance+ ":" + b.currentUser.loginInfo.keySet()+"~");

		String command = sc.nextLine().trim();
		switch (command) {
			case "login":
				System.out.println("Please type the username:");
				
				String username = sc.nextLine().trim();
				System.out.println("Please type your password:");
				String password = sc.nextLine();
			
				if (b.users.get(username)== null || !b.users.get(username).active) {
					System.err.println("Username not valid!");
					continue;
				}
					
					if(b.users.get(username).loginInfo.get(username).equals(password)) {
						b.currentUser = b.users.get(username);
					}else {
						System.err.println("Password is not valid!");
						continue;
					}		
				break;	
			case "create":
				System.out.println("Please type the username:");

				HashMap<String, String> logins = new HashMap<String, String>();
				username = sc.nextLine().trim();
				System.out.println("Please type your password:");
				password = sc.nextLine();
				logins.put(username, password);
				if (!b.addUser(logins, false)) {
					System.err.println("Error! That account may already exsist.");
				}
				break;
			case "addJointUser":
				System.out.println("Please type the new username for this account:");

				username = sc.nextLine().trim();
				System.out.println("Please type the Joint User's password:");
				password = sc.nextLine();
				b.currentUser.loginInfo.put(username, password);
				break;
			case "kill":
				System.out.println("Please type the username:");

				username = sc.nextLine().trim();
				if (!b.deleteUser(username)) {
					System.err.println("Error! You may not have admin access, or that account may not exsist.");
				}
				break;
			case "transfer":
				username = null;
				double ammount = 0.0;
				//only offer the user name option if we are an admin
				if (b.currentUser.admin) {
				System.out.println("Please enter the source account:");
				username = sc.nextLine().trim();
				}
						
				if (username == null ||username.length() == 0) {
					username = (String) b.currentUser.loginInfo.keySet().toArray()[0];
				}
				System.out.println("Please type the destination account:");
				User src = b.users.get(username); 
				User dest = b.users.get(sc.nextLine().trim());
				System.out.println("Please type the ammount:");

				try {
					ammount = sc.nextDouble();
					sc.skip("\\s");

				}catch(InputMismatchException e) {
					
				}
			
				if (src== null || dest == null) {
					System.err.println("Error! Account not found.");
					break;
				}
				if (!b.transfer(src,dest, ammount)) {
					System.err.println("Error! Transfer failed. You may not have permission to do that, that account may not exsist, or you may be out of funds.");
					break;
				}
				break;
			case "deposit":
				System.out.println("Please type the ammount:");

				ammount = 0.0;
				try {
					ammount = sc.nextDouble();
					sc.skip("\\s");
				}catch(InputMismatchException e) {
					
				}
				b.currentUser.balance += ammount;
				break;
			case "withdraw":
				System.out.println("Please type the ammount:");

				ammount = 0.0;
					ammount = sc.nextDouble();
					sc.skip("\\s");
					try {
						ammount = sc.nextDouble();
					}catch(InputMismatchException e) {
						
					}
				b.currentUser.balance -= ammount;
				break;
			case "approve":
				if(!b.currentUser.admin) {
					System.err.println("Error! You don't have permission to do this.");
				}
				System.out.println("Please type the username:");

				User user = b.users.get(sc.nextLine().trim());
				if (user == null) {
					System.err.println("Error! Account not found.");
					break;
				}
				user.active=true;
				
				break;
			case "info":
			case "help":
			case "?":
			case "status":
				System.out.println("Hello, " + b.currentUser.loginInfo.keySet() + ". Your admin status is " + b.currentUser.admin );
				System.out.println("Your commands are: login create addJointUser kill transfer withdraw deposit exitAndCommit");
				if (b.currentUser.admin) {
					System.out.println("Your admin commands are: approve\nUsers are:");
					for (User u : b.users.values()) {
						System.out.println(u.toString());
					}
				}
				break;
				
				
			case "loadDebugPreset":
				logins = new HashMap<>();
				logins.put("admin","");
				b.addUser(logins, true, true);
				b.users.get("admin").active=true;
				logins = new HashMap<>();
				logins.put("potato","");
				b.addUser(logins, false, false);
				b.users.get("potato").active=true;

				logins = new HashMap<>();
				logins.put("carrot","");
				b.addUser(logins, false, false);
				b.users.get("carrot").active=true;

				break;
			case "exit":
				 try
			        {   
			            //Saving of object in a file
			            FileOutputStream file = new FileOutputStream(dataFile);
			            ObjectOutputStream out = new ObjectOutputStream(file);
			             
			            // Method for serialization of object
			            out.writeObject(b);
			             
			            out.close();
			            file.close();
			             
			            System.out.println("Object has been serialized");
			 
			        }
			         
			        catch(IOException ex)
			        {
			            System.out.println("IOException caused us to fail to write the file to the disk");
			        }
				 	System.exit(0);
			 
				break;
			default:
				System.err.println("Command is not valid!");
				break;
		}
		}
	
	
	}

	public boolean addUser(HashMap<String, String> logins,boolean admin){
		return addUser(logins, admin, false);
	}
		public boolean addUser(HashMap<String, String> logins,boolean admin, boolean forceOverride){
		if(!forceOverride) {
		for (String name : logins.keySet()) {
			if(users.containsKey(name)) {
				//error, name already taken
				logger.warn("Oh dude! " + currentUser.loginInfo.keySet() + " just tried to make a user named " + name + " when that is someone else's name brah.");
				return false;
			}
		}
		}
		//make the new user! Admins make users instantly approved!
		User newUser = new User(admin, logins,currentUser.admin, 0.0);
		for (String name : logins.keySet()) {
			users.put(name,newUser);
		}
		logger.info(currentUser.loginInfo.keySet() + " just made the user " + newUser.loginInfo.keySet() + ". Radical!");
		return true;
		
		
	}
	public boolean deleteUser(String name){
		if(!currentUser.admin && !currentUser.loginInfo.containsKey(name)) {
			logger.warn("Dude, " + currentUser.loginInfo.keySet() + " just tottally tried to kill " + name + "'s account without being an admin. Not cool man.");
			return false;
		}
		if(!users.containsKey(name)) {
		//error, name not taken
			logger.warn("Dude, " + currentUser.loginInfo.keySet() + " just tottally tried to kill " + name + " when that is not a valid name. You ok brah?");

			return false;
		}
		User toRemove = users.get(name);
		for (String alias  : toRemove.loginInfo.keySet()) {
			logger.info(currentUser.loginInfo.keySet() + " is killing " + name + ". Man what is the world comeing to brah?");
			users.remove(alias);
		}
		return true;
		
	}
	public boolean transfer(User src, User dest, double ammount){
		if (!(src == currentUser || currentUser.admin)) {
			logger.warn("Dude, " + currentUser.loginInfo.keySet() + " just tottally tried to move " + ammount + " from "+ src.loginInfo.keySet() + " to " + dest.loginInfo.keySet() + " But they arn't, like, in charge or anything.");
			return false;
		}
		if(!(src.balance-ammount >=0.0) ) {
			logger.warn("Dude, " + currentUser.loginInfo.keySet() + " just tottally tried to move " + ammount + " from "+ src.loginInfo.keySet() + " to " + dest.loginInfo.keySet() + " But they don't have the clams, brah.");

			return false;
		}
		if (!dest.active && !src.active) {
			logger.warn("Dude, " + currentUser.loginInfo.keySet() + " just tottally tried to move " + ammount + " from "+ src.loginInfo.keySet() + " to " + dest.loginInfo.keySet() + " But someone isn't active... DUDE!");
			
			return false;
		}
		if (ammount<=0) {
			logger.warn("Dude, " + currentUser.loginInfo.keySet() + " just tottally tried to move " + ammount + " from "+ src.loginInfo.keySet() + " to " + dest.loginInfo.keySet() + ". Ya gotta give valid numbers man!");
			
			return false;
		}
		src.balance = src.balance - ammount;
		dest.balance += ammount;
		logger.info("Dude, " + currentUser.loginInfo.keySet() + " just moved " + ammount + " from "+ src.loginInfo.keySet() + " to " + dest.loginInfo.keySet() + ". That's economy brah, green changing hands.");
		return true;
	}

}
