package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.SuperUser;

public interface SuperUserDAO {
	public abstract void registerSuperUser(String username, String password) throws SQLException;
	public abstract void loginSuperUser(String username, String password) throws SQLException;
	public abstract List<SuperUser> getSuperUserList() throws SQLException;
}
