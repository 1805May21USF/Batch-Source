package com.revature.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Serialize {

	 public Serialize () {}
      public static void Serialization(Customer c) {
     // Serialization 
     try
     {   File file = new File("Data/Customer/"+ c.getUserName() + ".text");
         //Saving of object in a file
         FileOutputStream file1 = new FileOutputStream(file);
         ObjectOutputStream out = new ObjectOutputStream(file1);
          
         // Method for serialization of object
         out.writeObject(c);
          
         out.close();
         file1.close();
          
         System.out.println("");

     }
      
     catch(IOException ex)
     {
         System.out.println("");
     }
}
	 public Customer Deserialization(String userName) throws ClassNotFoundException {
		
	        try
	        {   
	            File file = new File("Data/Customer/" + userName +".text");
	            FileInputStream file1 = new FileInputStream(file);
	            ObjectInputStream in = new ObjectInputStream(file1);
	             
	            Customer c = (Customer)in.readObject();
	            
	            in.close();
	            file1.close();
	            System.out.println("It has been deserialized ");
	            return c;
	             
	           
	        }
	         
	        catch(IOException ex)
	        {
	            System.out.println("IOException is caught");
	        }
			return null;
	 
	    }
	 
	 
	 }
	



