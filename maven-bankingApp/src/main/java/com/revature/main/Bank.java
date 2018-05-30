package com.revature.main;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
public class Bank {
	
	
	final static Logger logger = Logger.getLogger(com.revature.main.Bank.class);
	private static final String name = "Bank";
	public static Scanner clientIn;
	public static Scanner input = new Scanner(System.in);
	public static Scanner accountsIn;
	private static ArrayList<Client> client = new ArrayList<Client>();
	private static BufferedWriter bw;
	private static int nextAvailableAccount = 4;
	
	
	
	
	//Default Constructor
	public Bank() {
	
	}

	//open the Client.txt file
	public boolean openFile() {
		boolean fileOpen = false;
		// TODO Auto-generated method stub
		try {
		 clientIn = new Scanner(new File("Clients.txt"));
		fileOpen = true;
		}
		catch(Exception e) {
			System.out.println("Something went wrong homie! Your Files Not there.");
		}
		return fileOpen;
	}
	
	
	//imports the clients from the Clients.txt
	public void importClients() {
		// TODO Auto-generated method stub
		try {
		while(clientIn.hasNext()) {
			//grab all of the clients from the client.txt
			client.add(new Client(clientIn.next(),clientIn.next(),clientIn.next()));
			
		}
		}catch(Exception e) {
			System.out.println("what?");
		}
	}
	
	private static void runMe(String parameter){
		
		if(logger.isDebugEnabled()){
			logger.debug("This is debug : " + parameter);
		}
		
		if(logger.isInfoEnabled()){
			logger.info("This is info : " + parameter);
		}
		
		logger.warn("This is warn : " + parameter);
		logger.error("This is error : " + parameter);
		logger.fatal("This is fatal : " + parameter);
		
	}
	
	
	//main menu
	void mainMenu() {
		System.out.println("<----------Hello User---------->");
		System.out.println("<----Select an Option Below!---->");
		System.out.println("(1)---Access Your Account!");
		System.out.println("(2)---Sign Up");
		System.out.println("(3)---Exit");
	}
	
	//login screen for existing users
	public void loginScreen() {
		
		System.out.println("<---------Select an Option below--------->");
		System.out.println("Enter your username");
		String username = input.next();
		System.out.println("Enter your password");
		String password = input.next();
		//get the username and password
		//pass them to the checkCredentioals method
		checkCredintials(username, password);
		//display accounts
		//select an account
	
	}
	//checks whether the users credentials ar valid
	private void checkCredintials(String username, String password) {
		String user = username;
		String pass = password;
		String tempUserName;
		String tempPassword;
		String tempName;
		int tempId;
		double tempBalance;
		//open the clients.txt
		try {
		clientIn = new Scanner(new File("Clients.txt"));
		}catch(Exception e) {
			System.out.println("File NOt Found");
		}
		//while there are clients left get the next client;
		while(clientIn.hasNext()) {
			tempUserName = clientIn.next();
			tempPassword = clientIn.next();
			tempName = clientIn.next();
			
			// if the username that was inputted is the same as the username from the file
			// and the password given is the same as the password on file
			//the create a temporary variable to store the clients info.
			if(username.equals(tempUserName) && password.equals(tempPassword)) {
				System.out.println("Welcome back: " + tempName);
				Client client = new Client(tempUserName,tempPassword,tempName);
				
				//retrieve accounts from the user
				retrieveAccounts(username, client);
				
			}
			
		}
	}
	//retrieve the available accounts from the user.
	private void retrieveAccounts(String username, Client client) {
		String tempUserName;
		int tempId;
		double tempBalance;
		//open the accounts.txt
		try{
			accountsIn = new Scanner(new File("Accounts.txt"));
		}catch(Exception FileNotFoundException){
			System.out.println("File not found");
		}
		//while the file is not at the end
		while(accountsIn.hasNext()) {
				tempUserName = accountsIn.next();
				tempId = accountsIn.nextInt();
				tempBalance = accountsIn.nextDouble();
			if(username.equals(tempUserName)) {
				//if the username on file is the same as the username passed in.
				//then add all of the accounts with the corresponding username.
				client.accounts.add(new Account(tempUserName,tempId,tempBalance));
			
			}
			
		}
		selectAccount(client,username);
		
	}
	
private void newClientSelectAccount(Client client, String username) {
	
		
		Account account = null;
		System.out.println("<---------Select an option--------->");
		System.out.println("(1)----Select an account");
		System.out.println("(2)----Create a new account");
		System.out.println("(3)----Exit");
		int option = input.nextInt();
		
		if(option == 1) {
		System.out.println(client.accounts.toString());
		int index = input.nextInt();
		for(Account item : client.accounts) {
			if(item.getAccountID() == index) {
				account = new Account(item.getUsername(),item.getAccountID(),item.getBalance());
				creditDebit(account,client);
				
				}
			
			}
		}
		else if(option == 2) {
			client.accounts.add(new Account(client.getUserName(),nextAvailableAccount,0.00D));
			System.out.println(client.accounts.toString());
			nextAvailableAccount++;
		}
	}

	private void selectAccount(Client client, String username) {
		
		Account account = null;
		System.out.println("<---------Select an option--------->");
		System.out.println("(1)----Select an account");
		System.out.println("(2)----Create a new account");
		System.out.println("(3)----Exit");
		
		int option = input.nextInt();
		if(option == 1) {
		System.out.println(client.accounts.toString());
		int index = input.nextInt();
		for(Account item : client.accounts) {
			if(item.getAccountID() == index) {
				account = new Account(item.getUsername(),item.getAccountID(),item.getBalance());
				creditDebit(account,client);
				
				}
			
			}
		}
		else if(option == 2) {
			System.out.println("here you ara");
			client.accounts.add(new Account(client.getUserName(),nextAvailableAccount,0.00D));
			System.out.println(client.accounts.toString());
			nextAvailableAccount++;
		}
		else if (option== 3) {
			mainMenu();
			menuSwitch();
		}
	}

	private void creditDebit(Account account, Client client) {
		boolean done = false;
		while(done != true) {
		System.out.println("<---------Select an option--------->");
		System.out.println("(1)----add money to your account");
		System.out.println("(2)----withdraw money from your account");
		System.out.println("(3)----Back to Accounts");
		
		int option = input.nextInt();
		if(option == 1) {
			System.out.println("How much would you like to add?");
			double amount = input.nextDouble();
			account.setBalance(amount += account.getBalance());
			logger.warn("New balance: " + account.getBalance());
			//write to file starting with all of the client
				 }
			
		else if (option == 2) {
			System.out.println("How much would you like to withdraw");
			double amount = input.nextDouble();
			account.setBalance(amount -= account.getBalance());
			logger.warn("New balance: " + account.getBalance());
			//write new balance
			}
		else if(option == 3){
			selectAccount(client,client.getUserName());
			}
		}
	}
	
	
	public void menuSwitch(){
		
		int x = 1;
		int option;
		
	
		option = input.nextInt();
		if(option == 1) {
			System.out.println("You've chosen to access your account!");
			
			
			loginScreen();
			//Login Screen
				
			
		}
		else if(option == 2){
			System.out.println("You've chosen to sign up");
			
			signUpScreen();
			
		
		}
		else if(option == 3){
			System.out.println("You've chosen to Exit");
		System.exit(0);	
		
		}
		else {
			System.out.println("Wrong");
		}
		
			
	}//end method
		


	
	private void signUpScreen() {
		System.out.println("<----------Sign UP Screen--------->");
		System.out.println("Enter your name");
		String name = input.next();
		System.out.println("Enter a UserName");
		String userName = input.next();
		System.out.println("Enter a password");
		String password = input.next();
		Double initialBalance = 0.00D;
		boolean alreadyUser = false;
		//check to see if the user exists
		for(Client Item : client) {
			if(Item.getUserName().equals(userName)) {
				alreadyUser = true;
				break;
			}
		}
		if(alreadyUser == false) {
			Client newClient = new Client(userName, password, name);
			client.add(newClient);
			newClient.accounts.add(new Account(userName, nextAvailableAccount, initialBalance));
			
			nextAvailableAccount++;
			writeToClient();
			//writeToAccounts();
			newClientSelectAccount(newClient, newClient.getUserName());
			//write all clients
			
		}
		else {
			System.out.println("That username is taken.");
		}
		
	}
	public static void writeToAccounts() {
		String content;
		try {
		PrintWriter writer = new PrintWriter("Accounts.txt");
		 for(Client item : client) {
			 for(Account thing :  item.accounts ) {
	
				content = item.getUserName() + " " + thing.getAccountID() + " " + thing.getBalance();
				writer.println(content);
			 }
			}
		 writer.close();
		}catch(Exception FileNotFound) {
			System.out.println("FileNotFound");
		}
		
	}
	
	public static void writeToClient() {
		
		String content;
		try {
		PrintWriter writer = new PrintWriter("Clients.txt");
		 for(Client item : client) {
				content = item.getUserName() + " " + item.getPassword() + " " + item.getName();
				writer.println(content);
			}
		 writer.close();
		}catch(Exception FileNotFound) {
			System.out.println("FileNotFound");
		}
		
		
	}


	public static void main(String [] args) {
		
			
			Bank bank = new Bank();
			//instantiate Bank
			bank.openFile();
			bank.importClients();
			bank.mainMenu();
			bank.menuSwitch();
			
			//open Account.
			//Access Account.
			//exit
			
		}//end main
	}
	
	

