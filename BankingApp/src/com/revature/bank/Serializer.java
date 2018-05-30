package com.revature.bank;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializer {

	public void serializing(Customer c)
	{
		try
		{  
			File file = new File("data/customers/" + c.getUsername() + ".text" );

			//Saving of object in a file
			FileOutputStream file1 = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(file1);

			// Method for serialization of object
			out.writeObject(c);

			out.close();
			file1.close();
			System.out.println("Object has been serialized");

		}

		catch(IOException ex)
		{
			System.out.println("IOException is caught");
		}
	}

}
