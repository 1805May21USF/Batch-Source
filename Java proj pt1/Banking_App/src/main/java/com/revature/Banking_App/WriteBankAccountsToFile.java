package com.revature.Banking_App;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

//Writes the ArrayList of BankAccounts to a file accounts.ser
public class WriteBankAccountsToFile 
{
	public static void serializeBankAccount(ArrayList<BankAccount> accounts)
	{
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
				
		try
		{
			fout = new FileOutputStream("accounts.ser");
			oos = new ObjectOutputStream(fout);
			oos.writeObject(accounts);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(fout != null)
			{
				try
				{
					fout.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
			if(oos != null)
			{
				try 
				{
					oos.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}