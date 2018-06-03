package com.revature.beans;

import java.sql.SQLException;
import java.util.List;

import com.revature.JDBCBank.App;
import com.revature.exceptions.BadInputException;
import com.revature.implementdao.ImpBankAccountDAO;

public class User {
	private int id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private static ImpBankAccountDAO ibad = new ImpBankAccountDAO();

	/******Constructors************************/
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String firstname, String lastname, String username, String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}
	
	/*********Methods*************************/
	/*
	 * Name: promptUser()
	 * Input:None
	 * Output:None
	 * Description: Provides actions a user can do.
	 */
	public void promptUser() {
		int pick = -1;
		while(pick != 5) {
			try {
				System.out.print("What would you like to do?"
						+ "\n1)View info\n"
						+ "2)Access your accounts\n"
						+ "3)Add a bank account\n"
						+ "4)Delete a bank account\n"
						+ "5)Log Out\n");
				pick = Integer.parseInt(App.sc.nextLine());
				if(pick>5 || pick<1) {
					System.out.println("That was not a valid input.");
					throw new BadInputException();
				}
				else {
					selectUserActions(pick);
				}
			}catch(BadInputException | NumberFormatException | SQLException e) {
				System.out.println("Please try again.");
			}
		}
	}
	
	/*
	 * Name: selectUserActions()
	 * Input:int pick
	 * Output:None
	 * Description: Selects the action a user takes
	 */
	public void selectUserActions(int pick) throws SQLException, BadInputException {
		switch(pick) {
		//view accounts
			case 1:
				this.viewAccounts();
				break;
			//access accounts
			case 2:
				BankAccount acct = this.selectBankAccount();
				acct.promptBankAccountActions();
				break;
			//create account
			case 3:
				this.createBankAccount();
				break;
			//delete account
			case 4:
				this.deleteBankAccount();
				break;
		}
	}
	
	/*
	 * Name: viewAccounts()
	 * Input:None
	 * Output:None
	 * Description: Prints out personal information and account info of user.
	 */
	public void viewAccounts() throws SQLException {
		System.out.println("Name: "+this.getFirstname()+" "+this.getLastname());
		System.out.println("Username: "+this.getUsername());
		System.out.println("Accounts: ");
		List<BankAccount> accts = ibad.getUserBankAccounts(this.getId());
		int i = 1;
		for(BankAccount acct: accts) {
			System.out.println(i+") Account-"+acct.getAccountid()+": $"+String.format("%.2f", acct.getBalance()));
			i++;
		}
	}
	
	/*
	 * Name: createBankAccount
	 * Input:None
	 * Output:None
	 * Description: Adds a bank account to user account
	 */
	public void createBankAccount() throws SQLException {
		ibad.createBankAccount(this.id);
		System.out.println("You have added a bank account.");
	}
	
	/*
	 * Name: deleteBankAccount
	 * Input:None
	 * Output:None
	 * Description: Deletes a bank account from user account
	 */
	public void deleteBankAccount() throws SQLException, NumberFormatException, BadInputException {
		BankAccount acct = this.selectBankAccount();
		if(acct.getBalance() != 0.00f) {
			System.out.println("Bank account still has funds.");
			throw new BadInputException();
		}
		else {
			ibad.deleteBankAccount(acct.getAccountid());
			System.out.println("You deleted the bank account.");
		}
	}
	
	/*
	 * Name: selectBankAccount
	 * Input:None
	 * Output:BankAccount
	 * Description: User is able to select a bank account to access
	 */
	public BankAccount selectBankAccount() throws SQLException, BadInputException {
		System.out.println("Select an account to access: ");
		List<BankAccount> accts = ibad.getUserBankAccounts(this.id);
		int i = 1;
		for(BankAccount acct: accts) {
			System.out.println(i+") Account-"+acct.getAccountid()+": $"+String.format("%.2f", acct.getBalance()));
			i++;
		}
		int pick = Integer.parseInt(App.sc.nextLine());
		if(pick > accts.size() || pick < 0) {
			throw new BadInputException();
		}
		else {
			BankAccount selected = accts.get(pick-1);
			return selected;
		}
	}
	
	/*******Getters and Setter********************/
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username
				+ ", password=" + password + "]";
	}	
}
