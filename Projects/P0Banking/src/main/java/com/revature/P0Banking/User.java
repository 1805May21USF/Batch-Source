package com.revature.P0Banking;

import java.io.*;

import java.util.ArrayList;

public class User{
	private static String name;
	//private static int age;
	private static String[] acct_info;
	
	//Get username and password from user
	public static void getInfo() {
		System.out.print("Username: ");
    	String un_login = App.sc.nextLine();
    	System.out.print("Password: ");
    	String pw_login = App.sc.nextLine();
    	acct_info = new String[]{un_login,pw_login};
	}
	
	//Get personal info - name, age from user
	public static void getPersonalInfo() {
		System.out.print("Name: ");
		name = App.sc.nextLine();
		/*System.out.print("Age: ");
		age = App.sc.nextInt();*/
	}
	
	//Read file and check if there is a match of username and password
	//returns a boolean
	public static Partner returnUserNameMatch(String username, ArrayList<?> accts) {
		
		for(int i = 0; i < accts.size(); i++)
		{
			Object account= accts.get(i);
			if(account instanceof Customer 
					&& ((Customer) account).getUsername().equals(username)) {return (Customer)account;}
			if(account instanceof Employee
					&& ((Employee) account).getUsername().equals(username)) {return (Employee)account;}
			if(account instanceof BankAdmin
					&& ((BankAdmin) account).getUsername().equals(username)) {return (BankAdmin)account;}
		}
    	return null;
	}
	
	public static Partner returnLoginMatch(String username, String password, ArrayList<?> accts) {
			
			for(int i = 0; i < accts.size(); i++)
			{
				Object account= accts.get(i);
				if(account instanceof Customer 
						&& ((Customer) account).getUsername().equals(username)
						&& ((Customer) account).getPassword().equals(password)) {return (Customer)account;}
				if(account instanceof Employee
						&& ((Employee) account).getUsername().equals(username)
						&& ((Employee) account).getPassword().equals(password)) {return (Employee)account;}
				if(account instanceof BankAdmin
						&& ((BankAdmin) account).getUsername().equals(username)
						&& ((BankAdmin) account).getPassword().equals(password)) {return (BankAdmin)account;}
			}
	    	return null;
	}
	
	//Deals with generic type safety issues by type casting every object in the ArrayList as a subclass of Account
	public static ArrayList<Partner> convertToPartner (ArrayList<?> accts){
		ArrayList<Partner> newAccts =  new ArrayList<Partner>();
		for(int i = 0; i < accts.size(); i++){
			Object account= accts.get(i);
			if(account instanceof Customer) {newAccts.add((Customer)account);}
			if(account instanceof Employee) {newAccts.add((Employee)account);}
			if(account instanceof BankAdmin) {newAccts.add((BankAdmin)account);}
		}
		return newAccts;
	}
	
	public static ArrayList<?> readFromFile() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(App.file));
		ArrayList<?> accts = (ArrayList<?>)in.readObject();
		in.close();
		return accts;
	}
	
	//Grab any new updates to file then combines old set of accounts with new account and outputs to AccountDatabase.txt
	public static void saveToFile(ArrayList<Partner> newAccts) throws IOException {
		FileOutputStream fileout = new FileOutputStream(App.file);
    	ObjectOutputStream out = new ObjectOutputStream(fileout);
    	out.writeObject(newAccts);
    	out.close();
	}
	
	public static ArrayList<Partner> addToAccounts(String account_type, ArrayList<Partner> accts){
		if(account_type.equals("Customer")){
			accts.add(new Customer(name,acct_info[0],acct_info[1]));
		}
		else if(account_type.equals("Employee")) {
			accts.add(new Employee(name,acct_info[0],acct_info[1]));
		}
		else if(account_type.equals("BankAdmin")) {
			accts.add(new BankAdmin(name,acct_info[0],acct_info[1]));
		}
		return accts;
	}
	
	//Register for an account
	public static ArrayList<Partner> registerAcct(String account_type, String username) throws IOException {
		//Asks for necessary information
		getInfo();
		getPersonalInfo();
		ArrayList<Partner> newAccts = new ArrayList<Partner>();
		//Try to read in to file to check for a duplicate username/password
		try {
			//
    		ArrayList<?> accts = readFromFile();
    		User.returnUserNameMatch(username, accts);
			//If there is no match, user can register
    		if(returnUserNameMatch(acct_info[0],accts)==null) {
    			newAccts.addAll(convertToPartner(accts));
    			newAccts = addToAccounts(account_type,newAccts);
    			//saveToFile(newAccts);
    			System.out.println("You have registered your account.");
    			return newAccts;
    		}
		} catch (EOFException | FileNotFoundException e) {
			//Deals with empty file and missing files
			newAccts = addToAccounts(account_type,newAccts);
			//saveToFile(newAccts);
			System.out.println("You have registered your account.");
			return newAccts;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		System.out.println("Please attempt to register again with a unique username");
		return newAccts;
	}
	
	public static ArrayList<Partner> registerAcct(String account_type) throws IOException {
		//Asks for necessary information
		getInfo();
		getPersonalInfo();
		ArrayList<Partner> newAccts = new ArrayList<Partner>();
		//Try to read in to file to check for a duplicate username/password
		try {
			//
    		ArrayList<?> accts = readFromFile();
			//If there is no match, user can register
    		if(returnUserNameMatch(acct_info[0],accts)==null) {
    			newAccts.addAll(convertToPartner(accts));
    			newAccts = addToAccounts(account_type,newAccts);
    			//saveToFile(newAccts);
    			System.out.println("You have registered your account.");
    			return newAccts;
    		}
		} catch (EOFException | FileNotFoundException e) {
			//Deals with empty file and missing files
			newAccts = addToAccounts(account_type,newAccts);
			//saveToFile(newAccts);
			System.out.println("You have registered your account.");
			return newAccts;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		System.out.println("Please attempt to register again with a unique username");
		return newAccts;
	}
	
	//Login to an Account
	public static ArrayList<Partner> loginAcct() throws FileNotFoundException, IOException, ClassNotFoundException {
		//Clears scanner buffer for further user input
		getInfo();
		ArrayList<Partner> newAccts = new ArrayList<Partner>();
		try {
			ArrayList<?> accts = readFromFile();
			Partner partner = returnLoginMatch(acct_info[0],acct_info[1], accts);
			newAccts = convertToPartner(accts);
			newAccts.remove(partner);
			if(partner==null) {
				System.out.println("Wrong username and password combination. Please try again.");
				return newAccts;
			}
			else {
				System.out.println("\nWelcome "+partner.getName()+"! You have logged in.");
				if(partner instanceof Customer) {
					newAccts = ((Customer)partner).receiveCustomerAction(newAccts,partner);
				}else if(partner instanceof BankAdmin) {
					newAccts = ((BankAdmin)partner).receiveBankAdminActions(newAccts);
				}else if(partner instanceof Employee) {
					newAccts = ((Employee)partner).receiveEmployeeActions(newAccts);
				}
				newAccts.add(partner);
				return newAccts;
			}
		}catch(EOFException e) {
			System.out.println("There is no account with those credentials.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return newAccts;
	}
	
	
}
