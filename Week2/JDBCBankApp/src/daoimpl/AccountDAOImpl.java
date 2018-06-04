package daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.ConnFactory;
import app.Account;
import dao.AccountDAO;

public class AccountDAOImpl implements AccountDAO {
	public static ConnFactory cf = ConnFactory.getInstance();

	public void createAccount(int accessLevel, String firstName, String lastName, String username, String password,
			double funds) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call CREATEACCOUNT(?,?,?,?,?,?)";

		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, accessLevel);
		call.setString(2, firstName);
		call.setString(3, lastName);
		call.setString(4, username);
		call.setString(5, password);
		call.setDouble(6, funds);
		call.execute();
	}

	public void createAccount(Account account) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call CREATEACCOUNT(?,?,?,?,?,?)";

		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, account.getAccessLevel().ordinal());
		call.setString(2, account.getFirstName());
		call.setString(3, account.getLastName());
		call.setString(4, account.getUsername());
		call.setString(5, account.getPassword());
		call.setDouble(6, account.getFunds());
		call.execute();
	}

	public List<Account> getAccountList() throws SQLException {
		List<Account> accountList = new ArrayList<Account>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNT");
		Account a = null;

		while (rs.next()) {
			a = new Account(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getDouble(7));
			accountList.add(a);
		}
		return accountList;
	}

	public Account getAccount(int accountNum) throws SQLException {
		Account account = null;
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNT WHERE ACCOUNTID=" + accountNum);

		while (rs.next()) {
			account = new Account(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getDouble(7));
		}
		return account;
	}

	public Account getAccount(String lastName, String firstName) throws SQLException {
		Account account = null;
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt
				.executeQuery("SELECT * FROM ACCOUNT WHERE LASTNAME=" + lastName + " AND FIRSTNAME=" + firstName);

		while (rs.next()) {
			account = new Account(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getDouble(7));
		}
		return account;
	}

	public Account getAccount(String username) throws SQLException {
		Account account = null;
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNT WHERE USERNAME='" + username + "'");

		while (rs.next()) {
			account = new Account(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getDouble(7));
		}
		return account;
	}

	public Account login(String username, String password) {
		try {
			Account loginAccount = getAccount(username);
			if (loginAccount.getPassword().equals(password)) {
				return loginAccount;
			} else {
				System.out.println("Incorrect password. Please try again.");
			}
			return getAccount(3); // logged out account
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Account logout() {
		return login("loggedout", "password");
	}

	// returns true if registration is successful, false if name is taken
	public boolean register(Account account) {
		try {
			// checks against existing database for username
			if (getAccount(account.getUsername()) == null) {
				createAccount(account);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void viewBalance(Account account) {
		System.out.println("Current account balance: " + account.getFunds() + '\n');
	}

	public void withdraw(Account account, double amount) {
		if (amount < account.getFunds()) {
			account.setFunds(account.getFunds() - amount);
			Connection conn = cf.getConnection();
			String sql = "{call UPDATEACCOUNTFUNDS(?,?)";

			CallableStatement call;
			try {
				call = conn.prepareCall(sql);
				call.setInt(1, account.getAccountNum());
				call.setDouble(2, account.getFunds());
				call.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Overdraw: not enough funds in account");
		}
		viewBalance(account);
	}

	public void deposit(Account account, double amount) {
		account.setFunds(account.getFunds() + amount);
		Connection conn = cf.getConnection();
		String sql = "{call UPDATEACCOUNTFUNDS(?,?)";
		try {
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1, account.getAccountNum());
			call.setDouble(2, account.getFunds());
			call.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		viewBalance(account);
	}

	public void transfer(Account account, int accountID, double transferAmount) {
		try {
			if (getAccount(accountID) != null) {
				withdraw(account, transferAmount);
				deposit(getAccount(accountID), transferAmount);
				System.out.println("Funds transferred successfully.");
			} else {
				System.out.println("Invalid destination accountID.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		viewBalance(account);
	}

	public void delete(Account account) {
		Connection conn = cf.getConnection();
		String sql = "{call DELETEACCOUNT(?)";

		CallableStatement call;
		try {
			call = conn.prepareCall(sql);
			call.setInt(1, account.getAccountNum());
			call.execute();
			System.out.println("Account deleted successfully. Returning to main menu.\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
