package com.revature.bankAppApt1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class SignUp extends Customer{

	
	public void createSignUp(String serFile, String first, String last, String userName, String password) 
	{
		Customer xm = new Customer();
		xm.setFName(first);
		xm.setLName(last);
		xm.setUserName(userName);
		xm.setPassword(password);
		
		try 
		{
			FileOutputStream fileOut = new FileOutputStream(serFile+".ser"); //this will create a Customer.ser file
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(xm);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in "+ serFile+ ".ser");
		}
		catch(IOException ioe) 
		{
			ioe.printStackTrace();
		}
		
		
		
		// Deserializing an Object
		xm = null;
		try 
		{
			FileInputStream fileIn = new FileInputStream(serFile+".ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			xm = (Customer) in.readObject();
			in.close();
			fileIn.close();
		}
		catch(IOException ioe) 
		{
			ioe.printStackTrace();
		}
		catch(ClassNotFoundException cnf) 
		{
			System.out.println(serFile+" class not found");
			cnf.printStackTrace();
			return;
		}
		
	      System.out.println("\nDeserialized "+serFile+"...");
	      System.out.println("Name: " + xm.getFName()+" "+xm.getLName());
	      System.out.println("Username: " + xm.getUserName());
	      System.out.println("Password: " + xm.getPassword());
	      System.out.println("Checkings: " + xm.getCheckings());
	      System.out.println("Savings: " + xm.getSavings());
		
	}

}
