package com.revature.P0Banking;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class AppTest {

	@BeforeEach
	public void beforeEach(TestInfo info) {
		System.out.println("Initialize Test Data for "+info.getDisplayName());
	}
	
	
    @Test
    public void checkDatabase()
    {
    	//FileOutput write into database
    	File file = new File("Test.txt");
    	Customer guy = new Customer("Bob", 2, "toocool2", "cool");
    	try {
	    	FileOutputStream fileout = new FileOutputStream(file);
	    	ObjectOutputStream out = new ObjectOutputStream(fileout);
	    	out.writeObject(guy);
	    	out.close();
    	}catch(IOException e){
    	}
    	
    	//FileInput read from database and check if objects are the same
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
