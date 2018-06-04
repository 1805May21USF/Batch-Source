package com.revature.dao;

public interface CheckUserDAO {
	public abstract boolean checkUser(String username);

	public abstract boolean checkUserAndPassword(String username, String password);
}
