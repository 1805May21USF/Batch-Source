package com.revature.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

import com.revature.DAO.CustomerDAO;
import com.revature.DAO.CustomerSerializer;
import com.revature.comparators.ApplicationIdComparator;
import com.revature.comparators.UserUsernameComparator;
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
	public void connect() {
		d = new Database();
		Employee e1 = new Employee("employee","employee","Employee","Employee");
		e1.makeEmployee();
		d.updateEmployee(e1);
		Employee e2 = new Employee("admin","admin","Admin","Admin");
		e2.makeAdmin();
		d.updateEmployee(e2);
		
		Customer c1 = new Customer("corwin","lester","Corwin","Lester");
		
		ArrayList<Customer> cs = new ArrayList<Customer>();
		cs.add(c1);
		
		Account a = new Account(100.00,c1,cs);
		ArrayList<Account> as = new ArrayList<Account>();
		as.add(a);
		
		c1.setAccounts(as);
		
		ArrayList<Customer> csa = new ArrayList<Customer>();
		cs.add(c1);
		
		Application ap = new Application(c1,0.0,csa);
		ArrayList<Application> asa = new ArrayList<Application>();
		asa.add(ap);
		
		c1.setApplications(asa);
		
		d.updateCustomer(c1);
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
					if(currentUser.isCustomer()) {
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
					linebreak();
					System.out.println("Information");
					linebreak();
					Customer currentCustomer = d.getCustomer(this.currentUser.ID);
					System.out.println("ID: "+currentCustomer.getID());
					System.out.println("Name: " + currentCustomer.getFname() + " " +currentCustomer.getLname());
					System.out.println("Username: " + currentUser.getUserName());
					break;
				}
				case 3:{
					accountSelectionMenu();
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
			selection = Integer.parseInt(scanner.nextLine());
			switch(selection) {
				case 1:{
					openApplicationMenu();
					break;
				}
				case 2:{
					applicationSelectMenu();
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
			System.out.println("3. View open applications.");
			System.out.println("4. Submit.");
			System.out.println("5. Exit");
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
					break;
				}
				case 4:{
					break;
				}
				case 6:{
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
	
	public void applicationViewMenu(int ID) {
		boolean inMenu = true;
		while(inMenu) {
			linebreak();
			System.out.println("Application #"+ID);
			linebreak();
			
			
			
			System.out.print("Signer: " +)
		}
	}
	
	public void applicationSelectMenu() {
		boolean inMenu = true;
		while(inMenu) {
			linebreak();
			System.out.println("Applications");
			linebreak();
			int selection;
			Scanner scanner = new Scanner(System.in);
			
			Customer currentCustomer = d.getCustomer(this.currentUser.ID);
			if(currentCustomer.getApplications().size()!=0) {
				for(int i = 0;i<currentCustomer.getApplications().size();i++) {
					System.out.println(i+1+". Application #" +currentCustomer.getApplications().get(i).getID());
				}
				System.out.println(currentCustomer.getApplications().size()+1 + ". Exit.");
				String input;
				input = scanner.nextLine();
				selection = Integer.parseInt(input);
				
				while(!(selection > 0 && selection < currentCustomer.getApplications().size()+2)) {
					System.out.println("That was not a selection!");
					input = scanner.nextLine();
					selection = Integer.parseInt(input);
				}
				
				selection = selection-1;
				applicationViewMenu(currentCustomer.getApplications().get(selection).getID());
				
			} else {
				System.out.println("You have no applications!");
				System.out.println("1. Exit.");
				String input = scanner.nextLine();
				selection = Integer.parseInt(input);
				if(selection == 1) {
					inMenu = false;
				}
			}
			if(selection == currentCustomer.getApplications().size()+1) {
				inMenu = false;
			}
			
		}
		
		
	}
	
	public void accountSelectionMenu() {
		boolean inMenu = true;
		while(inMenu) {
			
			linebreak();
			System.out.println("Accounts");
			linebreak();
			Scanner scanner = new Scanner(System.in);
			int selection;
			
			
			Customer currentCustomer = d.getCustomer(this.currentUser.ID);
			if(currentCustomer.getAccounts().size()!=0) {
				for(int i = 0;i<currentCustomer.getAccounts().size();i++) {
					System.out.println(i+1+". Account #" +currentCustomer.getAccounts().get(i).getID());
				}
				System.out.println(currentCustomer.getAccounts().size()+1 + ". Exit.");
				String input;
				input = scanner.nextLine();
				selection = Integer.parseInt(input);
				
				while(!(selection > 0 && selection < currentCustomer.getAccounts().size()+2)) {
					System.out.println("That was not a selection!");
					input = scanner.nextLine();
					selection = Integer.parseInt(input);
				}
				
				
				if(selection == currentCustomer.getAccounts().size()+1) {
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
					applicationMainMenu();
					this.setBankView(3);
					break;
				}
				case 2:{
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
	public void adminMainMenu() {
		
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
		String d = s.substring(1, s.length()-1);
		return Double.parseDouble(d);
	}

}
