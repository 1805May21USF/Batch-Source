package com.revature.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import com.revature.banking_app.User;

public interface UsersDAO 
{
	public abstract void createUser(User user) throws SQLException;
	public abstract void updateUser(User user) throws SQLException;
	//public abstract void deleteUser(User user) throws SQLException;
	public abstract ArrayList<User> getUsers() throws SQLException;
}
