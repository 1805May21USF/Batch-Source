package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.B_User;

public interface B_UserDAO {
//CRUD operations
	public abstract void createUser(String firstName, String lastName, String username, String password ) throws SQLException;
	public abstract List<B_User> getUserList() throws SQLException;
	public abstract List<B_User> getUnapprovedUserList() throws SQLException;
	
}
