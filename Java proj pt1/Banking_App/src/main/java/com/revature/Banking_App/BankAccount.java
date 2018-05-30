package com.revature.Banking_App;

import java.io.Serializable;
import java.util.ArrayList;

//Class to create a bank account
public class BankAccount implements Serializable
{
	private static final long serialVersionUID = -4688110899463342082L;
	private int accountNumber;
	private double balance;
	private ArrayList<String> ownersLoginName;
	private ArrayList<String> ownersFullName;
	
	public accountType singleOrJoint;
	public accountStatus status;
	public pendingJointOwnerAcceptance pendingAcceptance;
	
	//enums for account states
	public static enum accountType 
	{
		Single,
		Joint;
	}
	
	public static enum accountStatus
	{
		Approved,
		Pending,
		Canceled;
	}
	
	public static enum pendingJointOwnerAcceptance
	{
		None,
		Pending,
		Accepted;
	}
	
	public BankAccount(int accountNumber, String ownerLoginName, String ownersFullName, accountType singleOrJoint, accountStatus status, pendingJointOwnerAcceptance pendingAcceptance)
	{
		this.ownersLoginName = new ArrayList<String>();
		this.ownersFullName = new ArrayList<String>();
		this.accountNumber = accountNumber;
		this.ownersLoginName.add(ownerLoginName);
		this.ownersFullName.add(ownersFullName);
		this.singleOrJoint = singleOrJoint;
		this.status = status;
		this.pendingAcceptance = pendingAcceptance;
	}
	//adds another owner to the account
	public void addJointOwner(String loginName, String fullName)
	{
		this.ownersLoginName.add(loginName);
		this.ownersFullName.add(fullName);
	}
	//adds amount to account
	public void deposit(double amount)
	{
		this.balance = this.balance + amount;
	}
	//removes amount from account
	public void withdraw(double amount)
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
		
		if(this.status == accountStatus.Canceled)
		{
			output = output + "Account Canceled";
			return output;
		}
		
		if(this.status == accountStatus.Pending)
		{
			output = output +"*Pending Approval* ";
			return output;
		}
		if(this.pendingAcceptance == pendingJointOwnerAcceptance.Pending)
		{
			output = output + "*Pending Joint owner's acceptance*";
			return output;
		}
		
		output = output +"BALANCE: $"+ this.balance + " OWNERS: " + this.getOwners()+ " FULLNAMES: " + this.getOwnersFullNames();
		return output;
	}
}
