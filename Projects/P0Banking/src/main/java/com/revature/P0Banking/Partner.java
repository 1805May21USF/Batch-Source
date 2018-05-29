package com.revature.P0Banking;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Partner implements Serializable{
	//Every bank partner has a username and password
	private static final long serialVersionUID = 1L;
	protected ArrayList<Account> accounts = new ArrayList<Account>();
	private String username;
	private String password;
	private String name;
	private int age;
	
	
	public Partner(String username, String password, String name, int age) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.age = age;
	}
	public Partner(String username, String password, String name) {
		this.username = username;
		this.password = password;
		this.name = name;
	}
/*
 * Name: findFlaggedJoints, getFlaggedJoints
 * Inputs: ArrayList<Partner> newAccts
 * Outputs: int
 * Description: Used to eventually create a way to display all flagged for approval joint accounts for 
 * bank admin/employee to easily approve or deny.
 */
	/*private static int findFlaggedJoints(ArrayList<Partner> newAccts) {
		int i = 1;
		System.out.println("Select account: ");
		for(Partner obj : newAccts) {
			if((obj instanceof Customer) && ((Customer) obj).isAppliedForJoint()) {
				System.out.println(i+") "+obj.getUsername());
				i++;
			}
		}
		return i;
	}
	
	private static int getFlaggedJoints(ArrayList<Partner> newAccts) {
		int i = 1;
		System.out.println("Select account: ");
		for(Partner obj : newAccts) {
			if((obj instanceof Customer) && ((Customer) obj).isAppliedForJoint()) {
				System.out.println(i+") "+obj.getUsername());
				i++;
			}
		}
		return i;
	}*/
//****************************************************************************************
	
	/*
	 * Name: jointAccountActions
	 * Input:None
	 * Output:int
	 * Description: Class/Subclass only method to access jointAccountActions - mainly for Employee/BankAdmin
	 * Note: Has code for eventual functionality
	 */
	protected int jointAccountActions() {
		//Displays flagged accounts - maybe some other time
		/*int sizeFlagged,pick;
		while(true) {
			try {
					sizeFlagged = findFlaggedJoints(newAccts);
					pick = App.sc.nextInt();
					if(pick > sizeFlagged+1 || pick < 1) {
						throw new BadInputException();
					}
					
			}catch(Exception e) {
				System.out.println("Please select a valid account.");
			}
		}*/
		System.out.println("Customer requests a joint account.\n1)Approve\n2)Deny");
		int pick = App.sc.nextInt();
		return pick;
	}
	
	/*
	 * Name: accessAccounts
	 * Input:ArrayList<Partner> accounts
	 * Output:ArrayList<Partner>
	 * Description: Class/Subclass only access method that allows users to receive an interface that lets them choose an account to access
	 * bank admin, employee only.
	 */
	protected ArrayList<Partner> accessAccounts(ArrayList<Partner> newAccts) {
		System.out.println("Select an account to access: ");
		printListOfAccounts(accounts);
		int pick = App.sc.nextInt();
		if(pick > accounts.size() || pick < 0) {
			System.out.println("Please pick a valid account.");
		}
		else {
			Account account = accounts.get(pick-1);
			try {
				newAccts = account.promptAccountActions(this.getUsername(),newAccts);
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return newAccts;
	}
	
	/*
	 * Name: printListOfAccounts
	 * Input:ArrayList<Partner> accounts
	 * Output:None
	 * Description: Class/Subclass access that prints a list of accounts give an ArrayList of accounts
	 */
	protected void printListOfAccounts(ArrayList<Account> accts) {
		for(int i=0; i<accts.size();i++) {
			System.out.println((i+1)+") "+accts.get(i).getName()+accts.get(i).getId());
		}
	}
	
	/*
	 * Getters and Setters
	 */
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
