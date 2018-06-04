package com.revature.bank;

import java.sql.ResultSet;
import java.sql.SQLException;

public class View {
	
	public static void display(ResultSet myRs) throws SQLException 
	{
		while (myRs.next()) 
		{
			String lastName = myRs.getString("lastname");
			String firstName = myRs.getString("firstname");
			double checkings = myRs.getDouble("checkings");
			double savings = myRs.getDouble("savings");
			
			System.out.println("\nLast Name: "+lastName+"\n"+"First Name: "+firstName+"\n"+"Checkings: "+
					checkings+"\n"+"Savings: "+savings+"\n");
			
			//System.out.printf("\n%s, %s, %.2f, %s\n", lastName, firstName, checkings, savings);
		}
	}

}
