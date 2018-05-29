package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		System.out.println("Welcome to Superbank.");

		ArrayList<Account> accounts = new ArrayList<Account>();

		// path and name
		String fileName = "src/AccountInfo.txt";

		// used to go line by line
		String line = null;

		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String[] strArr = new String[6];
			/*
			 * data format (seperated by colons) String accountNum, int accessLevel, String
			 * name, String username, String password, double funds
			 */
			while ((line = bufferedReader.readLine()) != null) {
				strArr = line.split(":");
				if (!strArr[0].equals("{") && !strArr[0].equals("}")) {
					accounts.add(new Account(strArr[0], Account.Permission.values()[Integer.parseInt(strArr[1])],
							strArr[2], strArr[3], strArr[4], (double) Integer.parseInt(strArr[5])));
				}
			}
			bufferedReader.close();
		}
		// for if there are problems accessing/reading the file
		catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}

		Scanner scanner = new Scanner(System.in);

		Account currentUser = accounts.get(0);

		// register account menu
		Option[] welcomeArr = new Option[2];
		welcomeArr[0] = new Option(Account.Permission.CUSTOMER, 1, "Register new account", "registerMethod");
		welcomeArr[1] = new Option(Account.Permission.CUSTOMER, 2, "Login to existing account", "loginMethod");
		Menu welcome = new Menu("welcome", "Welcome to Superbank. What would you like to do?", welcomeArr);
		
		Option[] userMainArr = new Option[2];
		userMainArr[0] = new Option(Account.Permission.CUSTOMER, 1, "XXXX", "register");
		userMainArr[1] = new Option(Account.Permission.CUSTOMER, 2, "YYYY", "login");
		Menu userMain = new Menu("user main", "Welcome to Superbank. What would you like to do?", userMainArr);

		Menu[] menuArr = { welcome, userMain };
		MenuTree defaultTree = new MenuTree(menuArr);

		String[] currentScreen = new String[1];
		currentScreen[0] = "welcome";

		// menu screen loop
		while (true) {
			while (currentUser.getAccountNum().equals("0000001")) {
				currentScreen[0] = defaultTree.Navigate("welcome", scanner, currentUser, accounts);
				if (currentScreen[0].equals("loginMethod")) {
					String username;
					String password;

					while (currentUser.getAccountNum().equals("0000001")) {
						System.out.println("Enter username: ");
						username = scanner.nextLine();

						System.out.println("Enter password: ");
						password = scanner.nextLine();

						for (int i = 0; i < accounts.size(); i++) {
							if (accounts.get(i).getUsername().equals(username)) {
								if (accounts.get(i).getPassword().equals(password)) {
									currentUser = accounts.get(i);
									System.out.println(currentUser.getName());
									currentScreen[0] = "user main";
									break;
								} else {
									System.out.println("Incorrect password. Please try again.");
									break;
								}
							}
						}
					}
				}
			}
			//after logged in
			System.out.println("reached");
			currentScreen[0] = defaultTree.Navigate(currentScreen[0], scanner, currentUser, accounts);
			
		}

	}

	public static void Register(Scanner scanner) {
		System.out.println("Enter username: ");
		String username = scanner.nextLine();
		
		System.out.println("Enter password: ");
		String password = scanner.nextLine();
	}

	public static boolean isTaken(String username, String fileName) {
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = null;
			String[] strArr = new String[6];
			/*
			 * data format (seperated by colons) String accountNum int accessLevel String
			 * name String username String password double funds
			 */
			while ((line = bufferedReader.readLine()) != null) {
				strArr = line.split(":");
				if (!strArr[0].equals("{") && !strArr[0].equals("}")) {
					if (strArr[4].equals(username)) { return true; }
				}
			}
			bufferedReader.close();
		}
		// for if there are problems accessing/reading the file
		catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
		return false;
	}
}
