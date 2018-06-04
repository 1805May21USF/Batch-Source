/**
 * This class is a representation of a banking application. 
 */
package com.revature.bankingapp2;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.bankingapp2.ConnFactory;

/**
 * @author Nicholas Smith
 *
 */
public class Bank
{

	//create an instance of ConnFactory 
	public static ConnFactory cf = ConnFactory.getInstance();
	public static void main(String[] args) throws SQLException
	{
		String username;
		String password;
		
		/*LOGIN METHOD*/
		
		//A registered user can login with their username and password  
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome Green Bank.");
		System.out.println("Please enter username:");
		
		//user input is stored into a variable named username
		username = input.next();
		
		System.out.println("Please enter password:");
		//user password is stored into a variable named password
		password = input.next();
		
		System.out.println("Username is: " + username);
		System.out.println("Password is: " + password);
		
		//username and password must both match from wherever they are stored.
		//NOTE: where should they be stored?
		
		//pull the information from my database
		CustomerTools ct = new CustomerTools();
		
		
		boolean exists = ct.checkCustomer("sdf");
		
		System.out.println("customer exists: " + exists);
		
		/*REGISTER METHOD*/
		
	}
}
