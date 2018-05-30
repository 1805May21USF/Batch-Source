package com.revature.bank;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserializer {
	
	public void deserialize(String username) {
		
		try
        {  
            File file = new File("data/customers/" + username + ".text" );
           
            // Reading the object from a file
            FileInputStream file1 = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(file1);
             
            // Method for deserialization of object
            Customer c = (Customer)in.readObject();
             
            in.close();
            file1.close();
             
            System.out.println("Object has been deserialized ");
            //return c;
        }
         
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
         
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
		
	}

}
