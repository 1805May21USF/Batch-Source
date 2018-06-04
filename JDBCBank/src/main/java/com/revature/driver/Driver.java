package com.revature.driver;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import com.revature.DaoImpl.AccountDaoImpl;
import com.revature.DaoImpl.CustomerDaoImpl;
import com.revature.beans.Account;
import com.revature.beans.Customer;

/**  
 * Main Driver class that implements the user interface
 * @param none
 * @return none
 */
public class Driver {
	static AccountDaoImpl ADI; 
	static CustomerDaoImpl CDI; 
	static org.apache.log4j.Logger logger =LogManager.getLogger(Driver.class);
	List<Customer> customerList = new ArrayList<Customer>();
	List<Account> accountList = new ArrayList<Account>();
	
	/**  
	 * Constructor for the Driver class, Initializes the CustomerDaoImpl and AccountDaoImpl and
	 * calls the Intro() method
	 * @param none
	 * @return none
	 */
	public Driver() {
		//Initializes AccountDaoImpl and CustomerDaoImpl
		this.ADI = new AccountDaoImpl();
		this.CDI = new CustomerDaoImpl();
		
		//get all the user and their accounts and stores then in an ArrayList
		try {
			this.customerList = CDI.getCustomer();
			this.accountList = ADI.getAccount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//calling the Introduction method
		Intro();
	}
	public Driver(String username) {
		
	}
	
	/**  
	 * Prints the greeting message to the screen and prompts the user for input that
	 * correlates with the given options
	 * @param none
	 * @return none
	 */
	public void Intro() {
		//Initializing scanner and random
		Scanner sc = new Scanner(System.in); 
		Random rand = new Random();
		
		//Prompts the user and asks for a response
		System.out.println("");
		System.out.println("Hi Welcome to JLukim Federal Credit Union (JFCU)");
		//logger.info("Hi Welcome to JLukim Federal Credit Union (JFCU)");
		System.out.println("Enter 1: To open an account");
		System.out.println("      2: To sign in");
		System.out.print("      3: To exit: ");
		String choice = sc.next();
		
		//Handling user response using a switch case`
		switch(choice){
		case "1": System.out.println("");
				  //Calling the open account method that creates an account for a user
				  openAccount(sc, rand);
		break;
		case "2": System.out.println("");
				  System.out.print("Please Enter Your User Name: ");
				  String user = sc.next();
				  System.out.print("Please Enter Your Password: ");
				  String password = sc.next();
				  //Calling the sign in method that check "sign in" info and displays user interface
				  signIn(user, password, sc);
		break;
		//to exit the application
		case "3":System.out.println("");
				 System.out.println("Thank you for visiting JLukim Federal Credit Union");
				 System.exit(0);
		break;
		//to handle responses that are no acceptable
		default: System.out.println("");
				 System.out.println("\"" +choice + "\"" + " is not an acceptable input!");
				 Intro();
				 System.exit(1);
		}
	}
	
	/**  
	 * Prompts the user for information and creates an account using the responses
	 * correlates with the given options
	 * @param sc: Scanner for getting user response
	 * @param rand: to generate a random number for account number
	 * @return none
	 */ 
	public void openAccount(Scanner sc, Random rand){
		System.out.println("");
		System.out.println("Opening an Account: ");
		System.out.print("Enter Your First Name: ");
		String firstName = sc.next();
		System.out.print("Enter Your Last Name: ");
		String lastName = sc.next();
		System.out.print("Enter Your User Name: ");
		String userName = sc.next();
		
		//boolean checker to check if the user already has an account
		boolean inDatabase  = checkUserName(userName, sc);
		getUserName(inDatabase, userName, sc);
		
		System.out.print("Enter Your Password: ");
		String password = sc.next();
		System.out.print("Enter Initial Amount: ");
		String amount = sc.next();
		//checks if the response is a number
		double checkedAmount = checkNumber(amount, sc);

		Customer customer = null;
		//Generates a random number 
		int  accountNumber = rand.nextInt(10000) + 1;
		try {
			System.out.println("Creating...");
			//Add account info to the accounts table
			ADI.createAccount(checkedAmount, accountNumber);
			Account myAccount = ADI.readAccount(userName, password, accountNumber);
			//add user info to the users table
			CDI.createCustomer(firstName, lastName, userName, password, 1, accountNumber, myAccount.getAccount_id());
			customer = CDI.readCustomer(userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("");
		System.out.println("Account Opened: ");
		System.out.println("Thank you for creating an account with JLukim Federal Credit Union!");
		System.out.println("Your Account number is: " + accountNumber);
		for (int i = 0; i < 10; ++i) System.out.println();
		Driver dr = new Driver();
	}
	
	/**  
	 * Confirms user input and direct user to a "userInterface" or "superUserInterface" 
	 * depending on their status.
	 * @param Username: the unique user name of the user
	 * @param password: the user password
	 * @param sc: scanner class for user input
	 * @return none
	 */
	public void signIn(String Username, String Password, Scanner sc) {
		Customer customer = checkUserName(Username, Password);
		if(customer != null) {	
			String[] args = {Username, Password};
			//check user status and directs to respective interface: 
			//A status of 3 is for the super user and 1 for an ordinary user
			if(customer.getStatus() == 3) {			
				superUserInterface(customer, Username, Password);
			}else {
				userInterface(customer, Username, Password);
			}
		}else {
			System.out.println("");
			System.out.println("Your User Name or Password is not found in our Database: ");
			Intro();
		}
	}
	
	/**  
	 * Checks for the user name in the customer list 
	 * @param username: the unique user name of the user
	 * @param sc: scanner class for user input
	 * @return true if the user exists in the list or false otherwise
	 */
	public boolean checkUserName(String username, Scanner sc) {
		for(Customer customer : customerList) {
			if(customer.getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}
	
	/**  
	 * Checks for the user name in the customer list 
	 * @param username: the unique user name of the user
	 * @param sc: scanner class for user input
	 * @return true if the user exists in the list or false otherwise
	 */
	public String getUserName(boolean inDatabase, String Username, Scanner sc) {
		String name = "";
		if(inDatabase) {
			System.out.println("\"" + Username + "\"" + " already exists in the database please use a different user name");
			System.out.println("Enter a new User Name: ");
			name = sc.next();
			getUserName(checkUserName(name, sc), name, sc);
		}
		return name;
	}
	
	public double checkNumber(String amount, Scanner sc){
		double num = 0.0;
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
	
	public Customer checkUserName(String userName, String password){
		for(Customer customer : customerList) {
			if(customer.getUsername().equals(userName) && customer.getPassword().equals(password)) {
				return customer;
			}
		}
		return null;
	}
	
	public void userInterface(Customer customer, String Username, String password) {
		Scanner sc = new Scanner(System.in);
		System.out.println("");
		System.out.println("Welcome Back " + Username + ": ");
		System.out.println("Enter 1: To withdraw from your account");
		System.out.println("      2: To deposit into your account");
		System.out.println("      3: To check account balance");
		System.out.print("      4: To Logout: ");
		String choice = sc.next();
		customerChoice(Username, password, choice, sc, customer);
	}
	
	public void customerChoice(String userName, String password, String choice, Scanner sc, Customer customer) {
		Account myAccount = null;
		try {
			myAccount = ADI.readAccount(userName, password, customer.getAccountnumber());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		switch(choice){
		case "1": System.out.println("");
				  System.out.println("Withdrawal: ");
				  System.out.print("Enter the amount you wish to withdraw: or Q to exit: ");
				  String amount = sc.next();
				  if(amount.equalsIgnoreCase("Q")){
					  userInterface(customer, userName, password);
				  }
				  double result = checkNumber(amount, sc);
				  double newAmount = myAccount.getAccountbalance() - result * 1.0;
				  if(result < 0) {
					  System.out.println( amount + " is not a valid withdraw number");
				  	  signIn(userName, password, sc);
				  }
				  
				  if(newAmount < 0) {
					  System.out.println("Withdraw Error: not enough money in your account for this transaction");
					  signIn(userName, password, sc);
				  }else {
					  try {
						  System.out.println("Withdrawing Amount...");
						  ADI.updateAccount(userName, password, myAccount, newAmount);
						  System.out.println("Success! you have withdrawn $" + result + " from your account");
						  System.out.println("Your account balance is $" + (newAmount));
					  } catch (SQLException e) {
						  // TODO Auto-generated catch block
						  e.printStackTrace();
					  }
					  
					  if(newAmount == 0){
						  System.out.println("");
						  System.out.println("Would you like to close your account? Y/N ");
						  String response = sc.next();
						  if(response.equalsIgnoreCase("y")){
				  			  try {
				  				System.out.println("Deleting...");
								CDI.deleteCustomer(userName);
								ADI.deleteCustomer(customer.getAccountnumber());
						  		System.out.println("Your account have been deleted. Goodbye!");
						  		Intro();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				  		  }
					  }
					  signIn(userName, password, sc);
				  }
		break;
		case "2": System.out.println("");
		  		  System.out.println("Deposit: ");
		  		  System.out.print("Enter the amount you wish to deposit: Or Q to exit:");
		  		  String deposit = sc.next();
		  		  if(deposit.equalsIgnoreCase("Q")){
					  userInterface(customer, userName, password);
				  }
		  		  double res = checkNumber(deposit, sc);
				  double new_amount = myAccount.getAccountbalance() + res * 1.0;
		  		  if(new_amount < 0) {
					  System.out.println( deposit + " is not a valid withdraw number. Do you want to withdraw instead");
				  	  signIn(userName, password, sc);
				  }
		  		  System.out.println("Depositing...");
		  		  try {
		  			  ADI.updateAccount(userName, password, myAccount, new_amount);
			  		  System.out.println("Success! you have deposited $" + res + " into your account");
		  		  } catch (SQLException e) {
		  			  // TODO Auto-generated catch block
		  			  e.printStackTrace();
		  		  }
		  		  System.out.println("Your account balance is $" + new_amount);
		  		  signIn(userName, password, sc);
		break;
		case "3": System.out.println("Your account balance is $" + myAccount.getAccountbalance());
				  signIn(userName, password, sc);
		break;
		case "4":System.out.println("");
				 System.out.println("Thank you for visiting JLukim Federal Credit Union"); 
				 Intro();
		break;
		default: System.out.println("\"" +choice + "\"" + " is not an acceptable input!");
				 signIn(userName, password, sc);
		}
	}
	
	public void superUserInterface(Customer customer, String Username, String password) {
		Scanner sc = new Scanner(System.in);
		System.out.println("");
		System.out.println("Welcome Back Chief " + Username + ": ");
		System.out.println("Enter 1: To create a user account");
		System.out.println("      2: To view registered accounts");
		System.out.println("      3: To update an account balance");
		System.out.println("      4: To delete a user");
		System.out.println("      5: To delete all users");
		System.out.print("      6: To Logout: ");
		String choice = sc.next();
		chiefChoice(Username, password, choice, sc, customer);
	}
	
	public void chiefChoice(String userName, String password, String choice, Scanner sc, Customer customer) {
		Account myAccount = null;
		Random rand = new Random();
		try {
			myAccount = ADI.readAccount(userName, password, customer.getAccountnumber());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		switch(choice){
		case "1": System.out.println("");
				  openAccount(sc, rand);
				  break;
		case "2": printUserAccounts();
				  superUserInterface(customer, userName, password);
				  break;
		case "3": System.out.println("");
				  System.out.println("Enter the account number to update: ");
				  String accNumber = sc.next();
				  System.out.println("Enter the amount to update: ");
				  String amount = sc.next();
				  int num = (int)checkNumber(accNumber, sc);
				  double newAmount = checkNumber(amount, sc);
				  Account acc = checkAccountNumber(num);
				  try {
					  System.out.println("Updating Account...");
					  ADI.updateAccount(userName, password, acc, newAmount);
				  } catch (SQLException e) {
					  // TODO Auto-generated catch block
					  e.printStackTrace();
				  }
				  System.out.println("Account updated Chief!");
				  superUserInterface(customer, userName, password);
				  break;
		case "4": System.out.println("");
		  		  System.out.println("Enter the user name to delete: ");
		  		  String name = sc.next();
		  		  boolean isThere = checkUserName(name, sc);
		  		  System.out.println("Enter the account number to delete");
		  		  String answer = sc.next();
		  		  int number = (int)checkNumber(answer, sc);
		  		  if(isThere){
		  			  try {
		  				System.out.println("Deleting Account...");
						CDI.deleteCustomer(name);
						ADI.deleteCustomer(number);
				  		System.out.println("Account deleted Chief!");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		  		  }
				  superUserInterface(customer, userName, password);
				  break;
		case "5": System.out.println("");
		  		  System.out.println("Are you sure you want to delete all users Chief? Y/N ");
		  		  String response = sc.next();
		  		  if(response.equalsIgnoreCase("y")){
		  			  try {
		  				System.out.println("Deleting...");
						CDI.deleteAllUsers();
				  		System.out.println("All user accounts has been deleted chief!");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		  		  }
				  superUserInterface(customer, userName, password);
		  		  break;
		case "6": 
				  System.out.println("");
				  System.out.println("Goodbye Chief"); 
				  Intro();
				  break;
		default: System.out.println("Sorry Chief" + "\"" +choice + "\"" + " is not an acceptable input!");
		 		 Intro();
		}
	}
	
	public Account checkAccountNumber(int accountNumber) {
		for(Account acc : accountList) {
			if(acc.getAccountnumber() == accountNumber) {
				return acc;
			}
		}
		return null;
	}
	
	public void printUserAccounts() {
		List<Account> newAList = null;
		List<Customer> newCList = null;
		try {
			newAList = ADI.getAccount();
			newCList = CDI.getCustomer();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Customer c: newCList) {
			if(c.getStatus() != 3) {
				for(Account account: newAList) {
					if(c.getAccountnumber() == account.getAccountnumber()) {
						System.out.println(c);
						System.out.println(account);
						System.out.println();
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		Driver driver = new Driver();
	}

}
