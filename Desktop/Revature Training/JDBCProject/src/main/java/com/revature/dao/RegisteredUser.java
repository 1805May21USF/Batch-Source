package com.revature.dao;

import java.sql.SQLException;

public interface RegisteredUser {
	
	public abstract void createRegisteredUser(String username) throws SQLException;

}
