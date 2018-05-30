package com.revature.Banking_App;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

//Reads in the ArrayList of Users from a file (users.ser) into memory
public class ReadUsersFromFile 
{
	@SuppressWarnings("unchecked")
	public static ArrayList<User> deserializeUsers()
	{
		ArrayList<User> accounts = new ArrayList<User>();
		
		FileInputStream fin = null;
		ObjectInputStream ois = null;
		
		try
		{
			fin = new FileInputStream("users.ser");
			ois = new ObjectInputStream(fin);
			accounts = (ArrayList<User>) ois.readObject();
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
