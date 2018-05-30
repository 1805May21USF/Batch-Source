package com.revature.banking;

import java.util.ArrayList;
import java.util.HashSet;

public class User {
	private static HashSet<String> loggedCustomers = new HashSet<String>();
	private static HashSet<String> customers = new HashSet<String>();
	
	public static HashSet<String> getLoggedUsers() {
		return loggedCustomers;
	}
	public void setLoggedUsers(HashSet<String> loggedInUsers) {
		this.loggedCustomers = loggedInUsers;
	}
	public static void addLoggedUser(String id) {
		loggedCustomers.add(id);
	}
	public static HashSet<String> getLoggedInUsers() {
		return customers;
	}
	public void setLoggedInUsers(HashSet<String> loggedInUsers) {
		this.customers = customers;
	}
	public static void addLoggedInUser(String id) {
		customers.add(id);
	}
}
