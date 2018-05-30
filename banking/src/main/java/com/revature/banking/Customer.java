package com.revature.banking;

import java.util.ArrayList;
import java.util.HashSet;

public class Customer extends User {
	private String name;
	private String username;
	private String passwd;
	private String phonen;
	private int permissions;
	//private boolean loggedIn;
	private String id;
	private HashSet<String> accounts;
	//private ArrayList<String> accoutNames;
	private static int idTracker = 0;
	
	Customer(){
		
	}
	Customer(String name, String username, String passwd, String phonen){
		this(name, username, passwd, phonen, idGenerate());
		//String newID = idGenerate();
	}
	Customer(String name, String username, String passwd, String phonen, String id){
		this.setName(name);
		this.setUsername(username);
		this.setPasswd(passwd);
		this.setPhonen(phonen);
		//this.setLoggedIn(true);
		this.setId(id);
		User.addLoggedUser(id);
		this.setAccounts(new HashSet<String>());
	}
	
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public String getPhonen() {
		return phonen;
	}


	public void setPhonen(String phonen) {
		this.phonen = phonen;
	}


	public int getPermissions() {
		return permissions;
	}


	public void setPermissions(int permissions) {
		this.permissions = permissions;
	}


	/*public boolean isLoggedIn() {
		return loggedIn;
	}


	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
*/

	public HashSet<String> getAccounts() {
		return accounts;
	}
	public void setAccounts(HashSet<String> accounts) {
		this.accounts = accounts;
	}
	public void addAccounts(String id) {
		this.accounts.add(id);
		/*Account newAcct= new Account()
		this.getAccounts().add(newAcct.getAccountId())*/
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
/*	public ArrayList<String> getAccoutNames() {
		return accoutNames;
	}
	public void setAccoutNames(ArrayList<String> accoutNames) {
		this.accoutNames = accoutNames;
	}*/
	public static String idGenerate() {
		idTracker++;
		String formatted = String.format("%03d", idTracker);
		String id = "81020"+formatted;
		return id; 
	}
	
	
}
