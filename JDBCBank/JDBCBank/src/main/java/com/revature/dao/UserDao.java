package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.User;

public interface UserDao {
	
	public abstract void createUser(User user) throws SQLException;
	public abstract void deleteUser(int userID) throws SQLException;
	public abstract User getUserByID(int userID) throws SQLException;
	public abstract User getUserByName(String firstName, String lastName) throws SQLException;
	public abstract User getUserByEmail(String email) throws SQLException;
	public abstract User getUserByUsername(String username) throws SQLException;
	public abstract List<User> getAllUsers() throws SQLException;
	public abstract User checkLoginCredentials(String username, String password) throws SQLException;

}
