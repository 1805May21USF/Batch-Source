package com.revature.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import com.revature.BankingProject.App;
import com.revature.BankingProject.CustomerAccount;
import com.revature.BankingProject.UserActions;

public class UtilityActions {
	private static Scanner sc = App.sc;
	
	//Clears all accounts of file, for testing purposes
	public static void clearAccounts(File filename) {
		RandomAccessFile file;
		try {
			file = new RandomAccessFile(filename, "rw");
			file.setLength(0);
			
			file.close();	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void write(ArrayList<?> accounts, File filename) {
	    // Serialization 
        try {   
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
             
            // Method for serialization of object 
            out.writeObject(accounts);
            
            out.close();
            file.close();
        } catch(IOException ex) {
            System.out.println("IOException is caught");
        }
	}
	
	public static ArrayList<?> read(File filename) {
		ArrayList<?> list = null;
		ObjectInputStream in;
		
		// Deserialization
        try {   
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            if (file.available() > 0) {
            	in = new ObjectInputStream(file);
            	// Method for deserialization of object
            	list = (ArrayList<?>) in.readObject();
                
                in.close();
            }
            
            file.close();
        } catch(IOException ex) {
            System.out.println("IOException is caught in getAccounts");
        } catch(ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
        
        return list;
	}
	
	public static UUID getUUID(CustomerAccount customerAccount) {
		StringBuilder bd = new StringBuilder();

		//determine account number
		int size = customerAccount.getBankAccountIDs().size();
		for (int i = 0; i < size; i++) {
			bd.append(i + " ");
		}
		int accNum;
		while (true) {
			System.out.println("Select one of user's accounts or -1 to Exit: [ " + bd + "]");
			String accInput = sc.nextLine();
			if (accInput.equals("-1"))
				return null;
			try {
				accNum = Integer.parseInt(accInput);
				if (accNum < size && accNum >= 0)
					return customerAccount.getBankAccountIDs().get(accNum);
			} catch (NumberFormatException e) {
				
			}
			System.out.println("Invalid entry");
		}
	}
	
	public static double getValidAmount() {
		double depositAmt;
		String input;
		
		while (true) {
			System.out.println("Amount or -1 to Exit: ");
			input = sc.nextLine();
			
			try {			
				depositAmt = Double.parseDouble(input);
				if (input.equals("-1"))
					break;
				if (depositAmt > 0)
					break;
			} catch (NumberFormatException e) {
				
			} 
			System.out.println("Invalid entry, please enter a number.");	
		}
		return depositAmt;
	}
	
	public static double getValidWithDrawAmount(UUID bankAccountID) {
		double amt;
		
		while (true) {
			amt = getValidAmount();
			
			if (amt == -1)
				break;			
			if (UserActions.getBalance(bankAccountID) >= amt) {
				break;
			}
			System.out.println("Amount greater than balance, please enter a smaller amount.");
		}
		if (amt == -1)
			return -1;
		return amt;
	}
}
