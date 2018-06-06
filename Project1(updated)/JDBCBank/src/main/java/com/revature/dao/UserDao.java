package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.User;
public interface UserDao {
	
	public abstract void createUser(String userName,String password) throws SQLException;
	public abstract List<User> getUserList() throws SQLException;

}
