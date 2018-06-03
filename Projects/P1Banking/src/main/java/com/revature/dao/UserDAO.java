package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.User;

public interface UserDAO {
	/*******Abstract Methods********************/
	public abstract void insertUser(String firstname, String lastname, String username, String password) throws SQLException;
	public abstract void deleteUser(String username) throws SQLException;
	public abstract void updateUser(User u) throws SQLException;
	public abstract User getUserByCredentials(String username, String password) throws SQLException;
	public abstract List<User> getUserList() throws SQLException;
	public abstract User getUserByUsername(String username) throws SQLException;
}
