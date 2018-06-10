package com.revature.banking_app;

import java.util.ArrayList;

//Class to create a bank account
public class BankAccount
{
	
	private int accountNumber;
	private Double balance;
	private ArrayList<String> ownersLoginName;
	private ArrayList<String> ownersFullName;
	
	public AccountType singleOrJoint;
	public AccountStatus status;
	public JointOwner pendingAcceptance;
	
	//enums for account states
	public static enum AccountType 
	{
		Single,
		Joint;
	}
	
	public static enum AccountStatus
	{
		Approved,
		Pending,
		Canceled;
	}
	
	public static enum JointOwner
	{
		None,
		Pending,
		Accepted;
	}
	
	public BankAccount(int accountNumber,Double balance, String ownerLoginName, String ownersFullName, AccountType singleOrJoint, AccountStatus status, JointOwner pendingAcceptance)
	{
		this.ownersLoginName = new ArrayList<String>();
		this.ownersFullName = new ArrayList<String>();
		this.accountNumber = accountNumber;
		this.ownersLoginName.add(ownerLoginName);
		this.ownersFullName.add(ownersFullName);
		this.singleOrJoint = singleOrJoint;
		this.status = status;
		this.pendingAcceptance = pendingAcceptance;
		this.balance = balance;
	}
	//adds another owner to the account
	public String getFirstOwnerLogin()
	{
		return this.ownersLoginName.get(0);
	}
	
	public String getSecondOwnersLogin()
	{
		if(this.ownersLoginName.size() == 2)
		{
			return this.ownersLoginName.get(1);
		}
		return "";
	}
	public String getFirstOwnersFullName()
	{
		return this.ownersFullName.get(0);
	}
	
	public String getSecondOwnersFullName()
	{
		if(this.ownersFullName.size() == 2)
		{
			return this.ownersFullName.get(1);
		}
		return "";
	}
	
	
	public void addJointOwner(String loginName, String fullName)
	{
		this.ownersLoginName.add(loginName);
		this.ownersFullName.add(fullName);
	}
	//adds amount to account
	public void deposit(Double amount)
	{
		this.balance = this.balance + amount;
	}
	//removes amount from account
	public void withdraw(Double amount)
	{
		this.balance = this.balance - amount;
	}
	
	//returns the account's number
	public int getAccountNumber() {
		return accountNumber;
	}
	//returns the current balance
	public double getBalance() {
		return balance;
	}
	//returns true if a person is a owner on the account
	public boolean isAnOwner(String loginName)
	{
		if(this.ownersLoginName.get(0).equals(loginName))
		{
			return true;
		}
		if(this.ownersLoginName.size() == 2 && this.ownersLoginName.get(1).equals(loginName))
		{
			return true;
		}
		return false;
	}
	//returns true if the person is the joint owner
	public boolean isAJointOwner(String loginName)
	{
		if(this.ownersLoginName.size() == 2 && this.ownersLoginName.get(1).equals(loginName))
		{
			return true;
		}
		return false;
	}
	//returns a concated string with the owner or owners loginNames
	public String getOwners() 
	{
		String output = "";
		for(String loginName: this.ownersLoginName)
		{
			output = output + loginName +"   ";
		}
		return output;
	}
	//returns a concated string with the owner or owners  fullNames
	public String getOwnersFullNames() {
		String output = "";
		for(String fullName: this.ownersFullName)
		{
			output = output + fullName +"   ";
		}
		return output;
	}
	//returns a concated string so show account status or account info if account is in approve state and not pending acceptance by proposed joint owner
	public String displayAccount()
	{
		String output = "ACCOUNT: "+ this.accountNumber+ " ";
		
		if(this.status == AccountStatus.Canceled)
		{
			output = output + "Account Canceled";
			return output;
		}
		
		if(this.status == AccountStatus.Pending)
		{
			output = output +"*Pending Approval* ";
			return output;
		}
		if(this.pendingAcceptance == JointOwner.Pending)
		{
			output = output + "*Pending Joint owner's acceptance*";
			return output;
		}
		
		output = output +"BALANCE: $"+ this.balance + " OWNERS: " + this.getOwners()+ " FULLNAMES: " + this.getOwnersFullNames();
		return output;
	}
}
