package com.revature.project0;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Bank implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3066544662705509838L;
	public static final String dataFile="data.bin";
	public transient User currentUser = User.defaultUser;
	final static Logger logger = Logger.getLogger(Bank.class);

	

	public static void main(String[] args) {
		@SuppressWarnings("resource")
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
		System.out.print("\n$" + b.currentUser.getBalance()+ ":" + b.currentUser.getLoginInfo().keySet()+"~");

		String command = sc.nextLine().trim();
		switch (command) {
			case "login":
				System.out.println("Please type the username:");
				
				String username = sc.nextLine().trim();
				System.out.println("Please type your password:");
				String password = sc.nextLine();
			
			try {
				if (User.getUser(username)== null || !User.getUser(username).isActive()) {
					System.err.println("Username not valid!");
					continue;
				}
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
					
			try {
				if(User.getUser(username).getLoginInfo().get(username).equals(password)) {
					b.currentUser = User.getUser(username);
				}else {
					System.err.println("Password is not valid!");
					continue;
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
				b.currentUser.getLoginInfo().put(username, password);
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
				if (b.currentUser.isAdmin()) {
				System.out.println("Please enter the source account:");
				username = sc.nextLine().trim();
				}
						
				if (username == null ||username.length() == 0) {
					username = (String) b.currentUser.getLoginInfo().keySet().toArray()[0];
				}
				System.out.println("Please type the destination account:");
			User src = null;
			User dest = null;
			try {
				src = User.getUser(username);
				dest = User.getUser(sc.nextLine().trim());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
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
				b.currentUser.setBalance(b.currentUser.getBalance() + ammount);
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
				b.currentUser.setBalance(b.currentUser.getBalance() - ammount);
				break;
			case "approve":
				if(!b.currentUser.isAdmin()) {
					System.err.println("Error! You don't have permission to do this.");
				}
				System.out.println("Please type the username:");

			User user = null;
			try {
				user = User.getUser(sc.nextLine().trim());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				if (user == null) {
					System.err.println("Error! Account not found.");
					break;
				}
				user.setActive(true);
				
				break;
			case "info":
			case "help":
			case "?":
			case "status":
				System.out.println("Hello, " + b.currentUser.getLoginInfo().keySet() + ". Your admin status is " + b.currentUser.isAdmin() );
				System.out.println("Your commands are: login create addJointUser kill transfer withdraw deposit exitAndCommit");
				if (b.currentUser.isAdmin()) {
					System.out.println("Your admin commands are: approve\nUsers are:");
					for (User u : User.getUsers()) {
						System.out.println(u.toString());
					}
				}
				break;
				
				
			case "loadDebugPreset":
				logins = new HashMap<>();
				logins.put("admin","");
				b.addUser(logins, true, true);
			try {
				User.getUser("admin").setActive(true);
		
				logins = new HashMap<>();
				logins.put("potato","");
				b.addUser(logins, false, false);
				User.getUser("potato").setActive(true);

				logins = new HashMap<>();
				logins.put("carrot","");
				b.addUser(logins, false, false);
				User.getUser("carrot").setActive(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		/*
			for (String name : logins.keySet()) {
			if(User.getUser(name) != null) {
				//error, name already taken
				logger.warn("Oh dude! " + currentUser.getLoginInfo().keySet() + " just tried to make a user named " + name + " when that is someone else's name brah.");
				return false;
			}
		}
		*/
		}
		//make the new user! Admins make users instantly approved!
		User newUser = null;
		try {
			newUser = new User(admin, logins,currentUser.isAdmin(), 0.0);
		} catch (SQLException | NotPermittedException e) {
			logger.warn("Oh dude! " + currentUser.getLoginInfo().keySet() + " just tried to make a user when that is someone else's name brah.");
			//e.printStackTrace();
			return false;
		}
	
		logger.info(currentUser.getLoginInfo().keySet() + " just made the user " + newUser.getLoginInfo().keySet() + ". Radical!");
		return true;
		
		
	}
	public boolean deleteUser(String name){
		if(!currentUser.isAdmin() && !currentUser.getLoginInfo().containsKey(name)) {
			logger.warn("Dude, " + currentUser.getLoginInfo().keySet() + " just tottally tried to kill " + name + "'s account without being an admin. Not cool man.");
			return false;
		}
		try {
			if(!(User.getUser(name) == null)) {
			//error, name not taken
				logger.warn("Dude, " + currentUser.getLoginInfo().keySet() + " just tottally tried to kill " + name + " when that is not a valid name. You ok brah?");

				return false;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}

		User toRemove = null;
		try {
			toRemove = User.getUser(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		for (String alias  : toRemove.getLoginInfo().keySet()) {
			logger.info(currentUser.getLoginInfo().keySet() + " is killing " + alias + ". Man what is the world comeing to brah?");
		}
		toRemove.setActive(false);

		return true;
		
	}
	public boolean transfer(User src, User dest, double ammount){
		/* TODO redo!
		if (!(src == currentUser || currentUser.isAdmin())) {
			logger.warn("Dude, " + currentUser.getLoginInfo().keySet() + " just tottally tried to move " + ammount + " from "+ src.getLoginInfo().keySet() + " to " + dest.getLoginInfo().keySet() + " But they arn't, like, in charge or anything.");
			return false;
		}
		if(!(src.getBalance()-ammount >=0.0) ) {
			logger.warn("Dude, " + currentUser.getLoginInfo().keySet() + " just tottally tried to move " + ammount + " from "+ src.getLoginInfo().keySet() + " to " + dest.getLoginInfo().keySet() + " But they don't have the clams, brah.");

			return false;
		}
		if (!dest.isActive() && !src.isActive()) {
			logger.warn("Dude, " + currentUser.getLoginInfo().keySet() + " just tottally tried to move " + ammount + " from "+ src.getLoginInfo().keySet() + " to " + dest.getLoginInfo().keySet() + " But someone isn't active... DUDE!");
			
			return false;
		}
		if (ammount<=0) {
			logger.warn("Dude, " + currentUser.getLoginInfo().keySet() + " just tottally tried to move " + ammount + " from "+ src.getLoginInfo().keySet() + " to " + dest.getLoginInfo().keySet() + ". Ya gotta give valid numbers man!");
			
			return false;
		}
		/*/
		src.setBalance(src.getBalance() - ammount);
		dest.setBalance(dest.getBalance() + ammount);
		logger.info("Dude, " + currentUser.getLoginInfo().keySet() + " just moved " + ammount + " from "+ src.getLoginInfo().keySet() + " to " + dest.getLoginInfo().keySet() + ". That's economy brah, green changing hands.");
		return true;
	}

}
