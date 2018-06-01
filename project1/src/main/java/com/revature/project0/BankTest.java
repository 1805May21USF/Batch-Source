package com.revature.project0;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;

import org.junit.Test;

public class BankTest {
	Bank b;
	@Before
	public void setup() {
		b = new Bank();
		User uWithManyNames = new User(false, "bob", "123", true, 35.0);
		uWithManyNames.loginInfo.put("bob2", "1234");
		b.users.put("bob",uWithManyNames);
		b.users.put("bob2",uWithManyNames);

		b.users.put("sam",new User(false, "sam", "123", true, 999.0));
		b.users.put("admin",new User(true, "admin", "123", true, 0.0));
		
	}
	
	@Test
	public void testAddUser() {
		User u = new User(false, "potato", "123", false, 0.0);
		b.addUser(u.loginInfo,u.admin);
		//test simple entry
		assert (b.users.get("potato").equals(u));
		//test repeat names
		User dupe=new User(false, "sam", "435", false, 0.0);
		b.addUser(dupe.loginInfo,dupe.admin);
		assert (!(b.users.get("sam").equals(dupe)));
		
	}

	@Test
	public void testDeleteUser() {
		//delete existing user and fail
		assert (b.users.containsKey("sam"));
		b.deleteUser("sam");
		assert (b.users.containsKey("sam"));
		//delete ourselves
		b.currentUser= b.users.get("sam");
		b.deleteUser("sam");
		assert (!b.users.containsKey("sam"));
	}

	@Test
	public void testTransfer() {
		//test umpermitted transfer
		b.transfer(b.users.get("bob2"), b.users.get("sam"), 20.0);
		assert (b.users.get("bob2").balance == 35.0);
		//test permitted transfer
		b.currentUser = b.users.get("bob2");
		b.transfer(b.users.get("bob2"), b.users.get("sam"), 20.0);
		assert (b.users.get("bob2").balance ==15.0);

	}

}
