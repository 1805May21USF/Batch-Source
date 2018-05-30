package com.revature.Banking_App;

import java.util.ArrayList;

import com.revature.Banking_App.BankAccount.accountStatus;
import com.revature.Banking_App.BankAccount.accountType;
import com.revature.Banking_App.BankAccount.pendingJointOwnerAcceptance;
import com.revature.Banking_App.User.LevelOfAccess;

public class Reset 
{
	//Only needs to be called to reset the output Account and Users stored in files
	public void ResetBaseOutputFiles()
	{
		BankAccount myAccount = new BankAccount(1000,"DoeJ","John Doe",accountType.Single, accountStatus.Approved, pendingJointOwnerAcceptance.None);
    	ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
    	accounts.add(myAccount);
    	
    	
    	User admin = new User("admin", "pass", "admin", LevelOfAccess.Admin);
    	User employee = new User("employee", "pass", "employee", LevelOfAccess.Employee);
    	User customer = new User("DoeJ", "pass","John Doe", LevelOfAccess.Customer);
    	ArrayList<User> users = new ArrayList<User>();
    	users.add(admin);
    	users.add(employee);
    	users.add(customer);
    	
    	WriteUsersToFile.serializeUsers(users);
    	WriteBankAccountsToFile.serializeBankAccount(accounts);
	}
}
