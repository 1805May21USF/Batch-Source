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

public class DriverTest {
	
	static Logger logger = Logger.getLogger(DriverTest.class);

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		//UserDAOImple udi = new UserDAOImple();
		//AccountDAOImple adi = new AccountDAOImple();
		//SuperHeroDAOImpl shdi = new SuperHeroDAOImpl();
		menu1();
	}
	public static void menu1() {
		System.out.println("1.Login\n2.New User");
		int input = sc.nextInt();
		switch(input) {
		case 1 :
			menuLogin();
			break;
		case 2 :
			menuNewUser();
			break;
		case 3 :
			menuSuper();
		default:
			System.out.println("Please enter a valid number");
			menu1();
		}
	}
	public static void menuLogin() {
		System.out.println("Enter your username");
		String userName = sc.next();
		System.out.println("Enter your password");
		String password = sc.next();
		UserDAOImple udi = new UserDAOImple();
		try {
			if(udi.login(userName, password)) {
				menuUser(userName);
			}else {
				System.out.println("Please enter valid username and password");
				menuLogin();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//todo finish
	}
	public static void menuNewUser() {
		System.out.println("Enter your new username");
		String username = sc.next();
		System.out.println("Enter your password");
		String password = sc.next();
		UserDAOImple udi = new UserDAOImple();
		try {
			if(!udi.isUserName(username)) {
				udi.createUser(username, password);
				System.out.println("User Created");
				menuUser(username);
			}else {
				System.out.println("Username is taken");
				menuNewUser();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public static void menuUser(String username) {
		UserDAOImple udi = new UserDAOImple();
		int userID = 0;
		try {
			userID = udi.getUserID(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AccountDAOImple adi = new AccountDAOImple();
		List<Account> accounts = new ArrayList<Account>();
		try {
			accounts = adi.getUserAccountsList(userID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			try {
				adi.createAccount(userID, 0);
				System.out.println("account created");
				menuUser(username);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
				break;
			case 2 :
				System.out.println("Enter the accountID of the account to delete");
				int accountID3=sc.nextInt();
				for(Account b:accounts) {
					if(b.getAccountID()==accountID3) {
						if(b.getBalance()==0) {
							System.out.println("deleting account");
							try {
								adi.deleteAccount(accountID3);
								menuUser(username);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}else {
							System.out.println("Account balance must be 0");
							menuUser(username);
						}
					}
				}
				break;
			case 3 :
				System.out.println("Enter the accountID");
				int accountID = sc.nextInt();
				System.out.println("Enter the amount to deposit");
				float depositAmount = sc.nextFloat();
			try {
				adi.deposit(accountID, depositAmount);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				menuUser(username);
				break;
			case 4 :
				System.out.println("Enter the accountID");
				int accountID2 = sc.nextInt();
				System.out.println("Enter the amount to withdraw");
				float withdraw = sc.nextFloat();
				for(Account a:accounts) {
					if(a.getAccountID()==accountID2) {
						if(a.getBalance()>=withdraw) {
							try {
								adi.withdraw(accountID2, withdraw);
								System.out.println("Money withdrawn");
								menuUser(username);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}else {
							System.out.println("Insufficient funds");
							menuUser(username);
						}
					}
				}
				System.out.println("No account with that ID was found");
				menuUser(username);
				break;
			case 5 :
				System.out.println(accounts);
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
	public static void superLogin() {
		System.out.println("Enter user name");
		String user = sc.next();
		System.out.println("Enter Password");
		String pass = sc.next();
		
		menuSuper();
		
	}
	public static void menuSuper() {
		UserDAOImple udi = new UserDAOImple();
		AccountDAOImple adi = new AccountDAOImple();
		List<Account> accounts = new ArrayList<Account>();
		List<User> users = new ArrayList<User>();
		try {
			users = udi.getUserList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n1.View all users\n"
				+ "2.Create User\n"
				+ "3.Update user account\n"
				+ "4.Delete user and all account");
		int input = sc.nextInt();
		switch(input) {
		case 1 :
			System.out.println(users);
			menuSuper();
			break;
		case 2 :
			System.out.println("Enter your new username");
			String username = sc.next();
			System.out.println("Enter your password");
			String password = sc.next();
			try {
				if(!udi.isUserName(username)) {
					udi.createUser(username, password);
					System.out.println("User Created");
					menuSuper();
				}else {
					System.out.println("Username is taken");
					menuSuper();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			break;
		case 3 :
			System.out.println(users);
			System.out.println("Enter the userID of the user you would like to update");
			int temp = sc.nextInt();
			try {
				accounts = adi.getUserAccountsList(temp);
				System.out.println("Select the account id you would like to update");
				System.out.println(accounts);
				int accountID = sc.nextInt();
				menuUpdateAcc(accountID,accounts);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 4 :
			
			break;
		default :
			System.out.println("please enter a valid selection");
		}
	}
	public static void menuUpdateAcc(int accountID, List<Account> accounts2) {
		AccountDAOImple adi = new AccountDAOImple();
		List<Account> accounts = new ArrayList<Account>();
		for(Account a:accounts2) {
			if(a.getAccountID()==accountID) {
				System.out.println("what would you like to do?\n1.deposit\n2.Withdraw");
				int input = sc.nextInt();
				if(input == 1) {
					System.out.println("enter amount");
					float deposit = sc.nextFloat();
					try {
						adi.deposit(accountID, deposit);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (input==2) {
					System.out.println("enter amount");
					float withdraw = sc.nextFloat();
					try {
						adi.withdraw(accountID, withdraw);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					System.out.println("Please enter a valid option");
					menuUpdateAcc(accountID,accounts2);
				}
			}
	}
	

	}
	}


