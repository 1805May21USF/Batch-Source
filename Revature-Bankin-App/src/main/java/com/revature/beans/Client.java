package com.revature.beans;

import java.util.ArrayList;
import java.util.List;

public class Client {
	
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private int clientID;
	private List<Account> accountList = new ArrayList<Account>();
	

	public Client(int clientID, String userName, String password, String firstName, String lastName) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.clientID = clientID;
	}

	public Client() {
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}
	
	
	//get the corresponding account that the user requested to interact with
		Account selectAccount(int option) {
			Account clientAccount = null;
			
			for( Account acc : getAccountList()) {
				if(acc.getAccountNumber() == option) {
					clientAccount = acc;
					break;
				}
			}
			return clientAccount;
		}
		
		public void printAccounts() {
			
			for(Account item : getAccountList()) {
				System.out.println(item);
			}
			
		}
		
		public void removeAccountFromList(Account account) {
			for(Account acc : this.getAccountList()) {
				if(acc.getAccountNumber() == account.getAccountNumber()) {
					this.getAccountList().remove(acc);
					break;
				}
			}
		}
}
