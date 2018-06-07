package com.revature.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

import com.revature.DAO.CustomerDAO;
import com.revature.DAO.CustomerSerializer;
import com.revature.database.Database;
import com.revature.validation.Validation;

public class Bank implements Serializable {
	
	private Database d;
	private boolean isOpen = false;
	private int bankView = 0;
	private User currentUser;
	
	public Bank() {
		this.isOpen = true;
	}
	
	/*
	 *Simply instantiates a Database object and adds and employee and admin account 
	 */
	public void connect() {
		d = new Database();
		Employee e1 = new Employee("employee","employee","Employee","Employee");
		e1.makeEmployee();
		d.updateEmployee(e1);
		Employee e2 = new Employee("admin","admin","Admin","Admin");
		e2.makeAdmin();
		d.updateEmployee(e2);
	}
	
	/*
	 * Starts the basic menu system and allows for three branches after login, customer, employee, and admin.
	 */
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
	/*
	 * The welcome menu, allows the user to login or choose to create a new customer account.
	 */
	public void welcomeMenu() {
		int selection;
		System.out.flush();
		System.out.println("Welcome!");
		linebreak();
		System.out.println("1. New User Registration");
		System.out.println("2. Log in");
		System.out.println("3. Exit");
			
		Scanner scanner = new Scanner(System.in);
		selection = Integer.parseInt(scanner.nextLine());
			
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
	
	/*
	 * The new user menu, simply prompts the user for a username, password and name. Performs
	 * basic input validation.
	 */
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
		System.out.println(d.getCustomer(username));
		
		if(d.getCustomer(username) != null) {
			
			System.out.println("That username is alr1eady taken!");
			
			do{ 
				System.out.println("New Username:");
				username = scanner.nextLine();
				while(!Validation.validateUsername(fname)) {
					System.out.println("That is not a valid username!");
					fname=scanner.nextLine();
				}
				System.out.println("New Password: ");
				password = scanner.nextLine();
				while(!Validation.validatePassword(fname)) {
					System.out.println("That is not a valid password!");
					fname=scanner.nextLine();
				}
				c = new Customer(username,password,fname,lname);
			
			}while( d.getCustomer(username) != null);
		}
		currentUser = c;
		d.updateCustomer(c);
		linebreak();
		
		this.setBankView(3);
	}
	
	/*
	 * The login menu, prompts the user for a username and password.
	 */
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
		
		if(d.getCustomer(username)!=null) {
			if(d.getCustomer(username).getPassWord().equals(password)) {
				System.out.println("Logged in");
				this.setBankView(3);
				this.currentUser = d.getCustomer(username);
			}
		}
		
		else if(d.getEmployee(username)!=null) {
			if(d.getEmployee(username).getPassWord().equals(password)) {
				System.out.println("Logged in");
				this.setBankView(3);
				this.currentUser = d.getEmployee(username);
			}
		}
		else {
			this.setBankView(0);
		}
		
	}
	
	/*
	 * The main menu for the customer menu branch.
	 */
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
			selection = Integer.parseInt(scanner.nextLine());
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
	/*
	 * The customer application menu, allows for the customer to open new applications and add
	 * other users for joint accounts. Applications must be approved by an employee or admin.
	 */
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
			selection = Integer.parseInt(scanner.nextLine());
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
	/*
	 * The open application customer menu. Allows the user to fill in the information required to 
	 * open an application.
	 */
	public void openApplicationMenu() {
		boolean inMenu = true;
		Application a = new Application(d.getCustomer(this.currentUser.getUserName()), 0.00, new ArrayList<Customer>());
		ArrayList<Customer> c = a.getCustomers();
		c.add(d.getCustomer(this.currentUser.getUserName()));
		a.setCustomers(c);
		
		while(inMenu) {
			linebreak();
			System.out.println("Apply For An Account!");
			linebreak();
			
			System.out.println("Signer: "+a.getSigner().getFname() + " " + a.getSigner().getLname());
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
			selection = Integer.parseInt(scanner.nextLine());
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
					if(d.getCustomer(Integer.parseInt(input))==null){
						do {
							System.out.println("Enter a customer ID number");
							input = scanner.nextLine();
						}while(d.getCustomer(Integer.parseInt(input))==null);
					}
					a.getCustomers().add(d.getCustomer(Integer.parseInt(input)));
					break;
				}
				case 3:{
					System.out.println(a);
					
					ArrayList<Application> ab = currentCustomer(this.currentUser).getApplications();
					ab.add(a);
					currentCustomer(this.currentUser).setApplications(ab);
					
					
					d.updateCustomer(currentCustomer(this.currentUser));
					for(Customer c2: d.getAllCustomers()) {
						System.out.println(c2);
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
			System.out.println("Signer: "+aa.getSigner());
			System.out.println("Balance: " +aa.getBalance());
			System.out.print("Joint Customers: ");
			for(Customer c:aa.getCustomers()) {
				System.out.println(c.getFname() + " " + c.getLname()+", ");
			}
			System.out.println();
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("1. Exit.");
			
			String s = scanner.nextLine();
			
			int input = Integer.parseInt(s);
			while(input!=1) {
				System.out.println("That was not a valid choice!");
				s = scanner.nextLine();
				input = Integer.parseInt(s);
			}
			inMenu = false;
			
		}
	}
	public void customerInformationMenu() {
		linebreak();
		System.out.println("Information");
		linebreak();
		
		Customer c = d.getCustomer(currentUser.ID);
		
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
				String input;
				input = scanner.nextLine();
				selection = Integer.parseInt(input);
				
				while(!(selection > 0 && selection < c.getApplications().size()+2)) {
					System.out.println("That was not a selection!");
					input = scanner.nextLine();
					selection = Integer.parseInt(input);
				}
				if(selection < c.getApplications().size()+1) {
					selection = selection-1;
					applicationViewMenu(c.getApplications().get(selection));
				}
				
			} else {
				System.out.println("You have no applications!");
				System.out.println("1. Exit.");
				String input = scanner.nextLine();
				selection = Integer.parseInt(input);
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
			
			linebreak();
			System.out.println("Accounts");
			linebreak();
			Scanner scanner = new Scanner(System.in);
			int selection;
			
			
			if(c.getAccounts().size()!=0) {
				for(int i = 0;i<c.getAccounts().size();i++) {
					System.out.println(i+1+". Account #" +c.getAccounts().get(i).getID());
				}
				System.out.println(c.getAccounts().size()+1 + ". Exit.");
				String input;
				input = scanner.nextLine();
				selection = Integer.parseInt(input);
				
				while(!(selection > 0 && selection < c.getAccounts().size()+2)) {
					System.out.println("That was not a selection!");
					input = scanner.nextLine();
					selection = Integer.parseInt(input);
				}
				
				if((selection<c.getAccounts().size()+1) &&selection>0) {
					AccountMenu(c.getAccounts().get(selection-1),c);
				}
				
				if(selection == c.getAccounts().size()+1) {
					inMenu = false;
				}
			} else {
				System.out.println("You have no accounts!");
				System.out.println("1. Exit.");
				String input = scanner.nextLine();
				selection = Integer.parseInt(input);
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
			System.out.println("3. Exit");
				
			Scanner scanner = new Scanner(System.in);
			selection = Integer.parseInt(scanner.nextLine());
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
	public void allCustomerInformationMenu() {
		boolean inMenu = true;
		while(inMenu) {
			
			linebreak();
			System.out.println("Customers");
			linebreak();
			Scanner scanner = new Scanner(System.in);
			int selection;
			
			ArrayList<Customer> customers = d.getAllCustomers();
			
			if(customers.size()!=0) {
				for(int i = 0;i<customers.size();i++) {
					System.out.println(i+1+". Customer #" +customers.get(i).getID());
				}
				System.out.println(customers.size()+1 + ". Exit.");
				String input;
				input = scanner.nextLine();
				selection = Integer.parseInt(input);
				
				while(!(selection > 0 && selection < customers.size()+2)) {
					System.out.println("That was not a selection!");
					input = scanner.nextLine();
					selection = Integer.parseInt(input);
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
				String input = scanner.nextLine();
				selection = Integer.parseInt(input);
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
			System.out.println("3. Exit");
			
			Scanner scanner = new Scanner(System.in);
			String s = scanner.nextLine();
			int selection = Integer.parseInt(s);
			
			switch(selection) {
			case 1:
				accountSelectionMenu(c);
				break;
			case 2:
				applicationSelectMenu(c);
				break;
			case 3:
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
			
			ArrayList<Customer> customers = d.getAllCustomers();
			ArrayList<Application> openapplications = new ArrayList<Application>();
			
			for(Customer c:customers) {
				for(Application a:c.getApplications()) {
					if(a.getApproval().equals("PENDING")) {
						openapplications.add(a);
					}
				}
			}
			
			if(openapplications.size()!=0) {
				for(int i = 0;i<openapplications.size();i++) {
					System.out.println(i+1+". Application #" +openapplications.get(i).getID());
				}
				System.out.println(openapplications.size()+1 + ". Exit.");
				String input;
				input = scanner.nextLine();
				selection = Integer.parseInt(input);
				
				while(!(selection > 0 && selection < openapplications.size()+2)) {
					System.out.println("That was not a selection!");
					input = scanner.nextLine();
					selection = Integer.parseInt(input);
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
				String input = scanner.nextLine();
				selection = Integer.parseInt(input);
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
			System.out.println("Signer: "+a.getSigner());
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
			
			String s = scanner.nextLine();
			int selection = Integer.parseInt(s);
			switch(selection) {
			case 1:
				a.setApproval("APPROVED");
				Account acc = new Account(a.getBalance(),a.getSigner(),a.getCustomers());
				for(Customer c:a.getCustomers()) {
					c.addAccount(acc);
					d.updateCustomer(c);
				}
				a.getSigner().addAccount(acc);
				d.updateCustomer(a.getSigner());
				break;
			case 2:
				a.setApproval("DENIED");
				d.updateCustomer(a.getSigner());
				break;
			case 3:
				inMenu = false;
				break;
			}	
			
		}
	}
	public void AccountMenu(Account a,Customer c) {
		boolean inMenu = true;
		while(inMenu) {
			linebreak();
			System.out.println("Account #"+a.getID());
			linebreak();
			
			Scanner scanner = new Scanner(System.in);
			String s;
			
			if(a.getStatus().equals("OPEN")&&currentUser.isCustomer()) {
				System.out.println("ID: "+a.getID());
				System.out.println("Balance: "+a.getBalance());
				System.out.println("Signer: "+a.getSigner());
				System.out.println("Status: "+a.getStatus());
				
				System.out.print("Joint Customers: ");
				for(Customer c1:a.getCustomers()) {
					System.out.print(c1.getFname() + " " + c1.getLname() + ", ");
				}
				
				System.out.println("ID: "+a.getID());
				System.out.println("1. Deposit.");
				System.out.println("2. Transfer. ");
				System.out.println("3. Widthdraw. ");
				System.out.println("4. Transaction History");
				System.out.println("5. Exit");
				s=scanner.nextLine();
				int input = Integer.parseInt(s);
				
				switch(input) {
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
					inMenu = false;
					break;
				default:
					System.out.println("That was not a valid choice!");
				
				}
				
			}
			
			
			if(a.getStatus().equals("CLOSED")&&currentUser.isCustomer()) {
				System.out.println("ID: "+a.getID());
				System.out.println("Balance: "+a.getBalance());
				System.out.println("Signer: "+a.getSigner());
				System.out.println("Status: "+a.getStatus());
				
				System.out.print("Joint Customers: ");
				for(Customer c1:a.getCustomers()) {
					System.out.print(c1.getFname() + " " + c1.getLname() + ", ");
				}
				
				System.out.println("ID: "+a.getID());
				System.out.println("1. Transaction History");
				System.out.println("2. Exit");
				s=scanner.nextLine();
				int input = Integer.parseInt(s);
				
				switch(input) {
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
				System.out.println("Signer: "+a.getSigner());
				System.out.println("Status: "+a.getStatus());
				
				System.out.print("Joint Customers: ");
				for(Customer c1:a.getCustomers()) {
					System.out.print(c1.getFname() + " " + c1.getLname() + ", ");
				}
				
				System.out.println("1. Transaction History");
				System.out.println("2. Exit");
				s=scanner.nextLine();
				int input = Integer.parseInt(s);
				
				switch(input) {
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
				System.out.println("Signer: "+a.getSigner());
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
				s=scanner.nextLine();
				int input = Integer.parseInt(s);
				
				switch(input) {
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
					d.updateCustomer(c);
					for(Customer cs: a.getCustomers()) {
						d.updateCustomer(cs);
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
			selection = Integer.parseInt(scanner.nextLine());
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
			
			a.deposit(amount);
			d.updateCustomer(c);
			for(Customer cs:a.getCustomers()) {
				d.updateCustomer(cs);
			}
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
			while(!Validation.isDollar(s)|!a.canWithdraw(amount));
			
			a.withdraw(amount);
			d.updateCustomer(c);
			for(Customer cs:a.getCustomers()) {
				d.updateCustomer(cs);
			}
			inMenu=false;
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
			while(!Validation.isDollar(s)|!a.canTransfer(amount));
			do {
					System.out.println("Enter Account Number #:");
					s = scanner.nextLine();
					ID = Integer.parseInt(s);
			}while(!isAccount(ID));
			
			a.transfer(getAccount(ID),amount);
			d.updateCustomer(c);
			for(Customer cs:a.getCustomers()) {
				d.updateCustomer(cs);
			}
			for(Customer c1:getAccount(ID).getCustomers()) {
				d.updateCustomer(c1);
			}
			inMenu=false;
		}
	}
	public void transactionMenu(Account a) {
		boolean inMenu = true;
		while(inMenu) {
			linebreak();
			System.out.println("Transaction History");
			linebreak();
			Scanner scanner = new Scanner(System.in);
			System.out.println("1. Exit.");
			for(Transaction t:a.getTransactions()) {
				System.out.println(t);
			}
			String s = scanner.nextLine();
			int selection = Integer.parseInt(s);
			if(selection == 1) {
				inMenu=false;
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
		ArrayList<Customer> customers = d.getAllCustomers();
		
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
		ArrayList<Customer> customers = d.getAllCustomers();
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
		return d.getLoadedCustomer(this.currentUser.getID());
	}
}
