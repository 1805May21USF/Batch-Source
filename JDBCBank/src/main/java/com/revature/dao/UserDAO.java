package com.revature.dao;

import java.sql.SQLException;

import com.revature.beans.User;

public interface UserDAO {
	
	public abstract void createUser(String userName, String firstName,
			String lastName, String password, int status) throws SQLException;
	
	public abstract User retrieveUser(String userName) throws SQLException;
	
	public abstract void updateUser(String userName, 
			String newPassword) throws SQLException;
	
	public abstract void deleteUser(String userName) throws SQLException;
	
}
