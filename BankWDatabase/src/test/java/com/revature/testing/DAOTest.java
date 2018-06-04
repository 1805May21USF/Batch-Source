package com.revature.testing;

import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//import com.revature.beans.B_Account;
import com.revature.daoimpl.B_AccountDAOImpl;
import com.revature.daoimpl.B_UserDAOImpl;

public class DAOTest {
	@Test
	@DisplayName("DAOs")
    public void daoTest() {
		B_AccountDAOImpl b = new B_AccountDAOImpl();
    	try {
			assertNotNull(b.getMyAccountList(2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Test
	@DisplayName("DAO2")
    public void dao2Test() {
		B_UserDAOImpl b = new B_UserDAOImpl();
    	try {
			assertNotNull(b.getUnapprovedUserList());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
