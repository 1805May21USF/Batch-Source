package com.revature.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.dao.AccountDAO;
import com.revature.util.Connect2DB;

public class AccountDAOImpl implements AccountDAO {

	public static Connect2DB cdb = Connect2DB.getInstance();

	public List<?> getUserAccount() throws SQLException {
		List<Account> userAccount = new ArrayList<Account>();
		Connection conn = cdb.getConnection();
		String sql = "SELECT * FROM BANK_ACCOUNTS ORDER BY ACCOUNT_ID";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		Account ac = null;
		
		while(rs.next()) {
			ac = new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4));
			userAccount.add(ac);
		}
		
		return userAccount;
	}

	public void createAccount(Account ac) throws SQLException {
		Connection conn = cdb.getConnection();
		String sql = "{call CREATE_ACCOUNT(?,?,?,?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, ac.getAccountID());
		call.setString(2, ac.getFirstName());
		call.setString(3, ac.getLastName());
		call.setFloat(4, ac.getBalance());
		call.execute();
	}

	public void deleteAccount(Account ac) throws SQLException {
		Connection conn = cdb.getConnection();
		String sql = "{call DELETE_ACCOUNT(?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, ac.getAccountID());
		call.execute();
	}

}
