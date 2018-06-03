package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Account;

public interface AccountDAO {

	public abstract List<?> getUserAccount() throws SQLException;
	public abstract void createAccount(Account ac) throws SQLException;
	public abstract void deleteAccount(Account ac) throws SQLException;
}
