package com.revature.dao;

import java.sql.SQLException;

import com.revature.beans.User;

/**
 * Data access object interface for user accounts.
 * @author Nathaniel Simpson
 *
 */
public interface UserDAO {
	
	/*
	 * Abstract method for creating a new user account.
	 */
	public abstract void createUser(String userName, String firstName,
			String lastName, String password, int status) throws SQLException;
	
	/*
	 * Abstract method for retrieving a particular user.
	 */
	public abstract User retrieveUser(String userName) throws SQLException;
	
	/*
	 * Abstract method for updating a particular user's information.
	 */
	public abstract void updateUser(String userName, 
			String newPassword) throws SQLException;
	
	/*
	 * Abstract method for deleting a particular user.
	 */
	public abstract void deleteUser(String userName) throws SQLException;
	
}
