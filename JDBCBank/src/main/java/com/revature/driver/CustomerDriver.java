package com.revature.driver;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.DaoImpl.AccountDaoImpl;
import com.revature.DaoImpl.CustomerDaoImpl;
import com.revature.beans.Account;
import com.revature.beans.Customer;

public class CustomerDriver {
	static AccountDaoImpl ADI; 
	static CustomerDaoImpl CDI; 
	List<Customer> customerList = new ArrayList<Customer>();
	List<Account> accountList = new ArrayList<Account>();
	Driver dr = null;
	
	public CustomerDriver(Customer customer, String Username, String password) {
		// TODO Auto-generated constructor stub
		dr = new Driver(Username);
		this.ADI = dr.ADI;
		this.CDI = dr.CDI;
		this.customerList = dr.customerList;
		this.accountList = dr.accountList;
		run(customer, Username, password);
	}
	
	public void run(Customer customer, String Username, String password) {
		Scanner sc = new Scanner(System.in);
		//CustomerDriver CD = new CustomerDriver();
		System.out.println("");
		System.out.println("Welcome Back " + Username + ": ");
		System.out.println("Enter 1: To withdraw from your account");
		System.out.println("      2: To deposit into your account");
		System.out.println("      3: To transfer funds into a different count");
		System.out.println("      4: To check account balance");
		System.out.print("      5: To Logout: ");
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
				  if(amount.equals("Q")){
					  customerChoice(userName, password, choice, sc, customer);
				  }
				  double result = checkNumber(amount, sc);
				  double newAmount = myAccount.getAccountbalance() - result * 1.0;
				  if(result < 0) {
					  System.out.println( amount + " is not a valid withdraw number");
				  	  dr.signIn(userName, password, sc);
				  }
				  
				  if(newAmount < 0) {
					  System.out.println("Withdraw Error: not enough money in your account for this transaction");
					  dr.signIn(userName, password, sc);
				  }else {
					  System.out.println("Success! you have withdrawn $" + result + " from your account");
					  System.out.println("Your account balance is $" + (newAmount));
					  try {
						ADI.updateAccount(userName, password, myAccount, newAmount);
					  } catch (SQLException e) {
						  // TODO Auto-generated catch block
						  e.printStackTrace();
					  }
					  dr.signIn(userName, password, sc);
				  }
		break;
		case "2": System.out.println("");
		  		  System.out.println("Deposit: ");
		  		  System.out.print("Enter the amount you wish to deposit: ");
		  		  String deposit = sc.next();
		  		  double res = checkNumber(deposit, sc);
				  double new_amount = myAccount.getAccountbalance() + res * 1.0;
		  		  if(new_amount < 0) {
					  System.out.println( deposit + " is not a valid withdraw number. Do you want to withdraw instead");
				  	  dr.signIn(userName, password, sc);
				  }
		  		  
		  		  //int balance = CI.deposit(userName, deposit);
		  		  System.out.println("Success! you have deposited $" + res + " into your account");
		  		  try {
		  			  ADI.updateAccount(userName, password, myAccount, new_amount);
		  		  } catch (SQLException e) {
		  			  // TODO Auto-generated catch block
		  			  e.printStackTrace();
		  		  }
		  		  System.out.println("Your account balance is $" + new_amount);
		  		  dr.signIn(userName, password, sc);
		break;
		case "3": 
				  System.out.println("");
				  System.out.println("Tranfer Funds: ");
//				  System.out.print("Enter the account username you wish to transfer funds to: ");
//				  String username = sc.next();
//				  //Customer c2 = DS.deserialize(username);
//				  if(c2 == null) {
//					  System.out.println(username + " cannot be found in out database");
//					  customerSignIn(userName, password, sc);
//				  }
//				  
//				  System.out.print("Enter the amount you wish to transfer: ");
//				  int transfer = sc.nextInt();
//				  if(transfer < 0) {
//					  System.out.println( transfer + " is not a valid withdraw number");
//				  	  customerSignIn(userName, password, sc);
//				  }
//				  
//				  int transferResult = CI.transfer(c2, transfer);
//				  if((cus.getAccountBalance() - transfer) < 0) {
//					  System.out.println("Transfer Error: not enough money in your account for this transaction");
//				  	  customerSignIn(userName, password, sc);
//				  }else {
//					  Customer customer2 = new Customer(cus.getFirstName(), cus.getLastName(), cus.getUserName(), cus.getPassword(), cus.getAccountNumber(), cus.getAccountBalance()-transfer);
//					  DS.serialize(customer2);
//					  //updateAccountBalance(cus.getFirstName(), cus.getLastName(), cus.getUserName(), cus.getPassword(), cus.getAccountNumber(), cus.getAccountBalance()-transfer);
//					  System.out.println("Success! you have deposited $" + transfer + " into " + c2.getUserName() +"'s account");
//			  		  System.out.println("Your account balance is $" + customer2.getAccountBalance());
//			  		  Customer customer3 = new Customer(c2.getFirstName(), c2.getLastName(), c2.getUserName(), c2.getPassword(), c2.getAccountnumber(), c2.getAccountBalance()+transfer);
//			  		  DS.serialize(customer3);
//			  		  customerSignIn(userName, password, sc);
//			  		  //updateAccountBalance2(c2.getFirstName(), c2.getLastName(), c2.getUserName(), c2.getPassword(), c2.getAccountNumber(), c2.getAccountBalance() + transfer);
//				  }
		break;
		case "4": System.out.println("Your account balance is " + myAccount.getAccountbalance());
				  dr.signIn(userName, password, sc);
		break;
		case "5":System.out.println("");
				 System.out.println("Thank you for visiting JLukim Federal Credit Union"); 
				 //System.exit(0);
				 dr.Intro();
		break;
		default: System.out.println("\"" +choice + "\"" + " is not an acceptable input!");
				 //System.exit(1);
				 dr.signIn(userName, password, sc);
		}
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
	
	public static void main(String[] args, Customer customer) {
		// TODO Auto-generated method stub
		
	}
}
