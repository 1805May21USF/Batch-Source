package com.revature.Banking_App;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

//Writes the ArrayList of Users to a file users.ser
public class WriteUsersToFile 
{
	public static void serializeUsers(ArrayList<User> users)
	{
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
				
		try
		{
			fout = new FileOutputStream("users.ser");
			oos = new ObjectOutputStream(fout);
			oos.writeObject(users);
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
