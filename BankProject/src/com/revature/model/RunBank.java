package com.revature.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class RunBank {

	private static Scanner sc = new Scanner(System.in);

public static void main(String[] args) throws IOException, ClassNotFoundException{
	//AccountManager bank = new AccountManager();
	Customer customer;// = new Customer();	
	Serialize s = new Serialize();
	
	System.out.println("               Edwin's Bank        ");
	System.out.println("");
	//while(true) {
		
		Scanner input2 = new Scanner(System.in);
		System.out.println(" Welcome ! ");
		System.out.println("");
		System.out.println("1. New Customer ");
		System.out.println("2. Login ");
		System.out.println("3.Employee");
		System.out.println("4. Admin");
		System.out.println("Enter Option : ");
		int option2 = input2.nextInt();
		
		switch(option2) {
		
		case 1: 
		System.out.println("");
		System.out.println("Enter a Username: ");
		String username = input2.next();
		//customer.setUserName(username);
		System.out.println("Enter a Password: ");
		String password = input2.next();
		//customer.setPassword(password);
		System.out.println("Enter amount to open the account :");
		int accountBalance = input2.nextInt();//bank.createAccount(input2.nextDouble());
		//if()//(accountNumber!=0)
		Random rand = new Random();
		int  n = rand.nextInt(50) + 1;
			System.out.println("Congrationlations, here is your account number : " + n);//+accountNumber);
			Customer c = new Customer(username, password, n, accountBalance);
			
		//else
			//System.out.println("Fails to create an account for you ");
		//customer.getAccountNumber();
		
		//Customer c = new Customer(username, password, (int)accountNumber);
		s.Serialization(c);
		//com.revature.model.Serialize.Serialization(c);
		
		
		break;
		case 2: 
			//Serialize s1 = new Serialize();
			System.out.println("");
			System.out.println("Enter your username?");
			String username1 = input2.next();
			Customer cus = s.Deserialization(username1);
			System.out.println("Enter Password ");
			String password1 = input2.next();
			System.out.println("");
			System.out.println(" Welcome ");
			break;
		case 3: break;
		case 4: break;
		
		
		}
	
	while(true) {
		System.out.println("1.  Open Account ");
		System.out.println("2.  Deposit ");
		System.out.println("3.  Withdraw ");
		System.out.println("4.  Check Balance ");
		System.out.println("5. Transfer Money ");
		System.out.println("6.  Exit");
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Option : ");
		int option = input.nextInt();
		
		double accountNumber = 0.0;
		switch(option){
		case 1:
			
			System.out.println("Enter amount to open the account :");
			 //accountNumber= bank.createAccount(input.nextDouble());
			if(accountNumber!=0)
				System.out.println("Congrationlations, here is your account number : "+accountNumber);
			else
				System.out.println("Fails to create an account for you ");
			break;
		case 2:
			
			System.out.println("Enter Amount");

			//int depositStatus = bank.deposit(input.nextLong(),input.nextDouble());
//			if(depositStatus!=0)
//				System.out.println("Deposited");
//			else
//				System.out.println("Fails to Deposit");
			
			break;
		case 3:
			
			//int withdrawStatus = bank.deposit(input.nextLong(),input.nextDouble());
//			if(withdrawStatus!=0)
//				System.out.println("Successful");
//			else
//				System.out.println("Fails to Withdraw");	
			
			break;
		case 4:System.out.println("Enter account number ");
//			double balance = bank.getBalance(input.nextLong());
//			if(balance ==-1)
//				System.out.println("Account not found");
//			else
//				System.out.println("Balance "+ balance);
			
			break;
		case 5: System.out.println("Transfer Money ");
		
		
		case 6: System.exit(0); break;
		
		}
	}
}
	//}
	
private static void Serialize(Customer c) {
	// TODO Auto-generated method stub
	
}

public static Scanner getScanner()
{
	return sc;
}
	
public static void addToText(Customer c)  {
	File outFile = new File("src/com/revature/model/Information.txt");
	try {
		FileWriter fWriter = new FileWriter (outFile, true);
		fWriter.write(c.getName());//set.UserName);
		fWriter.append(c.getLastName());
		fWriter.append(c.getAccountNumber() + "");
		
	} catch (IOException e) {
	
		e.printStackTrace();
	}
		
}
}



