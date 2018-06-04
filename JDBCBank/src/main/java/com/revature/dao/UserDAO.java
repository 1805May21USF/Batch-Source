package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.User;

public interface UserDAO {

	public abstract void registerUser(String firstname, String lastname, String username, String password) throws SQLException;
	public abstract List<User> getUserList() throws SQLException;
	public abstract boolean validateLogin(String username, String password) throws SQLException;
	public abstract void deleteUsers(int userID) throws SQLException;
	public abstract void updateUserInfo(User user, String username, String password) throws SQLException;
}
