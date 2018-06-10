package com.revature.banking_app;

import java.sql.SQLException;
import java.util.ArrayList;
import com.revature.DAOImp.BankAccountDAOImp;
import com.revature.DAOImp.UserDAOImp;
import com.revature.banking_app.BankAccount.AccountStatus;
import com.revature.banking_app.BankAccount.AccountType;
import com.revature.banking_app.BankAccount.JointOwner;
import com.revature.banking_app.User.LevelOfAccess;

public class Reset 
{
	//Only needs to be called to create the admin and employee records in database
	public static void setAdminEmployeeUserAccounts()
	{
    	User admin = new User("admin", "pass", "admin", LevelOfAccess.Admin);
    	User employee = new User("employee", "pass", "employee", LevelOfAccess.Employee);
    	ArrayList<User> users = new ArrayList<User>();
    	users.add(admin);
    	users.add(employee);
    	UserDAOImp userTemp = new UserDAOImp();
    	try 
    	{
	 		userTemp.createUser(admin);
    		userTemp.createUser(employee);   		
    		
		} catch (SQLException e) 
    	{
			e.printStackTrace();
		}
	}
}
