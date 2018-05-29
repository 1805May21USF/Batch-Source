package com.revature.test;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Bank {
	
	
	private static final String name = "Bank";
	public static ArrayList<Account> accountList = new ArrayList<Account>();
	public static Scanner in;
	
	
	//Default Constructor
	public Bank() {
	
	}


	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}



	


	public int importAccounts() {
		// TODO Auto-generated method stub
		try {
		while(in.hasNext()) {
			accountList.add(new Account(in.next(),in.nextDouble()));
		}
		}catch(Exception e) {
			System.out.println("what?");
		}
		return accountList.size();
		
	}


	public boolean openFile() {
		boolean fileOpen = false;
		// TODO Auto-generated method stub
		try {
		 in = new Scanner(new File("Accounts.txt"));
		fileOpen = true;
		}
		catch(Exception e) {
			System.out.println("Something went wrong homie! Your Files Not there.");
		}
		
		
		return fileOpen;
	}
	
	

}
