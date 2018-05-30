package com.revature.BankApplication;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
public class BankApp {

	private final String custFile = "Customer.txt";
	private final String accFile = "Accounts.txt";

	public static void main(String[] args) {
		BankApp ba = new BankApp();
		ba.createAdmin();
		ba.run();

	}
	/**
	 * Checks if file exists, and creates it it doesn't;
	 */
	public void checkAndCreate() {
		File cf = new File(custFile);
		File af = new File(accFile);
		if(!cf.exists()) {
			try {
				cf.createNewFile(); //Creates Customer.txt
				ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(custFile));
				ArrayList<Customer> clist = new ArrayList<Customer>();
				//Creates empty arraylist to write in text file
				oo.writeObject(clist);
				oo.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(!af.exists()) {
			try {
				af.createNewFile(); //Creates Accounts.txt
				ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(accFile));
				ArrayList<Account> alist = new ArrayList<Account>();
				oo.writeObject(alist);
				oo.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * Runs Startup of Bank Application
	 */
	public void run() {
		Scanner input = new Scanner(System.in);
		checkAndCreate();
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
		firstChoice(pick);
	}

	/**
	 * Depending of int, different functions will be done
	 * @param i
	 */
	public void firstChoice(int i) {
		Scanner in = new Scanner(System.in);
		if(i == 1) {
			System.out.println("Insert Username");
			String user = in.nextLine().toLowerCase();
			while(!userExist(user)) {
				System.out.println("User doesn't exist, please try again");
				user = in.nextLine();
			}
			Customer c = null;
			for(Customer temp : readCust()) {
				if(temp.getUser().equals(user)) {
					c = temp;
				}
			}
			System.out.println("Insert password");
			String pw = in.nextLine();
			while(!pwCheck(user,pw)) {
				System.out.println("Wrong password, try again");
				pw = in.nextLine();
			}
			login(c);
		} else if (i == 2) {
			System.out.println("Please type your name (Format: \"First Last\")");
			String name = in.nextLine();
			String[] flname = name.split(" ");
			System.out.println("Please type your new user and password (Format: user,password)");
			boolean attempt = false;
			while(!attempt) {
				String su = in.nextLine();
				attempt = signup(flname[0],flname[1],su);
			}
			System.out.println("Account Created.");
			run();
		} else {
			System.out.println("Thank you, goodbye.");
		}
		in.close();
	}

	private CustomerAccess CustomerAccess(Customer c) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Creates Customer to be stored in ArrayList
	 * @param fname - First name
	 * @param lname - Last name
	 * @param newUser - username,password
	 * @return returns true or false if successful
	 */
	public boolean signup(String fname, String lname, String newUser) {
		String[] userPw = newUser.split(",");
		userPw[0] = userPw[0].toLowerCase(); //username is not case sensitive
		if(userPw.length == 1) {
			System.out.println("Invalid password");
			return false;
		}
		ArrayList<Customer> cl = readCust();
		for(Customer cust : cl) {
			if(cust.getUser().equals(userPw[0])) {
				System.out.println("Username already taken. Try again.");
				return false;
			}
		}

		cl.add(new Customer(fname,lname,userPw[0],userPw[1]));

		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(custFile));
			oos.writeObject(cl);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * reads from input file and grabs arraylist
	 * @return - returns the arraylist read
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Customer> readCust() {
		ObjectInputStream ois;
		ArrayList<Customer> cl = new ArrayList<Customer>();
		try {
			ois = new ObjectInputStream(new FileInputStream(custFile));
			cl = (ArrayList<Customer>) ois.readObject();
			ois.close();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return cl;
	}

	public boolean userExist(String user) {
		ArrayList<Customer> cl = readCust();
		for(Customer c : cl) {
			if(c.getUser().equals(user)) {
				return true;
			}
		}
		return false;
	}

	public boolean pwCheck(String user, String pass) {
		ArrayList<Customer> cl = readCust();
		for(Customer c : cl) {
			if(c.getUser().equals(user)) {
				if(c.getPass().equals(pass)) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}


	public void deleteAllCustAcc() {
		File cf = new File(custFile);
		File af = new File(accFile);
		cf.delete();
		af.delete();
	}

	public void login(Customer c) {
		if(c.isEmployee()) {
			AdminAccess aa = new AdminAccess(c);
			aa.displayInfo();
		} else {
			CustomerAccess ca = new CustomerAccess(c);
			ca.displayInfo();
		}
	}

	public void createAdmin() {
		Customer c = new Customer("Admin","Admin","admin","admin");
		c.setEmployee(true);
		ArrayList<Customer> cl = readCust();
		cl.add(c);
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(custFile));
			oos.writeObject(cl);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}


