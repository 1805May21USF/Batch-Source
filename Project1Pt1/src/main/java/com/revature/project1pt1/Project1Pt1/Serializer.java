package com.revature.project1pt1.Project1Pt1;
import java.io.*;


public class Serializer {
	
	//Serializer for Customer
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
		        //System.out.println("Object has been serialized");

		    }
		     
		    catch(IOException ex)
		    {
		        System.out.println("IOException is caught");
		    }
	 }
	 
	 
	 //deserilalizer for Customer
	 public Customer deserializing(String username)
	 {
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
	          
	         //System.out.println("Object has been deserialized ");
	         return c;
	     }
	      
	     catch(IOException ex)
	     {
	         System.out.println("IOException is caught "+ex.getMessage());
	     }
	      
	     catch(ClassNotFoundException ex)
	     {
	         System.out.println("ClassNotFoundException is caught");
	     }

		 return null;
	 }
	 
	
 }
	 
