package com.revature.P0Banking;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.*;

import java.util.ArrayList;
import java.util.Scanner;

public class User{
	private static String name;
	private static int age;
	private static String[] acct_info;
	private static File file = new File("AccountDatabase.txt");
	private static Scanner sc = new Scanner(System.in);
	
	//Get username and password from user
	public static void getInfo() {
		System.out.print("Username: ");
    	String un_login = sc.nextLine();
    	System.out.print("Password: ");
    	String pw_login = sc.nextLine();
    	System.out.print("Name: ");
		name = sc.nextLine();
		System.out.print("Age: ");
		age = sc.nextInt();
    	acct_info = new String[]{un_login,pw_login};
	}
	
	//Read file and check if there is a match of username and password
	//returns a boolean
	public boolean checkMatch(String username, String password, ArrayList<?> accts) {
		
		for(int i = 0; i < accts.size(); i++)
		{
			Object account= accts.get(i);
			if(account instanceof Customer 
					&& ((Customer) account).getUsername().equals(username) 
					&& ((Customer) account).getPassword().equals(password)) {
				return true;}
			if(account instanceof Employee
					&& ((Employee) account).getUsername().equals(username) 
					&& ((Employee) account).getPassword().equals(password)) {return true;}
			if(account instanceof BankAdmin
					&& ((BankAdmin) account).getUsername().equals(username) 
					&& ((BankAdmin) account).getPassword().equals(password)) {return true;}
		}
    	return false;
	}
	
	//Register for an account
	public boolean registerAcct(String account_type) throws IOException {
		getInfo();
		try {
			//
    		ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
			ArrayList<?> accts =  (ArrayList<?>)in.readObject();
    		if(!checkMatch(acct_info[0],acct_info[1],accts)) {
				if(accts.get(0) instanceof Customer){
					((ArrayList<Customer>)accts).add(new Customer(name,age,acct_info[0],acct_info[1]));
				}
				/*if(accts.get(0) instanceof Employee) {
					
				}
				if(accts.get(0) instanceof BankAdmin) {
					
				}*/
				FileOutputStream fileout = new FileOutputStream(file);
		    	ObjectOutputStream out = new ObjectOutputStream(fileout);
		    	out.writeObject(accts);
		    	out.close();
		    	return true;
    		}
    		in.close();
		} catch (EOFException | FileNotFoundException e) {
			//Deals with empty file - maybe missing file too
			ArrayList<Account> new_acct = new ArrayList<Account>();
			new_acct.add(new Customer(name,age,acct_info[0],acct_info[1]));
				FileOutputStream fileout = new FileOutputStream(file);
		    	ObjectOutputStream out = new ObjectOutputStream(fileout);
		    	out.writeObject(new_acct);
		    	out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean loginAcct(String account_type) throws FileNotFoundException, IOException, ClassNotFoundException {
		//String[] info = getInfo();
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
		ArrayList<Customer> new_accts =  (ArrayList<Customer>)in.readObject();
		System.out.println(new_accts.size());
		for(Customer o: new_accts)
		{
			System.out.println(o.getName());
		}
		in.close();
		return false;
	}
	
	
}
