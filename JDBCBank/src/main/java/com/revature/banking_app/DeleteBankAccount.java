package com.revature.banking_app;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.DAOImp.BankAccountDAOImp;
import com.revature.banking_app.User.LevelOfAccess;

public class DeleteBankAccount 
{
	public static boolean deleteBankAccount(String[] command, ArrayList<BankAccount> mainBankAccounts, User currentUser)
	{
		BankAccountDAOImp bankAccountDAOImp = new BankAccountDAOImp();
		int accountNumber = Integer.parseInt(command[2]);
		for(BankAccount iter: mainBankAccounts)
		{
			if(iter.getAccountNumber() == accountNumber && iter.isAnOwner(currentUser.getLoginName()) && iter.getBalance() == 0 
					|| iter.getAccountNumber() == accountNumber && currentUser.permissions == LevelOfAccess.Admin && iter.getBalance() == 0)
			{
				try 
				{
					bankAccountDAOImp.deleteBankAccount(iter);
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				return true;
			}
		}
		System.out.println("Unable to Delete Account. Account either still has a balance or you do not have permissions");
		return false;
	}
}
