package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.ConnFactory;
import com.revature.beans.Transaction;
import com.revature.dao.TransactionDAO;

public class TransactionDAOImpl implements TransactionDAO{
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public void addTransaction(Transaction t) throws SQLException {
		// Retrieves the connection and provides the sql code to be executed
		Connection conn = cf.getConnection();
		String sql = "{call INSERT_BANK_TRANSACTION(?, ?, ?, ?)";
				
		// Instantiates a CallableStatement to insert a new transaction
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, t.getCustomerId());
		call.setInt(2, t.getInitialAccount());
		call.setInt(3, t.getFinalAccount());
		call.setDouble(4, t.getAmount());
		call.setString(5, t.getType());
		call.execute();
				
				// Closes the database connection
				conn.close();
	}

	@Override
	public ArrayList<Transaction> listTransactions(String arg) throws SQLException {
		ArrayList<Transaction> transactions = new ArrayList<>();
		Connection conn = cf.getConnection();
		
		String sql = "SELECT * FROM TRANSACTION WHERE ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		if(!arg.equals("n"))
			stmt.setString(1, arg);
		else
			stmt.setString(1, "TRANSACTIONID > 0");
		
		ResultSet rs = stmt.executeQuery();
		
		// Puts the retrieved employees into the list
		while(rs.next()) {
			Transaction t = new Transaction(rs.getInt(0), rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getString(5));
			
			transactions.add(t);
		}
		
		// Closes the database connection
		conn.close();
		
		return transactions;
	}

}
