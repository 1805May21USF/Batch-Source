package com.revature.project1pt1.Project1Pt1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class EmployeeSerializer {
	
	
	
	//serializer for employee
	 public void eSerializing(Employee e)
	 {
		 try
		    {   
		    	File file = new File("data/employees/" + e.getUsername() + ".text" );
		
		        //Saving of object in a file
		        FileOutputStream file1 = new FileOutputStream(file);
		        ObjectOutputStream out = new ObjectOutputStream(file1);
		         
		        // Method for serialization of object
		        out.writeObject(e);
		         
		        out.close();
		        file1.close();
		        //System.out.println("Object has been serialized");

		    }
		     
		    catch(IOException ex)
		    {
		        System.out.println("IOException is caught");
		    }
	 }
	 
	 //dserializer for Employee
	 public Employee eDeserializing(String username)
	 {
		 try
	     {   
			 File file = new File("data/employees/" + username + ".text" );
			 
	         // Reading the object from a file
	         FileInputStream file1 = new FileInputStream(file);
	         ObjectInputStream in = new ObjectInputStream(file1);
	          
	         // Method for deserialization of object
	         Employee e = (Employee)in.readObject();
	          
	         in.close();
	         file1.close();
	          
	         //System.out.println("Object has been deserialized ");
	         return e;
	     }
	      
	     catch(IOException ex)
	     {
	         System.out.println("IOException is caught" +ex.getMessage());
	     }
	      
	     catch(ClassNotFoundException ex)
	     {
	         System.out.println("ClassNotFoundException is caught");
	     }

		 return null;
	 }

}
