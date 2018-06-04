package com.revature.beans;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SuperUser extends Client{
		private String userName;
		private String passWord;
		private int id;
		
	private static List<Account> superAccountList = new ArrayList<Account>();
	
	public SuperUser() throws FileNotFoundException, IOException {
		super();
		Properties prop = new Properties();
		prop.load(new FileReader("SuperUser.properties"));
		this.userName = prop.getProperty("usr");
		this.passWord = prop.getProperty("password");
		this.id = Integer.parseInt(prop.getProperty("id"));
		// TODO Auto-generated constructor stub
	}

	public static List<Account> getSuperAccountList() {
		return superAccountList;
	}

	public static void setSuperAccountList(List<Account> superAccountList) {
		SuperUser.superAccountList = superAccountList;
	}

	@Override
	public void printAccounts() {
		
		for(Account item : this.getSuperAccountList()) {
			System.out.println(item);
		}
		
	}

	
	
	


}
