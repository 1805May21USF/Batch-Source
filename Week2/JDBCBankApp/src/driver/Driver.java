package driver;

import java.sql.SQLException;
import java.util.Scanner;

import app.Account;
import app.Menu;
import app.MenuTree;
import app.Option;
import daoimpl.AccountDAOImpl;

public class Driver {
	public static void main(String[] args) throws SQLException {
		// for input
		Scanner scanner = new Scanner(System.in);

		// sets current user to logged out
		AccountDAOImpl adi = new AccountDAOImpl();
		Account currentUser = adi.getAccount(3);
		Account viewedUser = null;

		// register account menu
		Option[] welcomeArr = new Option[2];
		welcomeArr[0] = new Option(Account.Permission.CUSTOMER, 1, "Register new account", "registerMethod");
		welcomeArr[1] = new Option(Account.Permission.CUSTOMER, 2, "Login to existing account", "loginMethod");
		Menu welcome = new Menu("welcome", "Welcome to Superbank. What would you like to do?", welcomeArr);

		Option[] userMainArr = new Option[7];
		userMainArr[0] = new Option(Account.Permission.CUSTOMER, 1, "View balance", "view balance");
		userMainArr[1] = new Option(Account.Permission.CUSTOMER, 2, "Withdraw", "withdraw");
		userMainArr[2] = new Option(Account.Permission.CUSTOMER, 3, "Deposit", "deposit");
		userMainArr[3] = new Option(Account.Permission.CUSTOMER, 4, "Transfer money", "transfer money");
		userMainArr[4] = new Option(Account.Permission.CUSTOMER, 5, "Delete account", "delete account");
		userMainArr[5] = new Option(Account.Permission.CUSTOMER, 6, "Log out", "welcome");
		userMainArr[6] = new Option(Account.Permission.ADMIN, 7, "Edit other account", "admin account input");
		Menu userMain = new Menu("user main", "What would you like to do?", userMainArr);
		
		Option[] userAdminArr = new Option[6];
		userAdminArr[0] = new Option(Account.Permission.ADMIN, 1, "View account balance", "view balance");
		userAdminArr[1] = new Option(Account.Permission.ADMIN, 2, "Withdraw from this account", "withdraw");
		userAdminArr[2] = new Option(Account.Permission.ADMIN, 3, "Deposit to this account", "deposit");
		userAdminArr[3] = new Option(Account.Permission.ADMIN, 4, "Transfer money", "transfer money");
		userAdminArr[4] = new Option(Account.Permission.ADMIN, 5, "Delete this account", "delete account");
		userAdminArr[5] = new Option(Account.Permission.ADMIN, 6, "Back to main account", "admin return");
		Menu adminMain = new Menu("admin main", "What would you like to do?", userAdminArr);
		
		Menu[] menuArr = { welcome, userMain, adminMain };
		MenuTree defaultTree = new MenuTree(menuArr);

		String[] currentScreen = new String[2];
		currentScreen[0] = "welcome";

		// menu screen loop
		while (true) {
			while (currentUser.getUsername().equals("loggedout")) {
				currentScreen[0] = defaultTree.Navigate("welcome", scanner, currentUser);
				if (currentScreen[0].equals("loginMethod")) {
					String username;
					String password;

					while (currentUser.getAccountNum() == 3) {
						System.out.println("Enter username: ");
						username = scanner.nextLine();

						System.out.println("Enter password: ");
						password = scanner.nextLine();

						currentUser = adi.login(username, password);
						currentScreen[0] = "user main";
					}
				}
				if (currentScreen[0].equals("registerMethod")) {
					System.out.println("Enter first name: ");
					String firstName = scanner.nextLine();

					System.out.println("Enter last name: ");
					String lastName = scanner.nextLine();

					System.out.println("Enter username: ");
					String username = scanner.nextLine();

					System.out.println("Enter password: ");
					String password = scanner.nextLine();

					Account account = new Account(Account.Permission.CUSTOMER, firstName, lastName, username, password,
							0);

					if (adi.register(account)) {
						currentUser = adi.login(username, password);
						currentScreen[0] = "user main";
					}
				}
			}
			
			currentScreen[1] = defaultTree.Navigate(currentScreen[0], scanner, currentUser);
			currentScreen[0] = currentScreen[1];
			//currentScreen[0] is next screen to go to
			
			switch (currentScreen[0]) {
			case "view balance":
				if (viewedUser != null) { adi.viewBalance(viewedUser); }
				else { adi.viewBalance(currentUser); }
				break;
			case "withdraw":
				System.out.println("Enter amount to withdraw: ");
				String withdraw = scanner.nextLine();
				if (viewedUser != null) { adi.withdraw(viewedUser, Double.parseDouble(withdraw)); 
				currentScreen[0] = "admin main"; }
				else { adi.withdraw(currentUser, Double.parseDouble(withdraw));
				currentScreen[0] = "user main"; }
				break;
			case "deposit":
				System.out.println("Enter amount to deposit: ");
				String deposit = scanner.nextLine();
				if (viewedUser != null) { adi.deposit(viewedUser, Double.parseDouble(deposit));
				currentScreen[0] = "admin main"; }
				else { adi.deposit(currentUser, Double.parseDouble(deposit));
				currentScreen[0] = "user main"; }
				break;
			case "transfer money":
				System.out.println("Enter account number of person to transfer money to: ");
				String transferNumber = scanner.nextLine();
				System.out.println("Enter amount to transfer: ");
				String transferMoney = scanner.nextLine();
				if (viewedUser != null) { 
					adi.transfer(viewedUser, Integer.parseInt(transferNumber), Double.parseDouble(transferMoney)); 
					currentScreen[0] = "admin main"; }
				else { adi.transfer(currentUser, Integer.parseInt(transferNumber), Double.parseDouble(transferMoney));
				currentScreen[0] = "user main"; }
				break;
			case "delete account":
				if (currentUser.getFunds() > 0 && currentUser.getAccessLevel() == Account.Permission.CUSTOMER) {
					System.out.println("Only accounts with no funds can be deleted.");
				}
				else {
					adi.delete(currentUser);
					currentUser = adi.logout();
				}
				break;
			case "logout":
				currentUser = adi.logout();
				System.out.println("Logged out successfully.\n");
				viewedUser = null;
				break;
			case "admin account input":
				System.out.println("Enter account number of account to edit: ");
				String view = scanner.nextLine();
				viewedUser = adi.getAccount(Integer.parseInt(view));
				currentScreen[0] = "admin main";
				break;
			case "admin return":
				viewedUser = null;
				currentScreen[0] = "user main";
				break;
			}

		}

	}


	
}
