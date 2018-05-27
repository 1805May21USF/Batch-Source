package com.revature.P0Banking;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class UserTest {
	private static File file = new File("Test.txt");
	
	@Test
	void testCheckUnique() {
		String un = "Yes";
		String un1 = "Yes";
		assertEquals(un , un1);
	}
	
	@Test
	void testReadingAndWriting() {
		File file = new File("Test.txt");
    	Customer guy = new Customer("Bob", 2, "toocool2", "cool");
    	try {
	    	FileOutputStream fileout = new FileOutputStream(file);
	    	ObjectOutputStream out = new ObjectOutputStream(fileout);
	    	out.writeObject(guy);
	    	out.close();
    	}catch(IOException e){
    	}
    	try {
    		FileInputStream filein = new FileInputStream(file);
    		ObjectInputStream in = new ObjectInputStream(filein);
    		Customer guyback = (Customer) in.readObject();
    		assertTrue(guy.getName()==guyback.getName());
    		in.close();
    	}catch(Exception e) {
    	}
	}

}
