package com.sunny.driver;

import java.sql.SQLException;

import com.sunny.beans.Account;
import com.sunny.beans.Customer;
import com.sunny.daoimpl.*;
import com.sunny.util.LinkTool;
import com.sunny.util.OverDraftException;

import java.util.ArrayList;
import java.util.Scanner;

public class BankDriver {

	private CustomerDAOImpl cdi;
	private AccountDAOImpl adi;
	private AdminDAOImpl admindi;
	private LinkTool lt;

	public BankDriver() {
		cdi = new CustomerDAOImpl();
		adi = new AccountDAOImpl();
		admindi = new AdminDAOImpl();
		lt = new LinkTool();
	}

	public static void main(String[] args) {
		BankDriver bd = new BankDriver();
		bd.run();
	}


	/**
	 * Runs Startup of Bank Application
	 */
	public void run() {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Sunny's Bank. Please type the corresponding "
				+ "number to continue.");
		System.out.println("1) Login");
		System.out.println("2) Sign up");
		System.out.println("3) Exit");
		String s = input.nextLine();
		int pick = 3;
		boolean onetwo = false;
		//Loops until correct choice is picked.
		while(!onetwo) {
			try {
				pick = Integer.parseInt(s);
				if(pick >= 1 && pick <= 3) {
					onetwo = true;
				} else {
					System.out.println("Please type a valid number.");
					s = input.nextLine();
					pick = Integer.parseInt(s);
				}
			} catch(Exception e) {
				System.out.println("Please type a valid number.");
				s = input.nextLine();
			}
		}
		try {
			firstChoice(pick);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Depending of int, different functions will be done
	 * @param i
	 * @throws SQLException 
	 */
	public void firstChoice(int i) throws SQLException{
		Scanner in = new Scanner(System.in);
		if(i == 1) {
			System.out.println("Insert Username");
			String user = in.nextLine().toLowerCase();			
			//Checks for username in database
			boolean exists = cdi.customerExists(user);
			boolean admin = admindi.adminExists(user);
			if(admin) {
				exists = true;
			}
			while(exists == false) {
				System.out.println("User doesn't exist, please try again");
				user = in.nextLine();
			}

			System.out.println("Insert password");
			String pw = in.nextLine();

			if(!admin) {
				while(!cdi.getPassword(user).equals(pw)) {
					System.out.println("Wrong password, try again");
					pw = in.nextLine();
				}
				login(cdi.getCustomerID(user));
			} else {
				while(!admindi.getPassword(user).equals(pw)) {
					System.out.println("Wrong password, try again");
					pw = in.nextLine();
				}
				adminAccess();
			}


		} else if (i == 2) {
			System.out.println("Please type your name (Format: \"First Last\")");
			String name = in.nextLine();
			String[] flname = name.split(" ");
			String fname = flname[0];
			String lname = flname[1];
			System.out.println("Please type a new username.");

			String user = in.nextLine();

			while(cdi.customerExists(user)) {
				System.out.println("Username already exists, please try another one.");
				user = in.nextLine();
			}

			System.out.println("Please type your password (more than 8 characters)");
			String pass = in.nextLine();
			while (pass.length() < 8) {
				System.out.println("Password not strong enough, please try another");
				pass = in.nextLine();
			}

			cdi.createCustomer(fname, lname, user, pass);

			System.out.println("Account Created.\n");
			run();
		} else {
			System.out.println("Thank you, goodbye.");
		}
		in.close();
	}

	/**
	 * After the customer logs in, he/she views the options available
	 * for their accounts.
	 * @param customerID - id specific to the customer
	 * @throws SQLException
	 */
	public void login(int customerID) throws SQLException {
		Customer c = cdi.getCustomer(customerID);	
		Scanner in = new Scanner(System.in);
		System.out.println("\nHello " + c.getFname() + " " + c.getLname() + ".");
		System.out.println("Please select an option to continue.");
		System.out.println("1) Withdraw");
		System.out.println("2) Deposit");
		System.out.println("3) Transfer");
		System.out.println("4) Add Accounts");
		System.out.println("5) View Accounts");
		System.out.println("6) Delete Accounts");
		System.out.println("7) Log out");
		String s = in.nextLine();
		int pick = 7;
		boolean oneToFive = false;
		while(!oneToFive) {
			try {
				pick = Integer.parseInt(s);
				if(pick >= 1 && pick <= 7) {
					oneToFive = true;
				} else {
					System.out.println("Please type a valid number.");
					s = in.nextLine();
					pick = Integer.parseInt(s);
				}
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("Please type a valid number.");
				s = in.nextLine();
			}
		}
		switch (pick) {
		case 1:
			withdraw(c);
			break;
		case 2:
			deposit(c);
			break;
		case 3:
			transfer(c);
			break;
		case 4:
			addAcc(c);
			break;
		case 5:
			viewAcc(c);
			break;
		case 6:
			deleteAcc(c);
			break;
		case 7:
			run();
			break;
		}
		if(pick != 7) {
			login(customerID);
		}
	}

	/**
	 * Allows Customer to delete any of their accounts
	 * with a balance of 0
	 * @param c - Customer information
	 * @throws SQLException
	 */
	private void deleteAcc(Customer c) throws SQLException {
		ArrayList<Integer> accidList = lt.getAcountLinks(c.getCustomerID());
		ArrayList<Account> alist = new ArrayList<Account>();
		for(int i : accidList) {
			alist.add(adi.getAccount(i));
		}
		viewAcc(c);
		System.out.printf("%d) Cancel", alist.size()+1);
		System.out.println();
		System.out.println("What account would you like to delete?\n" +
				"Please make sure the balance is 0.");
		Scanner in = new Scanner(System.in);
		String inp = in.nextLine();

		boolean number = false;
		int value = 0;
		while(!number) {	
			try {
				int temp = Integer.parseInt(inp);
				if(temp <= alist.size()) {
					value = temp-1;
					if(alist.get(value).getBalance() == 0) {
						number = true;
						boolean cont = false;
						while (!cont) {
							System.out.println("Are you sure you wish to delete?");
							System.out.println("1) Yes\n2) No");
							String answer = in.nextLine();
							if(answer.equals("1")) {
								cont = true;
								lt.deleteLinkAid(alist.get(value).getAccountId());
								adi.deleteAccount(alist.get(value).getAccountId());
								System.out.println("Account Deleted.");
							}else if (answer.equals("2")) {
								System.out.println("Delete cancelled.");
								cont = false;
								return;
							}else {
								System.out.println("Invalid input. Try again");
							}
						}

					} else {
						System.out.println("Balance is not $0. Try another account");
						inp = in.nextLine();
					}
				} else if(temp == alist.size()+1) {
					return;
				} else {
					System.out.println("Invalid input");
					inp = in.nextLine();
				}

			} catch (Exception e) {
				System.out.println("Type a number please.");
				inp = in.nextLine();
			}	
		}
	}

	/**
	 * Allows customer to view all accounts they own
	 * @param c - Customer information
	 * @throws SQLException
	 */
	private void viewAcc(Customer c) throws SQLException{
		ArrayList<Integer> accidList = lt.getAcountLinks(c.getCustomerID());
		ArrayList<Account> alist = new ArrayList<Account>();
		for(int i : accidList) {
			alist.add(adi.getAccount(i));
		}
		System.out.println("Your Accounts:");
		for(int i = 0; i < accidList.size(); i++) {
			String accType = lt.getAccountType(alist.get(i).getAccType());
			System.out.printf("%d) %s - %.2f\n",i+1,accType,alist.get(i).getBalance());
		}
	}

	/**
	 * Allows customer to add as many accounts as they want
	 * @param c - Customer information
	 * @throws SQLException
	 */
	private void addAcc(Customer c) throws SQLException{

		ArrayList<Integer> accidList = lt.getAcountLinks(c.getCustomerID());

		ArrayList<Account> alist = new ArrayList<Account>();
		System.out.println("What type of account would you like?");
		System.out.println("1) Savings Account\n2) Checkings Account\n3)Go back");
		Scanner in = new Scanner(System.in);

		String s = in.nextLine();
		int type = 3;
		boolean oneToTwo = false;
		while(!oneToTwo) {
			try {
				type = Integer.parseInt(s);
				if(type >= 1 && type <= 2) {
					oneToTwo = true;
					int aid = adi.createAccount(type, 0);
					lt.linkAccount(c.getCustomerID(), aid);
					System.out.println("Account Successfuly created");
				} else if(type == 3) {
					break;
				} else {
					System.out.println("Please type a valid number.");
					s = in.nextLine();
					type = Integer.parseInt(s);
				}
			} catch(Exception e) {
				System.out.println("Please type a valid number.");
				s = in.nextLine();
			}
		}


	}

	/**
	 * Allows customer to transfer money from one account
	 * to another
	 * @param c - Customer information
	 * @throws SQLException
	 */
	private void transfer(Customer c) throws SQLException{
		ArrayList<Integer> accidList = lt.getAcountLinks(c.getCustomerID());
		ArrayList<Account> alist = new ArrayList<Account>();
		for(int i : accidList) {
			alist.add(adi.getAccount(i));
		}
		System.out.printf("%d) Cancel", alist.size()+1);
		System.out.println();

		System.out.println("What account would you like to transfer from?");
		viewAcc(c);
		Scanner in = new Scanner(System.in);
		String inp = in.nextLine();
		int from = 0;
		int to = 0;

		boolean number = false;
		while(!number) {
			try {
				int temp = Integer.parseInt(inp);
				if(temp <= alist.size()) {
					from = temp-1;
					number = true;
				} else if(temp == alist.size()+1) {
					return;
				}else {
					System.out.println("Invalid input");
					inp = in.nextLine();
				}

			} catch (Exception e) {
				System.out.println("Type a number please.");
				inp = in.nextLine();
			}
		}

		System.out.println("What account would you like to transfer to?");
		for(int i = 0; i < alist.size(); i++) {
			Account a = alist.get(i);
			System.out.println(i+1+") " + lt.getAccountType(a.getAccType()) 
			+ " - " + a.getBalance());
		}
		inp = in.nextLine();
		number = false;
		while(!number) {
			try {
				int temp = Integer.parseInt(inp);
				if(temp <= alist.size()) {
					to = temp-1;
					number = true;
				} else {
					System.out.println("Invalid input");
					inp = in.nextLine();
				}

			} catch (Exception e) {
				System.out.println("Type a number please.");
				inp = in.nextLine();
			}

		}

		System.out.println("How much would you like to take out?");
		Account fromThis = alist.get(from);
		Account toThis = alist.get(to);
		String takeout = "";
		try {
			takeout = in.nextLine();
			if(Float.parseFloat(takeout) <= fromThis.getBalance()) {
				float take = Integer.parseInt(takeout);
				fromThis.setBalance(fromThis.getBalance()-take);
				toThis.setBalance(toThis.getBalance()+take);
				adi.setBalance(fromThis.getBalance(), fromThis.getAccountId());
				adi.setBalance(toThis.getBalance(), toThis.getAccountId());
				System.out.printf("Account balance for %s is now $%.2f.\n",
						lt.getAccountType(fromThis.getAccType()),fromThis.getBalance());
				System.out.printf("Account balance for %s is now $%.2f.\n",
						lt.getAccountType(toThis.getAccType()),toThis.getBalance());
			}

		}catch (Exception e) {
			System.out.println("Type a number please.");
		}


	}

	/**
	 * Allows customer to transfer money from one account
	 * to another
	 * @param c - Customer information
	 * @throws SQLException
	 */
	private void deposit(Customer c) throws SQLException {
		ArrayList<Integer> accidList = lt.getAcountLinks(c.getCustomerID());
		ArrayList<Account> alist = new ArrayList<Account>();
		viewAcc(c);
		for(int i : accidList) {
			alist.add(adi.getAccount(i));
		}
		System.out.printf("%d) Cancel", alist.size()+1);
		System.out.println();
		System.out.println("Which account would you like to deposit from?");
		Scanner in = new Scanner(System.in);
		String inp = in.nextLine();

		boolean number = false;
		int value = 0;
		while(!number) {	
			try {
				int temp = Integer.parseInt(inp);
				if(temp <= alist.size()) {
					value = temp-1;
					number = true;
				} else if(temp == alist.size()+1) {
					return;
				} else {
					System.out.println("Invalid input");
					inp = in.nextLine();
				}

			} catch (Exception e) {
				System.out.println("Type a number please.");
				inp = in.nextLine();
			}

			Account a  = alist.get(value);
			System.out.printf("The account has a balance of %.2f. How much will you deposit?\n",a.getBalance());
			inp = in.nextLine();

			float money = 0;
			number = false;

			while(!number) {
				try {
					float temp = Float.parseFloat(inp);
					if (temp < 0) {
						System.out.println("Please insert postive value");
						inp = in.nextLine();
					}
					else {
						money = temp;
						number = true;
					}

				} catch(Exception e) {
					System.out.println("Please type in a numerical value");
					inp = in.nextLine();
				}


				a.setBalance(a.getBalance()+money);
				adi.setBalance(a.getBalance(), a.getAccountId());
				System.out.printf("Account balance is now $%.2f.\n",a.getBalance());

			}

		}
	}

	/**
	 * Allows customer to withdraw money from any account
	 * @param c - Customer information
	 * @throws SQLException
	 */
	private void withdraw(Customer c) throws SQLException{
		ArrayList<Integer> accidList = lt.getAcountLinks(c.getCustomerID());
		ArrayList<Account> alist = new ArrayList<Account>();
		viewAcc(c);
		for(int i : accidList) {
			alist.add(adi.getAccount(i));
		}
		System.out.printf("%d) Cancel", alist.size()+1);
		System.out.println();
		System.out.println("Which account would you like to deposit from?");
		Scanner in = new Scanner(System.in);
		String inp = in.nextLine();

		boolean number = false;
		int value = 0;
		while(!number) {	
			try {
				int temp = Integer.parseInt(inp);
				if(temp <= alist.size()) {
					value = temp-1;
					number = true;
				} else if(temp == alist.size()+1) {
					return;
				} else {
					System.out.println("Invalid input");
					inp = in.nextLine();
				}

			} catch (Exception e) {
				System.out.println("Type a number please.");
				inp = in.nextLine();
			}

			Account a  = alist.get(value);
			System.out.printf("The account has a balance of %.2f. How much will you withdraw?\n",a.getBalance());
			inp = in.nextLine();

			float money = 0;
			number = false;

			while(!number) {
				try {
					float temp = Float.parseFloat(inp);
					if (temp < 0) {
						System.out.println("Please insert postive value");
						inp = in.nextLine();
					} else if (temp > a.getBalance()) { 
						try {
							if(temp >a.getBalance()) {
								throw new OverDraftException();
							} 
						} catch(OverDraftException e) {
							e.printStackTrace();
							System.out.println("Try a lower a amount");
						}finally {
							inp = in.nextLine();
						}
					}
					else {
						money = temp;
						number = true;
					}

				} catch(Exception e) {
					System.out.println("Please type in a numerical value");
					inp = in.nextLine();
				}


				a.setBalance(a.getBalance()-money);
				adi.setBalance(a.getBalance(), a.getAccountId());
				System.out.printf("Account balance is now $%.2f.\n",a.getBalance());

			}

		}


	}

	private void adminAccess() throws SQLException {
		System.out.println("Welcome back Administrator.");
		System.out.println("What would you like to do today?");
		System.out.println("1) View Customers\n2) Delete Customers\n" +
				"3) Edit Customers\n4) Add Customers\n5) Exit");
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		boolean valid = false;
		int chose = 0;
		while(valid == false) {
			if(s.equals("1")) {
				valid = true;
				printAllCustomers();
			} else if(s.equals("2")) {
				valid = true;
				ArrayList<Customer> alist = printAllCustomers();
				System.out.println("Which customer do you want to delete?");
				System.out.printf("%d) Go back", alist.size()+1);
				System.out.println();
				s=in.nextLine();
				int temp = alist.size()+1;
				String ey = "" + temp;
				if(!s.equals(ey)) {
					int results = getAccChoice(s,alist);
					System.out.println(alist.get(results).getUser() + " User removed\n");
					cdi.removeCustomer(alist.get(results).getCustomerID());
				}
				
			} else if(s.equals("3")) {
				valid = true;
				ArrayList<Customer> alist = printAllCustomers();
				System.out.printf("%d) Go back\n", alist.size()+1);
				System.out.println("Which customer do you want to edit?");
				System.out.println();
				s=in.nextLine();
				int temp = alist.size()+1;
				String ey = "" + temp;
				if(!s.equals(ey)) {
					int results = getAccChoice(s,alist);
					editCustomer(alist.get(results));
				}
				
			} else if(s.equals("4")) {
				valid = true;
				System.out.println("What is the first name");
				String fn = in.nextLine();
				System.out.println("What is the last name?");
				String ln = in.nextLine();
				System.out.println("What is the username?");
				String user = in.nextLine();
				while(cdi.customerExists(user) == true) {
					System.out.println("Username taken, try another");
					user = in.nextLine();
				}
				System.out.println("What is the password?");
				String pass = in.nextLine();
				System.out.println();
				cdi.createCustomer(fn, ln, user, pass);
				System.out.println("Account Succesfully created");

				
			} else if(s.equals("5")) {
				chose = 5;
				valid = true;
			} else {
				System.out.println("Invalid input. try again");
				s =in.nextLine();
			}
		}
		if(chose != 5) {
			adminAccess();
		} else {
			System.out.println("Logging out.");
			run();
		}

	}
	
	private void editCustomer(Customer customer) throws SQLException {
		Customer c = customer;
		System.out.println("What do you want to change?");
		System.out.println("1) Name");
		System.out.println("2) Username");
		System.out.println("3) Password");
		System.out.println("4) Cancel");
		Scanner in = new Scanner(System.in);
		String inp = in.nextLine();
		boolean a = false;
		while(a == false)
		if(inp.equals("1")) {
			a = true;
			System.out.println("Type First Name");
			String fn = in.nextLine();
			c.setFname(fn);
			System.out.println("Type Last name");
			String ln = in.nextLine();
			c.setLname(ln);
			cdi.editCustomerName(c.getCustomerID(), fn, ln);
			System.out.println("Updated Sucessfully");
			
		}else if(inp.equals("2")) {
			a = true;
			System.out.println("Type username");
			String user = in.nextLine();
			while(cdi.customerExists(user) == true) {
				System.out.println("Username exists, try another");
				user = in.nextLine();
			}
			cdi.editCustomerUser(c.getCustomerID(), user);
			System.out.println("Username updated");
		}else if(inp.equals("3")) {
			a = true;
			System.out.println("Type password");
			String pass = in.nextLine();
			cdi.editCustomerPass(c.getCustomerID(),pass);
			System.out.println("Password updated");
			
		}else if(inp.equals("4")) {
			a = true;
			
		} else {
			System.out.println("Invalid input");
			inp = in.nextLine();
		}
		System.out.println();
		
	}

	private int getAccChoice(String input, ArrayList<Customer> alist) {
		Scanner in = new Scanner(System.in);
		String inp = input;
		boolean number = false;
		int value = 0;
		while(!number) {	
			try {
				int temp = Integer.parseInt(inp);
				if(temp <= alist.size()) {
					value = temp-1;
					number = true; 
				} else {
					System.out.println("Invalid input");
					inp = in.nextLine();
				}

			} catch (Exception e) {
				System.out.println("Type a number please.");
				inp = in.nextLine();
			}
		}

		return value;
	}

	public ArrayList<Customer> printAllCustomers() throws SQLException{
		ArrayList<Customer> clist = cdi.getCustomerList();
		for(int i = 0; i < clist.size(); i++) {
			String name = clist.get(i).getFname() + " " + clist.get(i).getLname();
			ArrayList<Integer> accidList = lt.getAcountLinks(clist.get(i).getCustomerID());
			ArrayList<Account> alist = new ArrayList<Account>();
			for(int j : accidList) {
				alist.add(adi.getAccount(j));
			}
			
			System.out.printf("%d) Username: %s\n\tName: %s\n\t%d Accounts:",i+1,clist.get(i).getUser(),
					name,alist.size());
			for(Account a : alist) {
				System.out.printf("\n\t%s - $%.2f\t",lt.getAccountType(a.getAccType()),a.getBalance());
			}
			System.out.println("\n");
		}
		return clist;
	}

}
