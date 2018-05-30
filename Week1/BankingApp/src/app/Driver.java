package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		ArrayList<Account> accounts = new ArrayList<Account>();

		// path and name
		String fileName = "src/AccountInfo.txt";
		accounts = AccountReader(fileName);
		Account currentUser = accounts.get(0);

		Scanner scanner = new Scanner(System.in);

		// register account menu
		Option[] welcomeArr = new Option[2];
		welcomeArr[0] = new Option(Account.Permission.CUSTOMER, 1, "Register new account", "registerMethod");
		welcomeArr[1] = new Option(Account.Permission.CUSTOMER, 2, "Login to existing account", "loginMethod");
		Menu welcome = new Menu("welcome", "Welcome to Superbank. What would you like to do?", welcomeArr);

		Option[] userMainArr = new Option[4];
		userMainArr[0] = new Option(Account.Permission.CUSTOMER, 1, "Withdraw", "withdraw");
		userMainArr[1] = new Option(Account.Permission.CUSTOMER, 2, "Deposit", "deposit");
		userMainArr[2] = new Option(Account.Permission.CUSTOMER, 3, "Transfer money", "transfer money");
		userMainArr[3] = new Option(Account.Permission.CUSTOMER, 4, "Apply for joint account", "joint account");
		Menu userMain = new Menu("user main", "Current balance: $" + currentUser.getFunds(), userMainArr);

		Menu[] menuArr = { welcome, userMain };
		MenuTree defaultTree = new MenuTree(menuArr);

		String[] currentScreen = new String[2];
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

						currentUser = Login(accounts, username, password);
						currentScreen[0] = "user main";
					}
				}
				if (currentScreen[0].equals("registerMethod")) {
					System.out.println("Enter name: ");
					String name = scanner.nextLine();

					System.out.println("Enter username: ");
					String username = scanner.nextLine();

					System.out.println("Enter password: ");
					String password = scanner.nextLine();

					Account account = new Account("0000001", Account.Permission.CUSTOMER, name, username, password, 0);
					if (Register(scanner, fileName, account)) {
						accounts = AccountReader(fileName);
						currentUser = Login(accounts, username, password);
						currentScreen[0] = "user main";
					}
				}
			}
			// after logged in
			currentScreen[1] = defaultTree.Navigate(currentScreen[0], scanner, currentUser, accounts);
			currentScreen[0] = currentScreen[1];
			switch(currentScreen[0]) {
			case "withdraw":
				System.out.println("Enter amount to withdraw: ");
				String withdraw = scanner.nextLine();
				Withdraw(currentUser, Double.parseDouble(withdraw));
				UpdateAccount(currentUser, fileName, "funds", withdraw);
				currentScreen[0] = "user main";
				break;
			case "deposit":
				System.out.println("Enter amount to deposit: ");
				String deposit = scanner.nextLine();
				Deposit(currentUser, Double.parseDouble(deposit));
				currentScreen[0] = "user main";
				break;
			case "transfer money":
				System.out.println("Enter account number of person to transfer money to: ");
				String transferNumber = scanner.nextLine();
				System.out.println("Enter amount to transfer: ");
				String transferMoney = scanner.nextLine();
				//Transfer(currentUser, Double.parseDouble(transferMoney));
				currentScreen[0] = "user main";
				break;
			case "apply for joint account":
			}
		}

	}

	/*
	 * searches account arraylist for matching username, then tries password.
	 * returns if correct. if no matches, returns logged out account
	 */
	public static Account Login(ArrayList<Account> accounts, String username, String password) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getUsername().equals(username)) {
				if (accounts.get(i).getPassword().equals(password)) {
					return accounts.get(i);
				} else {
					System.out.println("Incorrect password. Please try again.");
					break;
				}
			}
		}
		return accounts.get(0);
	}

	// returns true if registration is successful, false if name is taken
	public static boolean Register(Scanner scanner, String fileName, Account account) {
		Random rand = new Random();

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
					// makes sure accountNum is unique
					while (strArr[0].equals(account.getAccountNum())) {
						// if accountNum is taken, randomizes until one not taken is found
						account.setAccountNum(Integer.toString(rand.nextInt(9999999) + 1));
					}
					// rejects username if already taken
					if (strArr[3].equals(account.getUsername())) {
						return false;
					}
				}
			}
			bufferedReader.close();
		}
		// account file exception catching
		catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
		
		//appends new file data to the end of the account file
		try (FileWriter fw = new FileWriter(fileName, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			out.println("{" + "\n" + account.getAccountNum() + ":" + account.getAccessLevel().ordinal() + ":"
					+ account.getName() + ":" + account.getUsername() + ":" + account.getPassword() + ":"
					+ account.getFunds() + "\n" + "}");
		} catch (IOException e) {
			// do something
		}
		return true;
	}
	
	//pictured: why data shouldn't be stored in text files
	public static boolean UpdateAccount(Account account, String fileName, String field, String data) {
		Charset charset = StandardCharsets.UTF_8;
		Path path = Paths.get(fileName);
		String content;
		try {
			content = new String(Files.readAllBytes(path), charset);
		switch (field) {
		case "accountNum":
			content = content.replaceAll("\n:\\w+:\\w+:\\w+:\\w+:\\w+:\\w+:", "\n" + data + ":\\w+:\\w+:\\w+:\\w+:\\w+:");
			break;
		case "accessLevel":
			content = content.replaceAll("\n:\\w+:\\w+:\\w+:\\w+:\\w+:\\w+:", "\n:\\w+:" + data + ":\\w+:\\w+:\\w+:\\w+:");
			break;
		case "name":
			content = content.replaceAll("\n:\\w+:\\w+:\\w+:\\w+:\\w+:\\w+:", "\n:\\w+:\\w+:" + data + ":\\w+:\\w+:\\w+:");
			break;
		case "username":
			content = content.replaceAll("\n:\\w+:\\w+:\\w+:\\w+:\\w+:\\w+:", "\n:\\w+:\\w+:\\w+:" + data + ":\\w+:\\w+:");
			break;
		case "password":
			content = content.replaceAll("\n:\\w+:\\w+:\\w+:\\w+:\\w+:\\w+:", "\n:\\w+:\\w+:\\w+:\\w+:" + data + ":\\w+:");
			break;
		case "funds":
			content = content.replaceAll("\n:\\w+:\\w+:\\w+:\\w+:\\w+:\\w+:", "\n:\\w+:\\w+:\\w+:\\w+:\\w+:" + data);
			break;
			}
			Files.write(path, content.getBytes(charset));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	//reads data from account file and returns an arraylist of user accounts
	public static ArrayList<Account> AccountReader(String fileName) {
		ArrayList<Account> accounts = new ArrayList<Account>();
		try {
			// used to go line by line
			String line = null;

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
							strArr[2], strArr[3], strArr[4], Double.parseDouble(strArr[5])));
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
		return accounts;
	}
	
	public static void Withdraw(Account account, double takeOut) {
		if (takeOut < account.getFunds()) {
			account.setFunds(account.getFunds() - takeOut);
		}
		else { System.out.println("Overdraw: not enough funds in account"); }
	}
	
	public static void Deposit(Account account, double putIn) {
		account.setFunds(account.getFunds() + putIn);
		System.out.println("Funds deposited successfully.");
	}

	public static void Transfer(Account account, Account destination, double transferAmount) {
		Withdraw(account, transferAmount);
		Deposit(destination, transferAmount);
		System.out.println("Funds transferred successfully.");
	}
}

