package com.revature.project0;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.HashMap;

import org.junit.Before;

import org.junit.Test;

public class BankTest {
	Bank b;
	@Before
	public void setup() {
		b = new Bank();
		
		
	}
	
	@Test
	public void testAddUser() throws SQLException, NotPermittedException {
		HashMap<String,String> logins = new HashMap<>();
		logins.put("testUser"+Math.random() , "testUser"+Math.random() );
		User u = new User(false,logins, false, 0.0);
		//test simple entry
		assert (User.getUser((String) logins.keySet().toArray()[0])).equals(u);
	}

	@Test
	public void testTransfer() throws SQLException, NotPermittedException {
		
		HashMap<String,String> logins = new HashMap<>();
		logins.put("testUser"+Math.random() , "testUser"+Math.random() );
		User u = new User(false,logins, true, 100.0);

		HashMap<String,String> logins2 = new HashMap<>();
		logins.put("testUser"+Math.random() , "testUser"+Math.random() );
		User u2 = new User(false,logins2, true, 0.0);
		b.currentUser= u;
		assert(b.transfer(u, u2, 45));
		
		

	}

}
