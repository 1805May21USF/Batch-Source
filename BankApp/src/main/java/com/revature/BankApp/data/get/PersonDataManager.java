package com.revature.BankApp.data.get;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PersonDataManager extends Person {
	private ArrayList<String> accounts = new ArrayList<>();
	private ArrayList<String> accountsBalance = new ArrayList<>();
	private String fName;
	private String lName;
	private String username;
	private String password;
	private int status;
	private long accNo;
	private DecimalFormat df = new DecimalFormat("###,###,###.00");

	public PersonDataManager() {
		try {
			Scanner input = new Scanner(new File("src\\main\\java\\com\\revature\\BankApp\\data\\Person.txt"));
			Scanner inputBalance = new Scanner(
					new File("src\\main\\java\\com\\revature\\BankApp\\data\\PersonBalance.txt"));
			while (input.hasNext()) {
				String t = input.next();
				String tB = inputBalance.next();
				String tmp = t.replace(',', ' ');
				String[] words = tmp.split("\\s+");
				if (words[0].equals("FirstName")) {

				} else {
					accounts.add(t);
					accountsBalance.add(tB);
				}
			}
		} catch (Exception ex) {
			System.out.println("Error caught at PersonDataManager() " + ex.getMessage());
		}
	}

	public boolean withdrawAcc() {
		return false;
	}

	public ArrayList<String> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<String> accounts) {
		this.accounts = accounts;
	}

	public ArrayList<String> getAccountsBalance() {
		return accountsBalance;
	}

	public void setAccountsBalance(ArrayList<String> accountsBalance) {
		this.accountsBalance = accountsBalance;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	/* Return the list of account numbers from the user name */
	public ArrayList<String> getAccountsOf(String username2) {
		ArrayList<String> result = new ArrayList<>();
		PersonDataManager pdm = new PersonDataManager();
		for (String arrStr : pdm.getAccounts()) {
			String tmp = arrStr.replace(',', ' ');
			String[] words = tmp.split("\\s+");
			if (username2.equals(words[2])) {
				result.add(words[5]);
			}
		}
		return result;
	}

	public void updateNewBalanceAdd(String username2, long accountNo, String bal) {
		PersonDataManager pdm = new PersonDataManager();
		ArrayList<String> tempArray = new ArrayList<>();
		for (String temp : pdm.getAccountsBalance()) {
			tempArray.add(temp);
		}

		for (int i = 0; i < tempArray.size(); i++) {
			String tmp = tempArray.get(i).replace(',', ' ');
			String[] words = tmp.split("\\s+");
			if (Long.parseLong(words[1]) == accountNo) {
				String tempVar = tempArray.get(i);
				tempArray.add(
						username2 + "," + accountNo + "," + (Double.parseDouble(words[2]) - Double.parseDouble(bal)));
				tempArray.remove(tempVar);
			}
		}
		// Write into the PersonBalance.txt

		try {
			PrintWriter out = new PrintWriter(
					new File("src\\main\\java\\com\\revature\\BankApp\\data\\PersonBalance.txt"));
			out.println("username,accountNo,balance");
			for (String arrStr : tempArray) {
				String tmp = arrStr.replace(',', ' ');
				String[] words = tmp.split("\\s+");
				out.println(words[0] + "," + words[1] + "," + words[2]);
			}
			out.close();
		} catch (Exception ex) {
			System.out.println("Exception was caught at accessing PersonBalance.txt: " + ex.getMessage());
		}
	}

	// Deposit Money into User's account
	public void updateNewBalanceSubtract(String username2, long accountNo, String bal) {
		PersonDataManager pdm = new PersonDataManager();
		ArrayList<String> tempArray = new ArrayList<>();
		for (String temp : pdm.getAccountsBalance()) {
			tempArray.add(temp);
		}

		for (int i = 0; i < tempArray.size(); i++) {
			String tmp = tempArray.get(i).replace(',', ' ');
			String[] words = tmp.split("\\s+");
			if (Long.parseLong(words[1]) == accountNo) {
				String tempVar = tempArray.get(i);
				tempArray.add(
						username2 + "," + accountNo + "," + (Double.parseDouble(words[2]) + Double.parseDouble(bal)));
				tempArray.remove(tempVar);
			}
		}
		// Write into the PersonBalance.txt

		try {
			PrintWriter out = new PrintWriter(
					new File("src\\main\\java\\com\\revature\\BankApp\\data\\PersonBalance.txt"));
			out.println("username,accountNo,balance");
			for (String arrStr : tempArray) {
				String tmp = arrStr.replace(',', ' ');
				String[] words = tmp.split("\\s+");
				out.println(words[0] + "," + words[1] + "," + words[2]);
			}
			out.close();
		} catch (Exception ex) {
			System.out.println("Exception was caught at accessing PersonBalance.txt: " + ex.getMessage());
		}
	}

	// Transfer Money from one account to another
	public void updateNewBalanceTransfer(String username2, long accountNo, double transferBalance, String bal) {
		PersonDataManager pdm = new PersonDataManager();
		ArrayList<String> tempArray = new ArrayList<>();
		// long transferFromAccountNumber = accountNo;
		// String transferBalanceFromAccountNumber = transferBalance;
		for (String temp : pdm.getAccountsBalance()) {
			tempArray.add(temp);
		}

		for (int i = 0; i < tempArray.size(); i++) {
			String tmp = tempArray.get(i).replace(',', ' ');
			String[] words = tmp.split("\\s+");
			if (Long.parseLong(words[1]) == accountNo && transferBalance == Double.parseDouble(words[2])) {
				String tempVar = tempArray.get(i);
				tempArray.add(
						username2 + "," + accountNo + "," + (Double.parseDouble(words[2]) - Double.parseDouble(bal)));
				tempArray.remove(tempVar);
			}
			if (Long.parseLong(words[1]) == accountNo && transferBalance != Double.parseDouble(words[2])) {
				String tempVar = tempArray.get(i);
				tempArray.add(
						username2 + "," + accountNo + "," + (Double.parseDouble(words[2]) + Double.parseDouble(bal)));
				tempArray.remove(tempVar);
			}
		}
		// Write into the PersonBalance.txt

		try {
			PrintWriter out = new PrintWriter(
					new File("src\\main\\java\\com\\revature\\BankApp\\data\\PersonBalance.txt"));
			out.println("username,accountNo,balance");
			for (String arrStr : tempArray) {
				String tmp = arrStr.replace(',', ' ');
				String[] words = tmp.split("\\s+");
				out.println(words[0] + "," + words[1] + "," + words[2]);
			}
			out.close();
		} catch (Exception ex) {
			System.out.println("Exception was caught at accessing PersonBalance.txt: " + ex.getMessage());
		}
	}

}
