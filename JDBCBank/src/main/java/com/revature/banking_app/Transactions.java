package com.revature.banking_app;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.DAOImp.BankAccountDAOImp;
import com.revature.banking_app.BankAccount.AccountStatus;
import com.revature.banking_app.BankAccount.JointOwner;
import com.revature.banking_app.User.LevelOfAccess;
import com.revature.usererrors.FailedDeposit;
import com.revature.usererrors.FailedTransfer;
import com.revature.usererrors.FailedWithdraw;

public class Transactions 
{
	public static Logger logger = LogManager.getLogger("TRANSACTIONS");
	
	
	//Method to perform a deposit of funds
	public static ArrayList<BankAccount> deposit(String[] command, ArrayList<BankAccount> mainBankAccounts, User currentUser)
	{
		Double amount = Double.parseDouble(command[1]);
		int account = Integer.parseInt(command[3]);
		BankAccountDAOImp bankAccountDAOImp = new BankAccountDAOImp();
		for(BankAccount iter: mainBankAccounts)
		{
			if(iter.getAccountNumber() == account && amount > 0 && iter.isAnOwner(currentUser.getLoginName()) && iter.status == AccountStatus.Approved && iter.pendingAcceptance != JointOwner.Pending
					||	iter.getAccountNumber() == account && currentUser.permissions == LevelOfAccess.Admin && amount > 0 && iter.status == AccountStatus.Approved && iter.pendingAcceptance != JointOwner.Pending)
			{
				iter.deposit(amount);
				logger.info(currentUser.getLoginName()+" Deposited $" + amount +" to account:" + account);
				try {
					bankAccountDAOImp.updateBalance(iter);
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				System.out.println("DEPOSIT SUCCESSFULL");
				return mainBankAccounts;
			}
		}
		//System.out.println("Unable to deposit funds. Possibilities are incorrect account number, account is in a pending state, or input amount is 0 or less.");
		throw new FailedDeposit("Unable to deposit funds. Possibilities are incorrect account number, account is in a pending state, or input amount is 0 or less.");
		//return mainBankAccounts;
	}
	
	
	//Method to perform a withdraw of funds
	public static ArrayList<BankAccount> withdraw(String command[], ArrayList<BankAccount> mainBankAccounts, User currentUser)
	{
		Double amount = Double.parseDouble(command[1]);
		int account = Integer.parseInt(command[3]);
		BankAccountDAOImp bankAccountDAOImp = new BankAccountDAOImp();
		for(BankAccount iter: mainBankAccounts)
		{
			if(iter.getAccountNumber() == account && iter.isAnOwner(currentUser.getLoginName()) && amount > 0 && amount <= iter.getBalance() 
					||	iter.getAccountNumber() == account && currentUser.permissions == LevelOfAccess.Admin && amount > 0 && amount <= iter.getBalance())
			{
				iter.withdraw(amount);
				logger.info(currentUser.getLoginName()+" Withdrew $" + amount +" from account:" + account);
				try {
					bankAccountDAOImp.updateBalance(iter);
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
				System.out.println("WITHDRAW SUCESSFULL");
				return mainBankAccounts;
			}
		}
		
		throw new FailedWithdraw("Unable to withdraw.Possibilities are insufficient funds, incorrect account number, or amount is 0 or less.");
		//System.out.println("Unable to withdraw.Possibilities are insufficient funds, incorrect account number, or amount is 0 or less.");
		//return mainBankAccounts;
	}
	
	
	//Method to handle transfers. Two For-each loops. Outer loop finds the destination account and the inner finds the originating account for funds transfer.
	public static ArrayList<BankAccount> transfer(String command[], ArrayList<BankAccount> mainBankAccounts, User currentUser)
	{
		boolean transferSuccessful = false;
		Double amount = Double.parseDouble(command[1]);
		int originAccount = Integer.parseInt(command[3]);
		int destinationAccount = Integer.parseInt(command[5]);
		BankAccountDAOImp bankAccountDAOImp = new BankAccountDAOImp();
		if(amount <= 0)
		{
			System.out.println("Transfer amount is 0 or negative");
			return mainBankAccounts;
		}
		for(BankAccount iter1 : mainBankAccounts)
		{
			if(iter1.getAccountNumber() == destinationAccount && iter1.isAnOwner(currentUser.getLoginName()) && iter1.status == AccountStatus.Approved && iter1.pendingAcceptance != JointOwner.Pending
					||	iter1.getAccountNumber() == destinationAccount && currentUser.permissions == LevelOfAccess.Admin && iter1.status == AccountStatus.Approved && iter1.pendingAcceptance != JointOwner.Pending)
			{
				for(BankAccount iter2: mainBankAccounts)
				{
					if(iter2.getAccountNumber() == originAccount && iter2.isAnOwner(currentUser.getLoginName()) && iter2.status == AccountStatus.Approved && iter2.getBalance() >= amount && iter2.pendingAcceptance != JointOwner.Pending
							||	iter2.getAccountNumber() == originAccount && currentUser.permissions == LevelOfAccess.Admin && iter2.status == AccountStatus.Approved && iter2.getBalance() >= amount && iter2.pendingAcceptance != JointOwner.Pending)
					{
						iter2.withdraw(amount);
						logger.info(currentUser.getLoginName()+" Transfered $"+amount +" From account:"+originAccount +" to account:"+destinationAccount);
						transferSuccessful = true;
						
						try {
							bankAccountDAOImp.updateBalance(iter2);
							
						} catch (SQLException e) {
							
							e.printStackTrace();
						}
						break;
					}					
				}
				if(transferSuccessful)
				{
					iter1.deposit(amount);
					try {
						bankAccountDAOImp.updateBalance(iter1);
						
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					
					System.out.println("TRANSFER SUCCESSFULL");
					return mainBankAccounts;
				}
			}
		}
		throw new FailedTransfer("Transfer failed. Possibilities are one or both account numbers are incorrect, insufficient funds in originating account, or the amount is 0 or less");
		//System.out.println("Transfer of funds failed");
		//return mainBankAccounts;
	}
}
