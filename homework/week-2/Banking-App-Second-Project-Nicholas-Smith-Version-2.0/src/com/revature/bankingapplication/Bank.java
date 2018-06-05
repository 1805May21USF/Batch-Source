/**
 * This class is a representation of a banking application. 
 */
package com.revature.bankingapplication;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.bankingapplication.ConnFactory;

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
		CustomerTools ct = new CustomerTools();
		
		ct.insertCustomer("Dale", "42");
	}
}
