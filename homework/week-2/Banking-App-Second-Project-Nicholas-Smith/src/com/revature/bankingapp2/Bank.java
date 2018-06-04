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
		Terminal t1 = new Terminal();
		
		t1.welcome();
	}
}
