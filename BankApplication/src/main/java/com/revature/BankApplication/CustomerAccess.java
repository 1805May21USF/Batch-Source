package com.revature.BankApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerAccess {

	private Customer c;
	private final String af = "Accounts.txt";
	private final String cf = "Customer.txt";
	public CustomerAccess(Customer c) {
		this.c = c;
	}
	/**
	 * Display info when logged in
	 */
	public void displayInfo() {
		System.out.println("Hello " + c.getFname() + " " + c.getLname() + ".");
		System.out.println("Please type an option.");
		System.out.println("1) Withdraw");
		System.out.println("2) Deposit");
		System.out.println("3) Transfer");
		System.out.println("4) Add Accounts");
		System.out.println("5) View Accounts");
		System.out.println("6) Exit");
		Scanner in = new Scanner(System.in);
		String s = "";
		int pick = 5;
		boolean oneToFive = false;
		while(!oneToFive) {
			try {
				pick = Integer.parseInt(s);
				if(pick >= 1 && pick <= 6) {
					oneToFive = true;
				} else {
					System.out.println("Please type a valid number.");
					s = in.nextLine();
					pick = Integer.parseInt(s);
				}
			} catch(Exception e) {
				System.out.println("Please type a valid number.");
				s = in.nextLine();
			}
		}
		switch (pick) {
		case 1:
			withdraw();
			break;
		case 2:
			deposit();
			break;
		case 3:
			transfer();
		case 4:
			addAcc();
			break;
		case 5:
			viewAcc();
			break;
		case 6:
			break;
		}
		if(pick != 6) {
			displayInfo();
		}
	}

	public void withdraw() {
		Scanner in = new Scanner(System.in);
		System.out.println("Which account do you want to withdraw from?");
		String inp = "";
		for(int i = 0; i < c.getAccNum().size(); i++) {
			Account a = getAccount(c.getAccNum().get(i));
			System.out.println(i+1+") " + a.getAccType());
		}
		boolean number = false;
		int value = 0;
		while(!number) {
			inp = in.nextLine();	
			try {
				int temp = Integer.parseInt(inp);
				if(temp <= c.getAccNum().size()) {
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

		Account a = getAccount(c.getAccNum().get(value));
		System.out.printf("Your balance is $%.2f. How much will you withdraw?\n",a.getBalance());

		double money = 0;
		boolean okay = false;
		String s = "";
		while(!okay) {
			try {
				s = in.nextLine();
				double temp = Double.parseDouble(s);
				if (temp < 0) {
					System.out.println("Please insert postive value");
					s = in.nextLine();
				} else if (temp > a.getBalance()) { 
					System.out.println("You don't have enough money. Try a different value.");
					s = in.nextLine();
				}
				else {
					money = temp;
					okay = true;
				}

			} catch(Exception e) {
				System.out.println("Please type in a numerical value");
				s = in.nextLine();
			}
			a.setBalance(a.getBalance()-money);
			System.out.printf("Account balance is now $%.2f.\n",a.getBalance());
			updateAccount(a);

		}
	}

	public void deposit() {
		Scanner in = new Scanner(System.in);
		System.out.println("Which account do you want to deposit to?");
		String inp = "";
		for(int i = 0; i < c.getAccNum().size(); i++) {
			Account a = getAccount(c.getAccNum().get(i));
			System.out.println(i+1+") " + a.getAccType());
		}
		boolean number = false;
		int value = 0;
		while(!number) {
			inp = in.nextLine();	
			try {
				int temp = Integer.parseInt(inp);
				if(temp <= c.getAccNum().size()) {
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

		Account a = getAccount(c.getAccNum().get(value));
		System.out.printf("Your balance is $%.2f. How much will you deposit?\n",a.getBalance());

		double money = 0;
		boolean okay = false;
		String s = "";
		while(!okay) {
			try {
				s = in.nextLine();
				double temp = Double.parseDouble(s);
				if (temp < 0) {
					System.out.println("Please insert postive value");
					s = in.nextLine();
				}
				else {
					money = temp;
					okay = true;
				}

			} catch(Exception e) {
				System.out.println("Please type in a numerical value");
				s = in.nextLine();
			}
			a.setBalance(a.getBalance()+money);
			System.out.printf("Account balance is now $%.2f.\n",a.getBalance());
			updateAccount(a);

		}
	}

	public void transfer() {
		System.out.println("What account would you like to transfer from?");
		Scanner in = new Scanner(System.in);
		String inp = "";
		int from = 0;
		int to = 0;
		for(int i = 0; i < c.getAccNum().size(); i++) {
			Account a = getAccount(c.getAccNum().get(i));
			System.out.println(i+1+") " + a.getAccType() + ", " + a.getBalance());
		}
		boolean number = false;
		while(!number) {
			inp = in.nextLine();	
			try {
				int temp = Integer.parseInt(inp);
				if(temp <= c.getAccNum().size()) {
					from = temp-1;
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



		System.out.println("What account would you like to transfer to?");
		for(int i = 0; i < c.getAccNum().size(); i++) {
			Account a = getAccount(c.getAccNum().get(i));
			System.out.println(i+1+") " + a.getAccType() + ", " + a.getBalance());
		}
		boolean number2 = false;
		while(!number2) {
			inp = in.nextLine();	
			try {
				int temp = Integer.parseInt(inp);
				if(temp <= c.getAccNum().size()) {
					to = temp-1;
					number2 = true;
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
		Account fromThis = getAccount(c.getAccNum().get(from));
		Account toThis = getAccount(c.getAccNum().get(to));
		String takeout = "";
		try {
			takeout = in.nextLine();
			if(Integer.parseInt(takeout) <= fromThis.getBalance()) {
				int take = Integer.parseInt(takeout);
				fromThis.setBalance(fromThis.getBalance()-take);
				toThis.setBalance(toThis.getBalance()+take);
				updateAccount(fromThis);
				updateAccount(toThis);
				System.out.printf("Account balance for %s is now $%.2f.\n",
						fromThis.getAccType(),fromThis.getBalance());
				System.out.printf("Account balance for %s is now $%.2f.\n",
						toThis.getAccType(),toThis.getBalance());
			}

		}catch (Exception e) {
			System.out.println("Type a number please.");
		}
		
	}

	public void addAcc() {
		Scanner in = new Scanner(System.in);
		System.out.println("1) Add checking account");
		System.out.println("2) Add savings account");
		System.out.println("3) Exit");
		boolean oneToTwo = false;
		String s = "";
		int type = 3;
		while(!oneToTwo) {
			try {
				type = Integer.parseInt(s);
				if(type >= 1 && type <= 3) {
					oneToTwo = true;
					createAcc(type);
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

	public void viewAcc() {
		if(c.getAccNum().size() == 0) {
			System.out.println("You do not have any accounts open.");
		} else {
			for(int a : c.getAccNum()) {
				System.out.printf("Your %s account has $%.2f.\n\n",
						getAccount(a).getAccType(),getAccount(a).getBalance());
			}
		}
		//displayInfo();
	}

	public void createAcc(int i) {
		String type = "";
		if(i == 1) {
			type = "Checking";
		} else {
			type = "Savings";
		}
		if(i == 1 | i == 2) {
			c.getAccNum().add(countAccounts());
			Account a = new Account(countAccounts(),type,0);
			ArrayList<Account> al = readAccounts();
			al.add(a);
			try {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(af));
				oos.writeObject(al);

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Account created");
			updateCustomer();	
		}

		//displayInfo();

	}

	/**
	 * counts the total amount of classes
	 */
	public int countAccounts() {
		ArrayList<Account> al = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(af));
			al = (ArrayList<Account>) ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return al.size();
	}

	public ArrayList<Account> readAccounts() {
		ArrayList<Account> al = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(af));
			al = (ArrayList<Account>) ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return al;
	}

	public Account getAccount(int id) {
		for(Account a : readAccounts()) {
			if(a.getAccountId() == id) {
				return a;
			}
		}
		return null;
	}

	public void updateAccount(Account a) {
		ArrayList<Account> al = readAccounts();
		for(int i = 0; i < al.size(); i++) {
			if(al.get(i).getAccountId() == a.getAccountId()) {
				al.set(i, a);
			}
		}

		ObjectOutputStream ois = null;
		try {
			ois = new ObjectOutputStream(new FileOutputStream(af));
			ois.writeObject(al);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateCustomer() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(cf));
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		@SuppressWarnings("unchecked")
		ArrayList<Customer> cl = null;
		try {
			cl = (ArrayList<Customer>) ois.readObject();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i = 0; i < cl.size(); i++) {
			if(c.getUser().equals(cl.get(i).getUser())) {
				cl.set(i, c);
			}
		}



		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(cf));
			oos.writeObject(cl);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public Customer getC() {
		return c;
	}
	public void setC(Customer c) {
		this.c = c;
	}


}
