package com.revature.driver;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.DAOImple.*;
import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.util.Menu;
import com.revature.util.UserException;

public class DriverTest {
	
	static Logger logger = Logger.getLogger(DriverTest.class);

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		//UserDAOImple udi = new UserDAOImple();
		//AccountDAOImple adi = new AccountDAOImple();
		menu1();
	}
	
	
	
	
	public static void menu1() {
		System.out.println("Welcome to the Bank\n1.Login\n2.New User");
		int input = sc.nextInt();
		switch(input) {
		//takes user to login menu
		case 1 :
			menuLogin();
			break;
		//takes the user to create user screen
		case 2 :
			menuNewUser();
			break;
		default:
			System.out.println("Please enter a valid number");
			menu1();
		}
	}
	public static void menuLogin() {
		System.out.println("Login Screen\nEnter your username");
		String userName = sc.next();
		System.out.println("Enter your password");
		String password = sc.next();
		UserDAOImple udi = new UserDAOImple();
			if(udi.login(userName, password)) {
				System.out.println("login successful");
				menuUser(userName);
			}else {
				System.out.println("Please enter valid username and password");
				menuLogin();
			}
	}
	public static void menuNewUser() {
		System.out.println("Create New User\nEnter your new username");
		String username = sc.next();
		System.out.println("Enter your password");
		String password = sc.next();
		UserDAOImple udi = new UserDAOImple();
			if(!udi.isUserName(username)) {
				udi.createUser(username, password);
				System.out.println("User Created");
				menuUser(username);
			}else {
				System.out.println("Username is taken");
				menuNewUser();
			}
	}
	public static void menuUser(String username) {
		UserDAOImple udi = new UserDAOImple();
		int userID = -1;
			userID = udi.getUserID(username);
		AccountDAOImple adi = new AccountDAOImple();
		if(userID==-1) {menuSuper();}
		List<Account> accounts = new ArrayList<Account>();
			accounts = adi.getUserAccountsList(userID);
		System.out.println("1.Create Account\n"
				+ "2.Delete Account\n"
				+ "3.Deposit\n"
				+ "4.Withdraw\n"
				+ "5.Accounts Overview\n"
				+ "6.Logout");
		int input = sc.nextInt();
		switch(input) {
			case 1 :
				//userid and balance
				adi.createAccount(userID, 0);
				System.out.println("account created");
				menuUser(username);
				break;
			case 2 :
				System.out.println("Enter the accountID of the account to delete");
				int accountID3=sc.nextInt();
				for(Account b:accounts) {
					if(b.getAccountID()==accountID3) {
						if(b.getBalance()==0) {
							System.out.println("deleting account");
								adi.deleteAccount(accountID3);
								menuUser(username);
						}else {
							System.out.println("Account balance must be 0 to delete");
							menuUser(username);
						}
					}
				}
				System.out.println("Account number not valid, no action taken");
				menuUser(username);
				break;
			case 3 :
				System.out.println("Enter the accountID");
				int accountID = sc.nextInt();
				System.out.println("Enter the amount to deposit");
				float depositAmount = sc.nextFloat();
			try {
				adi.deposit(accountID, depositAmount,accounts);
			} catch (UserException e1) {
				System.out.println(e1.getMessage());
				menuUser(username);
			}
				System.out.println("You successfully made a deposit");
				menuUser(username);
				break;
			case 4 :
				System.out.println("Enter the accountID");
				int accountID2 = sc.nextInt();
				System.out.println("Enter the amount to withdraw");
				float withdraw = sc.nextFloat();
				
				for(Account a:accounts) {
					if(a.getAccountID()==accountID2) {
						try {
							adi.withdraw(accountID2, withdraw,a.getBalance());
							System.out.println("withdraw successfull");
							menuUser(username);
						} catch (UserException e) {
							System.out.println(e.getMessage());
							menuUser(username);
						}
					}
				}
				
				//withdraw: withdraw(accountID2,withdraw,List accounts
				System.out.println("No account with that ID was found");
				menuUser(username);
				break;
			case 5 :
				System.out.println("Accounts Overview\n"+accounts);
				System.out.println("Enter any value and press enter to constinue");
				sc.next();
				menuUser(username);
				break;
			case 6 :
				menu1();
				break;
			default:
				System.out.println("Please enter a valid option");
				menuUser(username);
				break;
		}
	}
	
	public boolean withdrawMoney(AccountDAOImple adi,int accountID2,float withdraw,List<Account> accounts) throws UserException {
		for(Account a:accounts) {
			if(a.getAccountID()==accountID2) {
				try {
					adi.withdraw(accountID2, withdraw,a.getBalance());
				} catch (UserException e) {
					System.out.println(e.getMessage());
					//menuUser(username);
				}
			}
		}
		throw new UserException("No such account exist for that user");
	}
	public static void menuSuper() {
		UserDAOImple udi = new UserDAOImple();
		List<User> u =udi.getUserList();
		System.out.println("1.User overview\n2.Create User\n3.delete user\n4.Logout");
		int temp = sc.nextInt();
		switch(temp) {
			case 1 :
				System.out.println(u);
				menuSuper();
				break;
			case 2 :
				System.out.println("Create New User\nEnter your new username");
				String username = sc.next();
				System.out.println("Enter your password");
				String password = sc.next();
					if(!udi.isUserName(username)) {
						udi.createUser(username, password);
						System.out.println("User Created");
						menuSuper();
					}else {
						System.out.println("Username is taken");
						menuSuper();
					}
				break;
			case 3 :
				System.out.println("Enter userID to delete");
				int UserID = sc.nextInt();
				udi.delete(UserID);
				menuSuper();
				//udi.
				break;
			case 4 :
				menu1();
			default:
				System.out.println("please enter valid input");
				menuSuper();
				break;
		}
	}
	
	}


