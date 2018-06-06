package com.revature.jdbc.test;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import com.revature.jdbcbankproj.Users;

public class JUnitUser {
	Users u = new Users();
	
	@Test
	public void testCheckUserID() {
		// Check with existing id 1, superuser
		Assertions.assertEquals(1, u.CheckUserID(1));
		// Check that 0 returns when passing a non-existing value.
		Assertions.assertEquals(0, u.CheckUserID(1000));
	}
	
	@Test
	public void testGetUserID() {
		// Check that the correct user id is return using correct username and password.
		Assertions.assertEquals(2, u.GetUserID("BEAMIA", "BEAMIA123"));
	}
	
	@Test
	public void testCheckUsername() {
		
		// Check user exists.
		Assertions.assertEquals(true, u.CheckUsername("BEAMIA"));
		// Check user doesn't exist.
		Assertions.assertEquals(false, u.CheckUsername("BEAMIAAA"));
	}

	@Test
	public void testCheckUsernameAndPass() {
		// Check username and password is correct using correct login.
		Assertions.assertEquals(true, u.CheckUsernameAndPass("BEAMIA", "BEAMIA123"));
		// Check return false using incorrect password.
		Assertions.assertEquals(false, u.CheckUsernameAndPass("BEAMIA", "BEAMIA1234"));
	}
	
	


}
