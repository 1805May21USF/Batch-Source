package com.revature.dao;

public interface RegistrationDAO {
	public abstract void RegisterNewAccount(String firstName, String lastName, String username, String password,
			String tempAccountNumber);

	public abstract void RegisterNewAccount(String firstName1, String lastName1, String username1, String password1,
			String firstName2, String lastName2, String username2, String password2, String tempAccountNumber);

}
