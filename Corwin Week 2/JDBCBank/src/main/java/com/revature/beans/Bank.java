package com.revature.beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

import com.revature.DAO.CustomerDAO;
import com.revature.exceptions.PasswordException;
import com.revature.util.Datastore;
import com.revature.validation.Validation;

import oracle.sql.DATE;

public class Bank {

	private Datastore d;
	private boolean isOpen = false;
	private int bankView = 0;
	private User currentUser;
	
	public Bank() {
		this.isOpen = true;
	}
	
	public void connect() {
		d = d.getInstance();
	}
	
	public void start() {
		this.connect();
		int menu = 0;
		while(isOpen) {
			switch(this.bankView) {
				case 0:{
					welcomeMenu();
					break;
				}
				case 1:{
					newUserMenu();
					break;
				}
				case 2:{
					loginMenu();
					break;
				}
				case 3:{
					if(currentUser.isCustomer()) {
						customerMainMenu();
						break;
					}
					if(currentUser.isEmployee()) {
						employeeMainMenu();
						break;
					}
					if(currentUser.isAdmin()) {
						adminMainMenu();
						break;
					}
				}
			}
		}
	}
	public void welcomeMenu() {
		int selection;
		System.out.flush();
		System.out.println("Welcome!");
		linebreak();
		System.out.println("1. New User Registration");
		System.out.println("2. Log in");
		System.out.println("3. Exit");
			
		Scanner scanner = new Scanner(System.in);
		try {
		selection = Integer.parseInt(scanner.nextLine());
		} catch(NumberFormatException e) {
			System.out.println("You selection was not a number!");
			selection = -1;
		}
			
		switch(selection) {
			case 1:{
				this.bankView=1;
				break;
			}
			case 2:{
				this.bankView=2;
				break;
			}
			case 3:{
				this.setBankView(0);
				break;
			}
			default:{
				System.out.flush();
				System.out.println("That wasn't a menu choice!");
				break;
			}
			
		}
	}
	
	public void newUserMenu() {
		linebreak();
		Scanner scanner = new Scanner(System.in);
		
		String fname;
		String lname;
		String username;
		String password;
		
		System.out.println("Create A New User");
		linebreak();
		System.out.println("What is your first name?");
		fname = scanner.nextLine();
		
		while(!(Validation.validateName(fname))) {
			System.out.println(fname.length());
			System.out.println("That is not a valid name!");
			fname=scanner.nextLine();
		}
		
		System.out.println("What is your last name?");
		lname = scanner.nextLine();
		
		while(!Validation.validateName(lname)) {
			System.out.println("That is not a valid name!");
			fname=scanner.nextLine();
		}
		
		System.out.println("New Username:");
		username = scanner.nextLine();
		while(!Validation.validateUsername(username)) {
			System.out.println("That is not a valid username!");
			fname=scanner.nextLine();
		}
		System.out.println("New Password: ");
		password = scanner.nextLine();
		while(!Validation.validatePassword(password)) {
			System.out.println("That is not a valid password!");
			fname=scanner.nextLine();
		}
		Customer c = new Customer(username,password,fname,lname);
		if(d.getCustomerByUsername(username) != null) {
			
			System.out.println("That username is already taken!");
			
			do{ 
				System.out.println("New Username:");
				username = scanner.nextLine();
				while(!Validation.validateUsername(username)) {
					System.out.println("That is not a valid username!");
					fname=scanner.nextLine();
				}
				System.out.println("New Password: ");
				password = scanner.nextLine();
				while(!Validation.validatePassword(password)) {
					System.out.println("That is not a valid password!");
					fname=scanner.nextLine();
				}
				c = new Customer(username,password,fname,lname);
			
			}while( d.getCustomerByUsername(username) != null);
		}
		d.addCustomer(c);
		currentUser = d.getCustomerByUsername(c.getUserName());
		linebreak();
		
		this.setBankView(3);
	}
	
	public void loginMenu() {
		linebreak();
		String username;
		String password;
		System.out.println("Log In");
		linebreak();
		System.out.println("Username:");
		Scanner scanner = new Scanner(System.in);
		username = scanner.nextLine();

		System.out.println("Password: ");
		password = scanner.nextLine();
		linebreak();
		
		boolean loggedIn = false;
		try {
			if(d.getCustomerByUsername(username).getPassWord().equals(password)) {
				System.out.println("Logged in");
				this.setBankView(3);
				this.currentUser = d.getCustomerByUsername(username);
				loggedIn = true;
			}
			else {
				System.out.println("Not a user with valid password.");
			}
		}catch(NullPointerException e) {
			System.out.println("Not a user with valid password.");
		}
		
		if(loggedIn == false) {
		
		try {
			if(d.getEmployeeByUsername(username).getPassWord().equals(password)) {
				System.out.println("Logged in");
				this.setBankView(3);
				this.currentUser = d.getEmployeeByUsername(username);
				loggedIn = true;
			}
			else {
				System.out.println("Not an employee with a valid password.");
				this.setBankView(0);
			}
		}catch(NullPointerException ee) {
			System.out.println("Not an employee with a valid password.");
			this.setBankView(0);
		}}
		
		if(loggedIn == false) {
			try {
				throw new PasswordException();
			} catch (PasswordException e) {
				// TODO Auto-generated catch block
				System.out.println("THIS WAS A CUSTOMER EXCEPTION: Failed to login!");
			}
		}
		
	}
	
	public void customerMainMenu() {
		boolean loggedIn = true;
		
		while(loggedIn) {
			
			int selection;
			linebreak();
			System.out.println("Welcome!");
			linebreak();
			System.out.println("1. Apply For An Account! ");
			System.out.println("2. Information");
			System.out.println("3. Accounts");
			System.out.println("4. Exit");
				
			Scanner scanner = new Scanner(System.in);
			try {
				selection = Integer.parseInt(scanner.nextLine());
				} catch(NumberFormatException e) {
					System.out.println("You selection was not a number!");
					selection = -1;
				}
			switch(selection) {
				case 1:{
					applicationMainMenu();
					this.setBankView(3);
					break;
				}
				case 2:{
					customerInformationMenu();
					break;
				}
				case 3:{
					accountSelectionMenu(currentCustomer(this.currentUser));
					break;
				}
				case 4:{
					loggedIn = false;
					currentUser = null;
					this.setBankView(0);
					break;
				}
				default:{
					System.out.flush();
					System.out.println("That wasn't a menu choice!");
					break;
				}
				
			}
		}
	}
	
	public void applicationMainMenu() {
		boolean inMenu = true;
		while(inMenu) {
			linebreak();
			System.out.println("Application Menu");
			linebreak();
			System.out.println("1. Open account application.");
			System.out.println("2. View applications.");
			System.out.println("3. Exit");
			int selection;
			Scanner scanner = new Scanner(System.in);
			try {
				selection = Integer.parseInt(scanner.nextLine());
				} catch(NumberFormatException e) {
					System.out.println("You selection was not a number!");
					selection = -1;
				}
			switch(selection) {
				case 1:{
					openApplicationMenu();
					break;
				}
				case 2:{
					applicationSelectMenu(currentCustomer(this.currentUser));
					break;
				}
				case 3:{
					inMenu=false;
					break;
				}
				default:{
					System.out.flush();
					System.out.println("That wasn't a menu choice!");
					break;
				}
			}
		}
		
	}
	
	public void openApplicationMenu() {
		boolean inMenu = true;
		Application a = new Application(0.00, "PENDING");
		ArrayList<Customer> c = a.getCustomers();
		c.add(d.getCustomerByUsername(this.currentUser.getUserName()));
		a.setCustomers(c);
		
		while(inMenu) {
			linebreak();
			System.out.println("Apply For An Account!");
			linebreak();
			
			System.out.println("Signer: "+a.getCustomers().get(0).getFname() + " " + a.getCustomers().get(0).getLname());
			System.out.println("Initial Balance: $" + a.getBalance());
			System.out.print("Joint Customers: ");
			for(Customer i:a.getCustomers()) {
				System.out.print(i.getFname()+" " +i.getLname() + ", ");
			}
			System.out.println();
			linebreak();
			System.out.println("1. Change initial balance. ");
			System.out.println("2. Add a joint customer.");
			System.out.println("3. Submit.");
			System.out.println("4. Exit");
			int selection;
			Scanner scanner = new Scanner(System.in);
			try {
				selection = Integer.parseInt(scanner.nextLine());
				} catch(NumberFormatException e) {
					System.out.println("You selection was not a number!");
					selection = -1;
				}
			switch(selection) {
				case 1:{
					double balance = 0.00;
					String dollarInput;
					do{
						System.out.println("Input new balance (Include $): ");
						dollarInput = scanner.nextLine();
					}while(!Validation.isDollar(dollarInput));
					
					balance = dollarToDouble(dollarInput);
					a.setBalance(balance);
					break;
				}
				case 2:{
					String input;
					System.out.println("Enter a customer ID number");
					input = scanner.nextLine();
					if(d.getCustomerById(Integer.parseInt(input))==null){
						do {
							System.out.println("Enter a customer ID number");
							input = scanner.nextLine();
						}while(d.getCustomerById(Integer.parseInt(input))==null);
					}
					a.addCustomer(d.getCustomerById(Integer.parseInt(input)));
					break;
				}
				case 3:{
					d.addApplication(a);
					for(Customer customer:a.getCustomers()) {
						d.addCustomerToApplication(customer,d.getApplicationByFingerprint(a.getFingerprint()));
					}
					inMenu=false;
					break;
				}
				case 4:{
					inMenu=false;
					break;
				}
				default:{
					System.out.flush();
					System.out.println("That wasn't a menu choice!");
					break;
				}
			}
		}
	}
	
	public void applicationViewMenu(Application aa) {
		boolean inMenu = true;
		while(inMenu) {
			linebreak();
			System.out.println("Application #"+aa.getID());
			linebreak();
			System.out.println("Status: "+aa.getApproval());
			System.out.println("Signer: "+aa.getCustomers().get(0));
			System.out.println("Balance: " +aa.getBalance());
			System.out.print("Joint Customers: ");
			for(Customer c:aa.getCustomers()) {
				System.out.println(c.getFname() + " " + c.getLname()+", ");
			}
			System.out.println();
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("1. Exit.");
			
			int input = -1;
			try {
				input = Integer.parseInt(scanner.nextLine());
				} catch(NumberFormatException e) {
					System.out.println("You selection was not a number!");
					input = -1;
				}
			while(input!=1) {
				System.out.println("That was not a valid choice!");
				try {
					input = Integer.parseInt(scanner.nextLine());
					} catch(NumberFormatException e) {
						System.out.println("You selection was not a number!");
						input = -1;
					}
			}
			inMenu = false;
			
		}
	}
	public void customerInformationMenu() {
		linebreak();
		System.out.println("Information");
		linebreak();
		
		Customer c = d.getCustomerById(this.currentUser.ID);
		
		System.out.println("ID:" + c.getID());
		System.out.println("Name: "+c.getFname() + " " + c.getLname());
		System.out.println("Username: " + c.getUserName());
		System.out.println();
	}
	public void applicationSelectMenu(Customer c) {
		boolean inMenu = true;
		while(inMenu) {
			linebreak();
			System.out.println("Applications");
			linebreak();
			int selection;
			Scanner scanner = new Scanner(System.in);
			
			if(c.getApplications().size()!=0) {
				for(int i = 0;i<c.getApplications().size();i++) {
					System.out.println(i+1+". Application #" +c.getApplications().get(i).getID());
				}
				System.out.println(c.getApplications().size()+1 + ". Exit.");
				try {
					selection = Integer.parseInt(scanner.nextLine());
					} catch(NumberFormatException e) {
						System.out.println("You selection was not a number!");
						selection = -1;
					}
				
				while(!(selection > 0 && selection < c.getApplications().size()+2)) {
					System.out.println("That was not a selection!");
					try {
						selection = Integer.parseInt(scanner.nextLine());
						} catch(NumberFormatException e) {
							System.out.println("You selection was not a number!");
							selection = -1;
						}
				}
				if(selection < c.getApplications().size()+1) {
					selection = selection-1;
					applicationViewMenu(c.getApplications().get(selection));
				}
				
			} else {
				System.out.println("You have no applications!");
				System.out.println("1. Exit.");
				try {
					selection = Integer.parseInt(scanner.nextLine());
					} catch(NumberFormatException e) {
						System.out.println("You selection was not a number!");
						selection = -1;
					}
				if(selection == 1) {
					inMenu = false;
				}
			}
			if(selection == c.getApplications().size()+1) {
				inMenu = false;
			}
			
		}
		
		
	}
	
	public void accountSelectionMenu(Customer c) {
		boolean inMenu = true;
		while(inMenu) {
			
			c = d.getCustomerByUsername(c.userName);
			linebreak();
			System.out.println("Accounts");
			linebreak();
			Scanner scanner = new Scanner(System.in);
			int selection;
			
			ArrayList<Account> accounts = c.getAccounts();
			
			if(accounts.size()!=0) {
				for(int i = 0;i<accounts.size();i++) {
					System.out.println(i+1+". Account #" +accounts.get(i).getID());
				}
				System.out.println(accounts.size()+1 + ". Exit.");
				try {
					selection = Integer.parseInt(scanner.nextLine());
					} catch(NumberFormatException e) {
						System.out.println("You selection was not a number!");
						selection = -1;
					}
				
				while(!(selection > 0 && selection < accounts.size()+2)) {
					System.out.println("That was not a selection!");
					try {
						selection = Integer.parseInt(scanner.nextLine());
						} catch(NumberFormatException e) {
							System.out.println("You selection was not a number!");
							selection = -1;
						}
				}
				
				if((selection<accounts.size()+1) &&selection>0) {
					accountMenu(accounts.get(selection-1),c);
				}
				
				if(selection == accounts.size()+1) {
					inMenu = false;
				}
			} else {
				System.out.println("You have no accounts!");
				System.out.println("1. Exit.");
				try {
					selection = Integer.parseInt(scanner.nextLine());
					} catch(NumberFormatException e) {
						System.out.println("You selection was not a number!");
						selection = -1;
					}
				if(selection == 1) {
					inMenu = false;
				}
			}

		}
	}
	public void employeeMainMenu() {
		
		boolean loggedIn = true;
		
		while(loggedIn) {
			
			int selection;
			linebreak();
			System.out.println("Welcome!");
			linebreak();
			System.out.println("1. Customer Information");
			System.out.println("2. Open Applications");
			System.out.println("3. Create Customer. ");
			System.out.println("4. Exit");
				
			Scanner scanner = new Scanner(System.in);
			try {
				selection = Integer.parseInt(scanner.nextLine());
				} catch(NumberFormatException e) {
					System.out.println("You selection was not a number!");
					selection = -1;
				}
			switch(selection) {
				case 1:{
					allCustomerInformationMenu();
					break;
				}
				case 2:{
					openApplicationsMenu();
					break;
				}
				case 3:{
					
					String fname;
					String lname;
					String username;
					String password;
					
					System.out.println("Create A New User");
					linebreak();
					System.out.println("What is the customer's first name?");
					fname = scanner.nextLine();
					
					while(!(Validation.validateName(fname))) {
						System.out.println(fname.length());
						System.out.println("That is not a valid name!");
						fname=scanner.nextLine();
					}
					
					System.out.println("What is the customer's last name?");
					lname = scanner.nextLine();
					
					while(!Validation.validateName(lname)) {
						System.out.println("That is not a valid name!");
						fname=scanner.nextLine();
					}
					
					System.out.println("New Username:");
					username = scanner.nextLine();
					while(!Validation.validateUsername(username)) {
						System.out.println("That is not a valid username!");
						fname=scanner.nextLine();
					}
					System.out.println("New Password: ");
					password = scanner.nextLine();
					while(!Validation.validatePassword(password)) {
						System.out.println("That is not a valid password!");
						fname=scanner.nextLine();
					}
					Customer c = new Customer(username,password,fname,lname);
					if(d.getCustomerByUsername(username) != null) {
						
						System.out.println("That username is already taken!");
						
						do{ 
							System.out.println("New Username:");
							username = scanner.nextLine();
							while(!Validation.validateUsername(username)) {
								System.out.println("That is not a valid username!");
								fname=scanner.nextLine();
							}
							System.out.println("New Password: ");
							password = scanner.nextLine();
							while(!Validation.validatePassword(password)) {
								System.out.println("That is not a valid password!");
								fname=scanner.nextLine();
							}
							c = new Customer(username,password,fname,lname);
						
						}while( d.getCustomerByUsername(username) != null);
					}
					d.addCustomer(c);
					break;
				}
				case 4:{
					loggedIn = false;
					currentUser = null;
					this.setBankView(0);
					break;
				}
				default:{
					System.out.flush();
					System.out.println("That wasn't a menu choice!");
					break;
				}
			}
		}
		
	}
	public void allCustomerInformationMenu() {
		boolean inMenu = true;
		while(inMenu) {
			
			linebreak();
			System.out.println("Customers");
			linebreak();
			Scanner scanner = new Scanner(System.in);
			int selection;
			
			ArrayList<Customer> customers = d.getCustomers();
			
			if(customers.size()!=0) {
				for(int i = 0;i<customers.size();i++) {
					System.out.println(i+1+". Customer #" +customers.get(i).getID());
				}
				System.out.println(customers.size()+1 + ". Exit.");
				try {
					selection = Integer.parseInt(scanner.nextLine());
					} catch(NumberFormatException e) {
						System.out.println("You selection was not a number!");
						selection = -1;
					}
				
				while(!(selection > 0 && selection < customers.size()+2)) {
					System.out.println("That was not a selection!");
					try {
						selection = Integer.parseInt(scanner.nextLine());
						} catch(NumberFormatException e) {
							System.out.println("You selection was not a number!");
							selection = -1;
						}
				}
				
				if(selection<customers.size()+1) {
					employeeCustomerViewMenu(customers.get(selection-1));
				}
				if(selection == customers.size()+1) {
					inMenu = false;
				}
			} else {
				System.out.println("There are no customers!");
				System.out.println("1. Exit.");
				try {
					selection = Integer.parseInt(scanner.nextLine());
					} catch(NumberFormatException e) {
						System.out.println("You selection was not a number!");
						selection = -1;
					}
				if(selection == 1) {
					inMenu = false;
				}
			}
		}
	}
	public void employeeCustomerViewMenu(Customer c) {
		boolean inMenu = true;
		while(inMenu) {
			linebreak();
			System.out.println("Customer #"+c.getID());
			linebreak();
			System.out.println("Name: "+c.getFname() + " " + c.getLname());
			System.out.println("Username: " +c.getUserName());
			System.out.println("1: Accounts");
			System.out.println("2: Applications");
			System.out.println("3. Edit Customer Information");
			System.out.println("4. Delete Customer.");
			System.out.println("5. Exit");
			
			Scanner scanner = new Scanner(System.in);
			int selection = -1;
			try {
				selection = Integer.parseInt(scanner.nextLine());
				} catch(NumberFormatException e) {
					System.out.println("You selection was not a number!");
					selection = -1;
				}
			
			switch(selection) {
			case 1:
				accountSelectionMenu(c);
				break;
			case 2:
				applicationSelectMenu(c);
				break;
			case 3:
				editCustomer(c);
				break;
			case 4:
				d.deleteCustomer(c);
				inMenu=false;
				break;
			case 5:
				inMenu=false;
				break;
			default:
				System.out.println("That was not a selection!");
				break;
			}
		}
	}

	public void openApplicationsMenu() {
		boolean inMenu = true;
		while(inMenu) {
			
			linebreak();
			System.out.println("Open Applications");
			linebreak();
			Scanner scanner = new Scanner(System.in);
			int selection;
			
			ArrayList<Application> openapplications = new ArrayList<Application>();
		
			for(Application a:d.getApplications()) {
				if(a.getApproval().equals("PENDING")) {
					d.applicationLoadCustomers(a);
					openapplications.add(a);
				}
			}
			
			if(openapplications.size()!=0) {
				for(int i = 0;i<openapplications.size();i++) {
					System.out.println(i+1+". Application #" +openapplications.get(i).getID());
				}
				System.out.println(openapplications.size()+1 + ". Exit.");
				try {
					selection = Integer.parseInt(scanner.nextLine());
					} catch(NumberFormatException e) {
						System.out.println("You selection was not a number!");
						selection = -1;
					}
				
				while(!(selection > 0 && selection < openapplications.size()+2)) {
					System.out.println("That was not a selection!");
					try {
						selection = Integer.parseInt(scanner.nextLine());
						} catch(NumberFormatException e) {
							System.out.println("You selection was not a number!");
							selection = -1;
						}
				}
				
				if(selection<openapplications.size()+1) {
					employeeApplicationsView(openapplications.get(selection-1));
				}
				if(selection == openapplications.size()+1) {
					inMenu = false;
				}
			} else {
				System.out.println("There are no open applications!");
				System.out.println("1. Exit.");
				try {
					selection = Integer.parseInt(scanner.nextLine());
					} catch(NumberFormatException e) {
						System.out.println("You selection was not a number!");
						selection = -1;
					}
				if(selection == 1) {
					inMenu = false;
				}
			}
		}
	}
	public void employeeApplicationsView(Application a) {
		boolean inMenu = true;
		while(inMenu) {
			linebreak();
			System.out.println("Application #"+a.getID());
			linebreak();
			System.out.println("Status: "+a.getApproval());
			System.out.println("Signer: "+a.getCustomers().get(0));
			System.out.println("Balance: " +a.getBalance());
			System.out.print("Joint Customers: ");
			for(Customer c:a.getCustomers()) {
				System.out.println(c.getFname() + " " + c.getLname()+", ");
			}
			System.out.println();
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("1. Approve Application");
			System.out.println("2. Deny Application");
			System.out.println("3. Exit.");
			int selection = -1;
			try {
				selection = Integer.parseInt(scanner.nextLine());
				} catch(NumberFormatException e) {
					System.out.println("You selection was not a number!");
					selection = -1;
				}
			switch(selection) {
			case 1:
				a.setApproval("APPROVED");
				d.updateApplication(a);
				Account acc = new Account(a.getBalance(),"OPEN");
				for(Customer c:a.getCustomers()) {
					c.addAccount(acc);
				}
				for(Customer c:a.getCustomers()) {
					acc.addCustomer(c);
				}
				d.addAccount(acc);
				ArrayList<Customer> g = d.getCustomers();
				acc = d.getAccountByFingerprint(acc.getFingerprint());
				for(Customer c:g) {
					d.addCustomerToAccount(c, acc);
				}
				d.updateAccount(acc);
				break;
			case 2:
				a.setApproval("DENIED");
				d.updateApplication(a);
				break;
			case 3:
				inMenu = false;
				break;
			}	
			
		}
	}
	public void accountMenu(Account a,Customer c) {
		boolean inMenu = true;
		while(inMenu) {
			linebreak();
			System.out.println("Account #"+a.getID());
			linebreak();
			
			Scanner scanner = new Scanner(System.in);
			String s;
			a = d.getAccountByFingerprint(a.getFingerprint());
			d.accountLoadCustomers(a);			
			if(a.getStatus().equals("OPEN")&&currentUser.isCustomer()) {
				System.out.println("ID: "+a.getID());
				System.out.println("Balance: "+a.getBalance());
				System.out.println("Signer: "+a.getCustomers().get(0).getFname() + " "+ a.getCustomers().get(0).getLname());
				System.out.println("Status: "+a.getStatus());
				
				System.out.print("Joint Customers: ");
				for(Customer c1:a.getCustomers()) {
					System.out.print(c1.getFname() + " " + c1.getLname() + ", ");
				}
				
				System.out.println("ID: "+a.getID());
				System.out.println("1. Deposit.");
				System.out.println("2. Transfer. ");
				System.out.println("3. Widthdraw. ");
				System.out.println("4. Transaction History. ");
				System.out.println("5. Delete Account. ");
				System.out.println("6. Exit");
				int selection = -1;
				try {
					selection = Integer.parseInt(scanner.nextLine());
					} catch(NumberFormatException e) {
						System.out.println("You selection was not a number!");
						selection = -1;
					}
				
				switch(selection) {
				case 1:
					depositMenu(a,c);
					break;
				case 2:
					transferMenu(a,c);
					break;
				case 3:
					withdrawMenu(a,c);
					break;
				case 4:
					transactionMenu(a);
					break;
				case 5:
					if(a.getBalance()==0) {
						d.deleteAccount(a);			
						c.removeAccount(a);
						System.out.println("Account deleted, PLEASE EXIT THE ACCOUNT MENU TO REFRESH!");
						inMenu=false;
					}
					else {
						System.out.println("This account is not empty and cannot be deleted!");
					}
					break;
				case 6:
					inMenu = false;
					break;
				default:
					System.out.println("That was not a valid choice!");
				
				}
				
			}
			
			
			if(a.getStatus().equals("CLOSED")&&currentUser.isCustomer()) {
				System.out.println("ID: "+a.getID());
				System.out.println("Balance: "+a.getBalance());
				System.out.println("Signer: "+a.getCustomers().get(0).getFname() + " "+ a.getCustomers().get(0).getLname());
				System.out.println("Status: "+a.getStatus());
				
				System.out.print("Joint Customers: ");
				for(Customer c1:a.getCustomers()) {
					System.out.print(c1.getFname() + " " + c1.getLname() + ", ");
				}
				
				System.out.println("ID: "+a.getID());
				System.out.println("1. Transaction History");
				System.out.println("2. Exit");
				int selection = -1;
				try {
					selection = Integer.parseInt(scanner.nextLine());
					} catch(NumberFormatException e) {
						System.out.println("You selection was not a number!");
						selection = -1;
					}
				
				switch(selection) {
				case 1:
					transactionMenu(a);
					break;
				case 2:
					inMenu = false;
					break;
				default:
					System.out.println("That was not a valid choice!");
				
				}
				
			}
			
			
			
			if(currentUser.isEmployee()) {
				System.out.println("ID: "+a.getID());
				System.out.println("Balance: "+a.getBalance());
				a = d.getAccountByFingerprint(a.getFingerprint());
				d.accountLoadCustomers(a);
				System.out.println("Signer: "+a.getCustomers().get(0).getFname() + " "+ a.getCustomers().get(0).getLname());
				System.out.println("Status: "+a.getStatus());
				
				System.out.print("Joint Customers: ");
				for(Customer c1:a.getCustomers()) {
					System.out.print(c1.getFname() + " " + c1.getLname() + ", ");
				}
				
				System.out.println("1. Transaction History");
				System.out.println("2. Exit");
				int selection = -1;
				try {
					selection = Integer.parseInt(scanner.nextLine());
					} catch(NumberFormatException e) {
						System.out.println("You selection was not a number!");
						selection = -1;
					}
				
				switch(selection) {
				case 1:
					transactionMenu(a);
					break;
				case 2:
					inMenu=false;
					break;
				default:
					System.out.println("That was not a valid choice!");
				}
			}
			if(currentUser.isAdmin()) {
				System.out.println("ID: "+a.getID());
				System.out.println("Balance: "+a.getBalance());
				System.out.println("Signer: "+a.getCustomers().get(0).getFname() + " "+ a.getCustomers().get(0).getLname());
				System.out.println("Status: "+a.getStatus());
				
				System.out.print("Joint Customers: ");
				for(Customer c1:a.getCustomers()) {
					System.out.print(c1.getFname() + " " + c1.getLname() + ", ");
				}
				System.out.println();
				System.out.println("1. Deposit.");
				System.out.println("2. Transfer. ");
				System.out.println("3. Widthdraw. ");
				System.out.println("4. Transaction History");
				System.out.println("5. Close");
				System.out.println("6. Exit");
				int selection = -1;
				try {
					selection = Integer.parseInt(scanner.nextLine());
					} catch(NumberFormatException e) {
						System.out.println("You selection was not a number!");
						selection = -1;
					}
				
				switch(selection) {
				case 1:
					depositMenu(a,c);
					break;
				case 2:
					transferMenu(a,c);
					break;
				case 3:
					withdrawMenu(a,c);
					break;
				case 4:
					transactionMenu(a);
					break;
				case 5:
					a.closeAccount();
					d.addCustomer(c);
					for(Customer cs: a.getCustomers()) {
						d.addCustomer(cs);
					}
					break;
				case 6:
					inMenu = false;
					break;
				}
			}
		}
	}
	public void adminMainMenu() {
		

		boolean loggedIn = true;
		
		while(loggedIn) {
			
			int selection;
			linebreak();
			System.out.println("Welcome!");
			linebreak();
			System.out.println("1. Customer Information");
			System.out.println("2. Open Applications");
			System.out.println("3. Exit");
				
			Scanner scanner = new Scanner(System.in);
			try {
				selection = Integer.parseInt(scanner.nextLine());
				} catch(NumberFormatException e) {
					System.out.println("You selection was not a number!");
					selection = -1;
				}
			switch(selection) {
				case 1:{
					allCustomerInformationMenu();
					break;
				}
				case 2:{
					openApplicationsMenu();
					break;
				}
				case 3:{
					loggedIn = false;
					currentUser = null;
					this.setBankView(0);
					break;
				}
				default:{
					System.out.flush();
					System.out.println("That wasn't a menu choice!");
					break;
				}
			}
		}
		
	}
	public void depositMenu(Account a,Customer c) {
		boolean inMenu = true;
		while(inMenu) {
			Scanner scanner = new Scanner(System.in);
			String s = new String();
			double amount = 0;
			int ID = 0;
			
			do{
					System.out.println("Enter Amount (Include $): ");
					s = scanner.nextLine();
					amount = dollarToDouble(s);
			}
			while(!Validation.isDollar(s));
			Date date = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
			Transaction t = new Transaction(date.toString(),"APPROVED","DEPOSIT",
					a.getID(),0, amount,a.getBalance()+amount);
			
			d.addTransaction(t);
			a.deposit(amount,t);
			d.updateAccount(a);
			inMenu=false;
		}
	}
	
	public void withdrawMenu(Account a,Customer c) {
		boolean inMenu = true;
		while(inMenu) {
			Scanner scanner = new Scanner(System.in);
			String s = new String();
			double amount = 0;
			int ID = 0;
			
			do{
					System.out.println("Enter Amount (Include $): ");
					s = scanner.nextLine();
					amount = dollarToDouble(s);
			}
			while(!Validation.isDollar(s));
			
			if(a.canWithdraw(amount)) {
				Date date = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
				Transaction t = new Transaction(date.toString(),"APPROVED","WITHDRAW",
						a.getID(),0, amount,a.getBalance()-amount);
				
				d.addTransaction(t);
				a.withdraw(amount,t);
				a.addTransaction(t);
				d.updateAccount(a);
				inMenu=false;
			}
			else {
				inMenu=false;
			}
		}
	}
	public void transferMenu(Account a,Customer c) {
		boolean inMenu = true;
		while(inMenu) {
			Scanner scanner = new Scanner(System.in);
			String s = new String();
			double amount = 0;
			int ID = 0;
			
			do{
					System.out.println("Enter Amount (Include $): ");
					s = scanner.nextLine();
					amount = dollarToDouble(s);
			}
			while(!Validation.isDollar(s));
			do {
					System.out.println("Enter Account Number #:");
					s = scanner.nextLine();
					ID = Integer.parseInt(s);
			}while(!isAccount(ID));
			
			if(a.canTransfer(amount)) {
				
				Date date = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
				Transaction t1 = new Transaction(date.toString(),"APPROVED","TRANSFER",
						a.getID(),ID, amount,a.getBalance()-amount);
				Transaction t2 = new Transaction(date.toString(),"APPROVED","TRANSFER",
						a.getID(),ID, amount,a.getBalance()+amount);
				
				d.addTransaction(t1);
				d.addTransaction(t2);
				a.transfer(amount,t1);
				Account acc = d.getAccountById(ID);
				acc.receiveTransfer(amount);
				a.addTransaction(t1);
				acc.addTransaction(t2);
				d.updateAccount(a);
				d.updateAccount(acc);
				inMenu=false;
			}
			else {
				inMenu=false;
			}

			
			inMenu=false;
		}
	}
	public void transactionMenu(Account a) {
		boolean inMenu = true;
		while(inMenu) {
			linebreak();
			
			System.out.println("Transaction History");
			d.accountLoadTransaction(a);
			linebreak();
			Scanner scanner = new Scanner(System.in);
			System.out.println("1. Exit.");
			for(Transaction t:a.getTransactions()) {
				System.out.println(t);
			}
			int selection = -1;
			try {
				selection = Integer.parseInt(scanner.nextLine());
				} catch(NumberFormatException e) {
					System.out.println("You selection was not a number!");
					selection = -1;
				}
			if(selection == 1) {
				inMenu=false;
			}
		}
	}
	
	public void editCustomer(Customer c) {
		boolean inMenu = true;
		while(inMenu) {
			System.out.println("1. Edit First Name. ");
			System.out.println("2. Edit Last Name. ");
			System.out.println("3. Edit Username. ");
			System.out.println("4. Edit Password. ");
			System.out.println("5. Exit. ");
			
			Scanner scanner = new Scanner(System.in);
			int selection = -1;
			try {
				selection = Integer.parseInt(scanner.nextLine());
				} catch(NumberFormatException e) {
					System.out.println("You selection was not a number!");
					selection = -1;
				}
			switch(selection) {
			case 1:
				String fname;
				System.out.println("What is the new first name?");
				fname = scanner.nextLine();
				
				while(!(Validation.validateName(fname))) {
					System.out.println(fname.length());
					System.out.println("That is not a valid name!");
					fname=scanner.nextLine();
				}
				c.setFname(fname);
				d.updateCustomer(c);
				break;
			case 2:
				String lname;
				System.out.println("What is the new last name?");
				lname = scanner.nextLine();
				
				while(!(Validation.validateName(lname))) {
					System.out.println(lname.length());
					System.out.println("That is not a valid name!");
					lname=scanner.nextLine();
				}
				c.setLname(lname);
				d.updateCustomer(c);
				break;
			case 3:
				String username;
				System.out.println("New Username:");
				username = scanner.nextLine();
				while(!Validation.validateUsername(username)) {
					System.out.println("That is not a valid username!");
					fname=scanner.nextLine();
				}
				c.setUserName(username);
				d.updateCustomer(c);
				break;
			case 4:
				String password;
				System.out.println("New Password: ");
				password = scanner.nextLine();
				while(!Validation.validatePassword(password)) {
					System.out.println("That is not a valid password!");
					fname=scanner.nextLine();
				}
				c.setPassWord(password);
				d.updateCustomer(c);
				break;
			case 5:
				inMenu=false;
				break;
			default:
				System.out.println("That was not a selection!");
				break;
			}
		}
	}
	private static void linebreak() {
		String linebreak = "==========================================";
		System.out.println(linebreak);
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public int getBankView() {
		return bankView;
	}

	public void setBankView(int bankView) {
		this.bankView = bankView;
	}
	
	public double dollarToDouble(String s) {
		String d = s.substring(1, s.length());
		return Double.parseDouble(d);
	}
	
	public boolean isAccount(int ID) {		
		ArrayList<Customer> customers = d.getCustomers();
		
		for(Customer c:customers) {
			for(Account a:c.getAccounts()) {
				if(a.getID()==ID) {
					return true;
				}
			}
		}
		System.out.println("The account does not exits!");
		return false;
	}
	public Account getAccount(int ID) {
		ArrayList<Customer> customers = d.getCustomers();
		for(Customer c:customers) {
			for(Account a:c.getAccounts()) {
				if(a.getID()==ID) {
					return a;
				}
			}
		}
		return null;
	}
	public Customer currentCustomer(User c) {
		return d.getCustomerById(this.currentUser.getID());
	}
	
}
