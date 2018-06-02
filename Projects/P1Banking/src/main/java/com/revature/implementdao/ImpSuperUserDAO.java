package com.revature.implementdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.revature.beans.SuperUser;
import com.revature.dao.SuperUserDAO;
import com.revature.util.ConnFactory;

public class ImpSuperUserDAO implements SuperUserDAO{
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public void registerSuperUser(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
	}

	@Override
	public void loginSuperUser(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SuperUser> getSuperUserList() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
