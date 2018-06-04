package com.revature.dao;

import java.util.ArrayList;

public interface GetUserInfoDAO {
	public abstract String getUserFirstName(String username);

	public abstract String getUserLastName(String username);

	public abstract ArrayList<String> getUserAccountNumbers(String username);

	public abstract ArrayList<String> getUserAccountAndBalanceNumbers(String username);

	public abstract String getUserStatus(String username);

	public abstract String getUserBalance(String accountNumber);
}
