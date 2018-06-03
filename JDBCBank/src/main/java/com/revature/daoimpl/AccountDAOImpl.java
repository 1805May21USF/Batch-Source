package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.beans.Account;
import com.revature.dao.AccountDAO;
import com.revature.util.ConnFactory;

public class AccountDAOImpl implements AccountDAO {
	
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public void createAccount(int accountNumber, double amount,
			String accountStatus, int userId) throws SQLException {
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "ACCOUNT_NUMBER";
		String sql = "INSERT INTO BANK_ACCOUNT VALUES(ACCOUNTSEQ.NEXTVAL,?)"; //? is a placeholder

		try {
			PreparedStatement ps = conn.prepareStatement(sql, primaryKeys);
			ps.setInt(1, accountNumber);
			ps.setDouble(2, amount);
			ps.setString(3, accountStatus);
			ps.setInt(4, userId);
			ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Account retrieveAccount(int userId) throws SQLException{
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(
				"SELECT * FROM BANK_ACCOUNT WHERE USER_ID = " + userId);
		Account acct = null;
		
		boolean accountFound = false;
		
		while (rs.next()) {
			System.out.println("This user has an account");
			acct = new Account(rs.getInt(1), rs.getDouble(2),
					rs.getString(3), rs.getInt(4));
			return acct;
		} 
		
		if(!accountFound) {
			System.out.println("No accounts found");
		}
		return null;
	}

	@Override
	public void updateAccount() {
		// TODO Auto-generated method stub
		System.out.println("lol we stole ur muns");

	}

	@Override
	public void deleteAccount() {
		// TODO Auto-generated method stub

	}

}
