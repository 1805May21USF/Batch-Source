package com.revature.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class UtilityActions {
	//Clears all accounts of file, for testing purposes
	public static void clearAccounts(File filename) {
		RandomAccessFile file;
		try {
			file = new RandomAccessFile(filename, "rw");
			file.setLength(0);
			
			file.close();	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void write(ArrayList<?> accounts, File filename) {
	    // Serialization 
        try {   
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
             
            // Method for serialization of object 
            out.writeObject(accounts);
            
            out.close();
            file.close();
        } catch(IOException ex) {
            System.out.println("IOException is caught");
        }
	}
	
	public static ArrayList<?> read(File filename) {
		ArrayList<?> list = null;
		ObjectInputStream in;
		
		// Deserialization
        try {   
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            if (file.available() > 0) {
            	in = new ObjectInputStream(file);
            	// Method for deserialization of object
            	list = (ArrayList<?>) in.readObject();
                
                in.close();
            }
            
            file.close();
        } catch(IOException ex) {
            System.out.println("IOException is caught in getAccounts");
        } catch(ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
        
        return list;
	}
}
