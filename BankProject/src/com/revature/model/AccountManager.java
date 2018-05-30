package com.revature.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;




//public class AccountManager implements Serializable {
	
//	Scanner sc = RunBank.getScanner();	
//	
//	
//	
//	private int accountCounter = 0;
//	Customer c;
//	
//	public AccountManager() {
//		super();
//		// TODO Auto-generated constructor stub
//		c = new Customer();
//	}
//	String userName;
//	String password;
//	int accountNumber;
//	
//	Customer c1 = new Customer (userName, password, accountNumber);{
	
//	try
//    {   File file = new File("Data/Customer/"+ c.getUserName() + ".text");
//        //Saving of object in a file
//        FileOutputStream file1 = new FileOutputStream(file);
//        ObjectOutputStream out = new ObjectOutputStream(file1);
         
        // Method for serialization of object
      //  out.writeObject(c);
         
        //out.close();
       // file1.close();
         
        //System.out.println("");

   // }
     
//    catch(IOException ex)
//    {
//        System.out.println("");
//    }
	
	/*public double createAccount(double openingBalance) {
		if (openingBalance >= 25) {
			
			if(accountCounter < accounts.length) {
				
				accounts[accountCounter]=new Customer();
				accounts[accountCounter].setBalance(openingBalance);
				
				accountCounter++;
				return accounts[accountCounter-1].getAccountNumber(); 
			}
		}
		
		return 0;
		
		
	}*/
	
//	public int deposit(long accountNumber, double amount) {
//		
//		int status = 0;
//		if(amount >0) {	
//		for(int i=0;i<accountCounter;i++) {
//				if(accountNumber == accounts[i].getAccountNumber()) {
//					accounts[i].setBalance(accounts[i].getBalance()+amount);
//					status =   1; // deposit successful 
//				}
//		else {
//		}
//					
//		}}	return status; // invalid account number 
//	}
//	public int withdraw(long accountNumber, double amount) {
//		int status = 0;
//		if(amount >0) {	
//		for(int i=0;i<accountCounter;i++) {
//		if(accountNumber == accounts[i].getAccountNumber()) {
//				if(accounts[i].getBalance()>=amount){
//			accounts[i].setBalance(accounts[i].getBalance()+amount);
//					status =   1;  
//				}	}		}
//		}
//		return status;
//		}
//	public double getBalance(long accountNumber) {
//		for (int i=0;i<accountCounter; i++) {
//			if(accountNumber == accounts[i].getAccountNumber()) {
//				return accounts[i].getBalance();
//			}
//		}
//			return -1;
//	}
//	public void transferMoney() {
//		 
//		
//	}
//}
