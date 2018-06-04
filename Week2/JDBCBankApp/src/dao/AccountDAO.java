package dao;

import java.sql.SQLException;
import java.util.List;

import app.Account;

public interface AccountDAO {
	public abstract void createAccount(int accessLevel, String firstName, String lastName, String username, String password, double funds) throws SQLException; 
	public abstract List<Account> getAccountList() throws SQLException;
}
