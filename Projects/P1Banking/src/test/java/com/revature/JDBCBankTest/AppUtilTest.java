package com.revature.JDBCBankTest;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.revature.beans.User;
import com.revature.exceptions.BadInputException;
import com.revature.implementdao.ImpUserDAO;

class AppUtilTest {
	private static String firstname= "App";
	private static String lastname= "Util";
	private static String username= "AppUtil1";
	private static String password= "11";
	
	@Test
	void testCheckMatch() throws SQLException, BadInputException {
		ImpUserDAO iud = new ImpUserDAO();
		iud.insertUser(firstname, lastname, username, password);
		List<User> users = iud.getUserList();
		for(User u: users) {
			if(u.getUsername().equals(username)) {
				assertTrue(u.getUsername().equals(username));
			}
		}
		iud.deleteUser(username);
		
	}

}
