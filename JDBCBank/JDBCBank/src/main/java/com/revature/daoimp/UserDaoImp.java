package com.revature.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.dao.UserDao;
import com.revature.util.ConnFactory;

public class UserDaoImp implements UserDao {
	
	public static ConnFactory cf = ConnFactory.getInstance();

	public void createUser(User user) throws SQLException {
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "UserID";
		
		String sql = "INSERT INTO BANKUSER VALUES(USERIDSEQ.NEXTVAL, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = conn.prepareStatement(sql, primaryKeys);
		ps.setString(1, user.getFirstName());
		ps.setString(2, user.getLastName());
		ps.setString(3, user.getEmail());
		ps.setString(4, user.getUsername());
		ps.setString(5, user.getPassword());
		ps.executeUpdate();
		
		System.out.println("New user successfully added!");
	}

	public void deleteUser(int userID) throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		stmt.executeQuery("DELETE FROM BANKUSER WHERE USERID = '" + userID + "'");
	}

	public User getUserByID(int userID) throws SQLException {
		User u = null;
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM BANKUSER WHERE USERID = '" + userID + "'");
		if(rs.next()) {
			//rs.next();
			u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			rs.close();
			stmt.close();
			conn.close();
			return u;
		} else {
			System.out.println("User ID was not found in the database!");
			return null;
		}
	}

	public User getUserByName(String firstName, String lastName) throws SQLException {
		User u = null;
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM BANKUSER WHERE FIRSTNAME = '" + firstName + "' AND LASTNAME = '" + lastName + "'");
		
		if(rs.next()) {
			//rs.next();
			u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			rs.close();
			stmt.close();
			conn.close();
			return u;
		} else {
			System.out.println("User first and last name was not found in the database!");
			return null;
		}
	}

	public User getUserByEmail(String email) throws SQLException {
		User u = null;
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM BANKUSER WHERE EMAIL = '" + email + "'");
		
		if(rs.next()) {
			//rs.next();
			u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			rs.close();
			stmt.close();
			conn.close();
			return u;
		} else {
			System.out.println("User email address was not found in the database!");
			return null;
		}
	}
	
	public User getUserByUsername(String username) throws SQLException {
		User u = null;
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM BANKUSER WHERE USERNAME = '" + username + "'");
		
		if(rs.next()) {
			//rs.next();
			u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			rs.close();
			stmt.close();
			conn.close();
			return u;
		} else {
			System.out.println("Username was not found in the database!");
			return null;
		}
		
	}

	public List<User> getAllUsers() throws SQLException {
		List<User> userList = new ArrayList<User>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM BANKUSER");
		User u = null;
		
		while(rs.next()) {
			u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			userList.add(u);
		}
			
		return userList;
	}
	
	public User checkLoginCredentials(String username, String password) throws SQLException {
		User u = null;
		Connection conn = cf.getConnection();
		try {
		Statement stmt = conn.createStatement();
		try {
		ResultSet rs = stmt.executeQuery("SELECT * FROM BANKUSER WHERE USERNAME = '" + username + "'");
		rs.next();
		try {
		u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
		} finally {
			rs.close();
		}
		} finally {
			stmt.close();
		}
		} finally {
			conn.close();
		}
		
		if(u.getPassword().equals(password)) {
			return u;
		} else {
			return null;
		}
		
		
		
	}
	
	public void login(int userType) throws SQLException {
		
		boolean success = false;
		Scanner sc = new Scanner(System.in);
		
		while(success != true) {
			System.out.println("Existing User Login");
			System.out.print("Username: ");
			String user = sc.nextLine();
			System.out.print("Password: ");
			String pass = sc.nextLine();
		
			User u = checkLoginCredentials(user, pass);
		
			if(u != null) {
				System.out.println("\nLogin Successfull!\n");
				success = true;
				if(userType == 1) {
					showClientMenu(u);
				} else if(userType == 2) {
					showAdminMenu(u);
				}
				
			} else {
				System.out.println("Invalid username or password!");
				//retry login
			}
		}
		
	}
	
	public void newUserLogin() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("New User Login");
		System.out.print("Username: ");
		String user = sc.nextLine();
		System.out.print("Password: ");
		String pass = sc.nextLine();
		System.out.print("First Name: ");
		String first = sc.nextLine();
		System.out.print("Last Name: ");
		String last = sc.nextLine();
		System.out.print("Email: ");
		String emailAddress = sc.nextLine();
		
		User u = new User(first, last, emailAddress, user, pass);
		createUser(u);
		showClientMenu(u);
		
	}
	
	public void showClientMenu(User u) throws SQLException {
		Scanner sc = new Scanner(System.in);
		int option = 0;
		boolean success = false;
		
		while(success != true) {
			System.out.println("Welcome, " + u.getFirstName() + "!");
			System.out.println("Client Menu");
			System.out.println("1) View Your Account(s)");
			System.out.println("2) Open New Account");
			System.out.println("3) Close Account");
			System.out.println("4) Log Out");
			System.out.print(">");
		
			option = sc.nextInt();
			
			AccountDaoImp acc = new AccountDaoImp();
		
			switch (option) {
			case 1: //open user accounts menu
				Account account1 = acc.getAccountByClient(u.getUserID());
				System.out.println("Your Bank Account(s): ");
				System.out.println("Account ID: " + account1.getAccountID() + "\tAccount Balance: $" + account1.getBalance());
				manageAccountMenu(account1);
				break;
			case 2: //open account creation menu
				System.out.println("Account Creation: ");
				System.out.print("Please enter an amount to deposit into your new account: $");
				double ammount = sc.nextDouble();
				Account account2 = new Account(u.getUserID(), ammount);
				acc.createAccount(account2);
				break;
			case 3: //open close account menu
				break;
			case 4:
				success = true;
				break;
			default: System.out.println("Invalid option! Please choose a valid option from the menu.");
				break;
			}
		}
	}
	
	public void showAdminMenu(User u) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		int option = 0;
		boolean success = false;
		
		while(success != true) {
			System.out.println("Welcome, " + u.getFirstName() + "!");
			System.out.println("Admin Menu");
			System.out.println("1) View User(s)");
			System.out.println("2) View Account(s)");
			System.out.println("3) Log Out");
			System.out.print(">");
		
			option = sc.nextInt();
		
			switch (option) {
			case 1:
				adminUserMenu();
				break;
			case 2: //admin view accounts menu
				break;
			case 3:
				success = true;
				break;
			default: System.out.println("Invalid option! Please choose a valid option from the menu.");
				break;
			}
		}
		
	}
	
	public void adminUserMenu() throws SQLException {
		Scanner sc = new Scanner(System.in);
		boolean success = false;
		int option = 0;
		User u = null;
		
		while(success != true) {
			System.out.println("Would you like to: ");
			System.out.println("1) View All Users");
			System.out.println("2) Search Users By User ID");
			System.out.println("3) Search Users By Name");
			System.out.println("4) Search Users By Username");
			System.out.println("5) Search Users By Email Address");
			System.out.println("6) Go Back");
			System.out.print(">");
			
			option = sc.nextInt();
			UserDaoImp userDao = new UserDaoImp();
			
			switch (option) {
			case 1: //display all users
				List<User> userList = new ArrayList<User>();
				userList = getAllUsers();
				System.out.println("User ID \tUsername \tFirst Name \tLast Name \tEmail Address");
				for(int i=0; i<userList.size(); i++) {
					u = userList.get(i);
					System.out.println(u.getUserID() + "\t\t" + u.getUsername() + "\t" + u.getFirstName() + "\t\t" + u.getLastName() + "\t\t" + u.getEmail());
				}
				break;
			case 2: //ask for user id and search
				System.out.print("Enter the ID number of the user you wish to search for: ");
				System.out.print(">");
				int id = sc.nextInt();
				u = getUserByID(id);
				if(u != null) {
					System.out.println("User ID \tUsername \tFirst Name \tLast Name \tEmail Address");
					System.out.println(u.getUserID() + "\t\t" + u.getUsername() + "\t" + u.getFirstName() + "\t\t" + u.getLastName() + "\t\t" + u.getEmail());
				}
				break;
			case 3: //ask for first and last name and search
				System.out.println("Enter user's first name: ");
				String first = sc.next();
				System.out.println("Enter user's last name: ");
				String last = sc.next();
				u = getUserByName(first, last);
				if(u != null) {
					System.out.println("User ID \tUsername \tFirst Name \tLast Name \tEmail Address");
					System.out.println(u.getUserID() + "\t\t" + u.getUsername() + "\t" + u.getFirstName() + "\t\t" + u.getLastName() + "\t\t" + u.getEmail());
				}
				break;
			case 4: //ask for username and search
				System.out.println("Enter username to search for: ");
				String user = sc.nextLine();
				u = getUserByUsername(user);
				if(u != null) {
					System.out.println("User ID \tUsername \tFirst Name \tLast Name \tEmail Address");
					System.out.println(u.getUserID() + "\t\t" + u.getUsername() + "\t" + u.getFirstName() + "\t\t" + u.getLastName() + "\t\t" + u.getEmail());
				}
				break;
			case 5: //ask for email address and search
				System.out.println("Enter user email address to search for: ");
				String email = sc.nextLine();
				u = getUserByEmail(email);
				if(u != null) {
					System.out.println("User ID \tUsername \tFirst Name \tLast Name \tEmail Address");
					System.out.println(u.getUserID() + "\t\t" + u.getUsername() + "\t" + u.getFirstName() + "\t\t" + u.getLastName() + "\t\t" + u.getEmail());
				}
				break;
			case 6:
				success = true;
				break;
			default: System.out.println("Invalid option! Please choose a valid option from the menu.");
				break;
			}
		}
		
	}
	
	public void manageAccountMenu(Account account) throws SQLException {
		Scanner sc = new Scanner(System.in);
		boolean success = false;
		int option = 0;
		double ammount = 0;
		
		while(success != true) {
			System.out.println("Account Management Menu");
			System.out.println("What would you like to do?");
			System.out.println("1) Make Deposit");
			System.out.println("2) Make Withdrawal");
			System.out.println("3) Close Account (Must have a balance of $0.00");
			System.out.println("4) Exit Account Management (Go Back)");
			System.out.print(">");
			
			option = sc.nextInt();
			AccountDaoImp acc = new AccountDaoImp();
			
			switch (option) {
			case 1: System.out.print("Enter ammount to deposit: $");
				ammount = sc.nextDouble();
				account.deposit(ammount);
				acc.deposit(account, ammount);
				break;
			case 2: System.out.print("Enter ammount to withdraw: $");
				ammount = sc.nextDouble();
				if((account.getBalance() - ammount) >= 0.00) {
					account.withdraw(ammount);
					acc.withdraw(account, ammount);
				} else {
					System.out.println("Account has insufficient funds to make this withdrawal!");
				}
				break;
			case 3: 
				if(account.getBalance() == 0.00) {
					acc.deleteAccount(account.getAccountID());
				} else {
					System.out.println("Account must have a balance of $0.00 before it can be closed!");
				}
				break;
			case 4:
				success = true;
				break;
			default: System.out.println("Invalid option! Please choose a valid option from the menu.");
				break;
			}
		}
	}
	

}
