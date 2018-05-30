package com.revature.Banking_App;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

//Reads in the ArrayList of BankAccounts from a file (accounts.ser) into memory
public class ReadBankAccountsFromFile 
{
	@SuppressWarnings("unchecked")
	public static ArrayList<BankAccount> deserializeBankAccount()
	{
		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
		
		FileInputStream fin = null;
		ObjectInputStream ois = null;
		
		try
		{
			fin = new FileInputStream("accounts.ser");
			ois = new ObjectInputStream(fin);
			accounts = (ArrayList<BankAccount>) ois.readObject();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			if (fin != null) 
			{
				try 
				{
					fin.close();
				} catch (IOException e) 
				{
					e.printStackTrace();
				}
			}

			if (ois != null) 
			{
				try 
				{
					ois.close();
				} catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
		return accounts;
	}
}
