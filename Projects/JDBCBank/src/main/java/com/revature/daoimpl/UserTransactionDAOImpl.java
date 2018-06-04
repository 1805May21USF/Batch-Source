package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.CustomerAccount;
import com.revature.beans.UserTransaction;
import com.revature.dao.UserTransactionDAO;
import com.revature.util.ConnFactory;

public class UserTransactionDAOImpl implements UserTransactionDAO {
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public List<UserTransaction> getUserTransactions(UserTransaction ut) throws SQLException {
		List<UserTransaction> userTransactions = new ArrayList<UserTransaction>();
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM USER_TRANSACTION "
				+ "WHERE USER_ID = " + ut.getUserID() + " "
				+ "AND BANK_ACCOUNT_ID = " + ut.getBankAccountID() + " "
				+ "ORDER BY TRANSACTION_ID DESC FETCH FIRST 10 ROWS ONLY";	
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		UserTransaction a = null;
		
		while (rs.next()) {
			a = new UserTransaction(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
			userTransactions.add(a);
		}
		return userTransactions;
	}

	@Override
	public void createUserTransaction(UserTransaction ut) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call INSERTTRANSACTION(?,?,?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, ut.getUserID());
		call.setInt(2, ut.getBankAccountID());
		call.setString(3, ut.getMessage());
		call.execute();
	}
}
