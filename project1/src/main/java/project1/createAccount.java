package project1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class createAccount {
	
	ArrayList<String> userNames;
	Account acc;
	static DoSerialization DS;
	Customer customer;
	ArrayList<Customer> c = new ArrayList();
	/*
	 * A Constructor for the Bank class
	 */
	public createAccount() {
		// TODO Auto-generated constructor stub
		this.userNames = new ArrayList<>();
		this.acc = new Account();
		this.DS = new DoSerialization();
		c = new ArrayList<>();
		Intro();
	}
	
	/*
	 * A method that prompts the user to register in a bank
	 * @Param none
	 * @return none
	 */
	public void Intro() {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		System.out.println("");
		System.out.println("Hi Welcome to JLukim Federal Credit Union (JFCU)");
		System.out.println("Enter 1: To open an account");
		System.out.println("      2: To sign in as a customer");
		System.out.println("      3: To sign in as an employee");
		System.out.print("      4: To exit: ");
		String choice = sc.next();
		
		switch(choice){
		case "1": System.out.println("");
				  openAccount(sc, rand);
		break;
		case "2": System.out.println("");
				  System.out.print("Please Enter Your User Name: ");
				  String user = sc.next();
				  System.out.print("Please Enter Your Password: ");
				  String password = sc.next();
				  customerSignIn(user, password, sc);
		break;
		case "3": employeeSignIn(sc);
		break;
		case "4":System.out.println("");
				 System.out.println("Thank you for visiting JLukim Federal Credit Union");
				 //DS.serialize(c, "src/main/java/project1/filename.ser");
				 System.exit(0);
		break;
		default: System.out.println("");
				 System.out.println("\"" +choice + "\"" + " is not an acceptable input!");
				 Intro();
				 System.exit(1);
		}
	}
	
	public void openAccount(Scanner sc, Random rand){
		System.out.println("");
		System.out.println("Opening an Account: ");
		System.out.print("Enter Your First Name: ");
		String firstName = sc.next();
		System.out.print("Enter Your Last Name: ");
		String lastName = sc.next();
		System.out.print("Enter Your User Name: ");
		String userName = sc.next();
		addUserName(userName, sc);
		System.out.print("Enter Your Password: ");
		String password = sc.next();
		System.out.print("Enter Initial Amount: ");
		String amount = sc.next();
		int checkedAmount = checkNumber(amount, sc);

		int  n = rand.nextInt(10000) + 1;
		String aNumber = "J" + n;
		System.out.println("");
		System.out.println("Account Opened: ");
		System.out.println("Thank you for creating an account with JLukim Federal Credit Union!");
		System.out.println("Your Account number is: " + aNumber);
		customer = new Customer(firstName, lastName, userName, password, aNumber, checkedAmount);
		String file = "src/main/java/project1/Data/Customers"+customer.getUserName()+ ".ser";
		DS.serialize(customer);
		c.add(customer);
		for (int i = 0; i < 10; ++i) System.out.println();
		Intro();
	}
	
	public void addUserName(String userName, Scanner sc) {
		if(userNames.contains(userName)) {
			System.out.println("\"" + userName + "\"" + " already exists in the database please use a different user name");
			System.out.println("Enter Your User Name: ");
			String name = sc.next();
			addUserName(name, sc);
		}else
			userNames.add(userName);
	}
	
	public int checkNumber(String amount, Scanner sc){
		int num = 0;
		try{
			num = Integer.parseInt(amount);
		}catch(NumberFormatException e){
			System.out.println("\"" + amount + "\"" + " was not a valid input for an Amount!");
			System.out.print("Enter Initial Amount: ");
			String x = sc.next();
			checkNumber(x, sc);
		}
		return num;
	}
	
	public void customerSignIn(String userName, String password, Scanner sc){
		Customer user = checkUserName(userName, password);
		if(user != null) {	
			System.out.println("");
			System.out.println("Welcome Back " + userName + ": ");
			System.out.println("Enter 1: To withdraw from your account");
			System.out.println("      2: To deposit into your account");
			System.out.println("      3: To transfer funds into a different count");
			System.out.println("      4: To check account balance");
			System.out.print("      5: To Logout: ");
			String choice = sc.next();
			customerChoice(userName, password, choice, sc, user);
		}else {
			System.out.println("");
			System.out.println("Your User Name or Password is not found in our Database: ");
			Intro();
		}
	}
	
	public void customerChoice(String userName, String password, String choice, Scanner sc, Customer cus) {
		customerInterface CI = new customerInterface(cus);
		switch(choice){
		case "1": System.out.println("");
				  System.out.println("Withdrawal: ");
				  System.out.print("Enter the amount you wish to withdraw: ");
				  int amount = sc.nextInt();
				  int result = CI.withdraw(userName, amount);
				  if(amount < 0) {
					  System.out.println( amount + " is not a valid withdraw number");
				  	  customerSignIn(userName, password, sc);
				  }
				  
				  if(result < 0) {
					  System.out.println("Withdraw Error: not enough money in your account for this transaction");
					  customerSignIn(userName, password, sc);
				  }else {
					  System.out.println("Success! you have withdrawn $" + amount + " from your account");
					  System.out.println("Your account balance is $" + (cus.getAccountBalance()-amount));
					  Customer c = new Customer(cus.getFirstName(), cus.getLastName(), cus.getUserName(), cus.getPassword(), cus.getAccountNumber(), result);
					  DS.serialize(c);
					  customerSignIn(userName, password, sc);
				  }
		break;
		case "2": System.out.println("");
		  		  System.out.println("Deposit: ");
		  		  System.out.println("Enter the amount you wish to deposit: ");
		  		  int deposit = sc.nextInt();
		  		  if(deposit < 0) {
					  System.out.println( deposit + " is not a valid withdraw number. Do you want to withdraw instead");
				  	  customerSignIn(userName, password, sc);
				  }
		  		  
		  		  int balance = CI.deposit(userName, deposit);
		  		  System.out.println("Success! you have deposited $" + deposit + " to your account");
		  		  Customer customer = new Customer(cus.getFirstName(), cus.getLastName(), cus.getUserName(), cus.getPassword(), cus.getAccountNumber(), balance);
		  		  System.out.println("Your account balance is $" + customer.getAccountBalance());
		  		  //updateAccountBalance(cus.getFirstName(), cus.getLastName(), cus.getUserName(), cus.getPassword(), cus.getAccountNumber(), balance);
		  		  DS.serialize(customer);
		  		  customerSignIn(userName, password, sc);
		break;
		case "3": System.out.println("");
				  System.out.println("Tranfer Funds: ");
				  System.out.print("Enter the account username you wish to transfer funds to: ");
				  String username = sc.next();
				  Customer c2 = DS.deserialize(username);//checkUserName2(username);
				  if(c2 == null) {
					  System.out.println(username + " cannot be found in out database");
					  customerSignIn(userName, password, sc);
				  }
				  
				  System.out.print("Enter the amount you wish to transfer: ");
				  int transfer = sc.nextInt();
				  if(transfer < 0) {
					  System.out.println( transfer + " is not a valid withdraw number");
				  	  customerSignIn(userName, password, sc);
				  }
				  
				  int transferResult = CI.transfer(c2, transfer);
				  if((cus.getAccountBalance() - transfer) < 0) {
					  System.out.println("Transfer Error: not enough money in your account for this transaction");
				  	  customerSignIn(userName, password, sc);
				  }else {
					  Customer customer2 = new Customer(cus.getFirstName(), cus.getLastName(), cus.getUserName(), cus.getPassword(), cus.getAccountNumber(), cus.getAccountBalance()-transfer);
					  DS.serialize(customer2);
					  //updateAccountBalance(cus.getFirstName(), cus.getLastName(), cus.getUserName(), cus.getPassword(), cus.getAccountNumber(), cus.getAccountBalance()-transfer);
					  System.out.println("Success! you have deposited $" + transfer + " into " + c2.getUserName() +"'s account");
			  		  System.out.println("Your account balance is $" + customer2.getAccountBalance());
			  		  Customer customer3 = new Customer(c2.getFirstName(), c2.getLastName(), c2.getUserName(), c2.getPassword(), c2.getAccountNumber(), c2.getAccountBalance()+transfer);
			  		  DS.serialize(customer3);
			  		  customerSignIn(userName, password, sc);
			  		  //updateAccountBalance2(c2.getFirstName(), c2.getLastName(), c2.getUserName(), c2.getPassword(), c2.getAccountNumber(), c2.getAccountBalance() + transfer);
				  }
		break;
		case "4": Customer c7 = DS.deserialize(userName);
				  System.out.println("Your account balance is " + c7.getAccountBalance());
				  customerSignIn(userName, password, sc);
		break;
		case "5":System.out.println("");
				 System.out.println("Thank you for visiting JLukim Federal Credit Union"); 
				 //System.exit(0);
				 Intro();
		break;
		default: System.out.println("\"" +choice + "\"" + " is not an acceptable input!");
				 //System.exit(1);
				 customerSignIn(userName, password, sc);
		}
	}
	
	public static void employeeSignIn(Scanner sc){
		System.out.println("");
		System.out.println("Welcome Back Employee: ");
		System.out.println("Enter 1: To view employee information");
		System.out.println("      2: To edit employee information");
		String choice = sc.next();
	}
	
	public Customer checkUserName(String userName, String password){
		Customer cus = DS.deserialize(userName);
		if(userName.equals(cus.getUserName()) && password.equals(cus.getPassword())){
				return cus;
		}
		return null;
	}
	
	public Customer checkUserName2(String userName){
		Customer cus = null;
		for(Customer customer : c) {
			if(userName.equals(customer.getUserName())){
					cus = customer;
			}
		}
		if(cus == null) {
			return null;
		}else {
			Customer cus2 = new Customer(cus.getFirstName(), cus.getLastName(), cus.getUserName(), cus.getPassword(), cus.getAccountNumber(), cus.getAccountBalance());
			return cus2;
		}
	}
	
	public void updateAccountBalance(String firstName, String lastName, String userName, String password, String accountNumber, int amount){
		Customer c1 = new Customer(firstName, lastName, userName, password, accountNumber, amount);
		for(Customer cus : c){
			if(userName.equals(customer.getUserName())){
				c.remove(cus);
				c.add(c1);
			}
		}
	}
	
	public void updateAccountBalance2(String firstName, String lastName, String userName, String password, String accountNumber, int amount){
		Customer c1 = new Customer(firstName, lastName, userName, password, accountNumber, amount);
		Iterator<Customer> iter = c.iterator();
		while(iter.hasNext()){
		    Customer str = iter.next();
		    if( userName.equals(str.getUserName())){
		        iter.remove();
		        c.add(c1);
		    }
		}
	}
	
	public static void main(String[] args){
		createAccount bank = new createAccount();
		//ArrayList<Customer> cus = DS.deserialize("src/main/java/project1/filename.ser");
	} 
	
}
