package com.revature.jdbc.test;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import com.revature.jdbcbankproj.Users;

public class JUnitUser {
	Users u = new Users();
	
	
	@Test
	public void testGetUserID() {
		
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
