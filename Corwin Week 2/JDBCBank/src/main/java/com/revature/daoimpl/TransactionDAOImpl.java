package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.DAO.TransactionDAO;
import com.revature.beans.Account;
import com.revature.beans.Transaction;
import com.revature.util.ConnFactory;

public class TransactionDAOImpl implements TransactionDAO{

	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public Transaction findTransaction(int ID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM JDBCBANK_Transaction WHERE TRANSACTION_ID = ? ";
		CallableStatement ps = conn.prepareCall(sql);
		ps.setInt(1, ID);
		ResultSet rs = ps.executeQuery();
		Transaction s = null;
		
		while(rs.next()) {
			s = new Transaction(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
					rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getDouble(8),rs.getDouble(9));
		}
		conn.close();
		return s;
	}

	@Override
	public ArrayList<Transaction> findAllTransactions() throws SQLException {
		ArrayList<Transaction> TransactionList = new ArrayList<Transaction>();
		Connection conn = cf.getConnection();
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM JDBCBANK_Transaction");
		Transaction s = null;
		
		while(rs.next()) {
			s = new Transaction(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
					rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getDouble(8),rs.getDouble(9));
			TransactionList.add(s);
		}
		conn.close();
		return TransactionList;
	}

	@Override
	public void createTransaction(Transaction Transaction) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		String sql = "{call add_transaction(?,?,?,?,?,?,?,?)";
		
		CallableStatement ps = conn.prepareCall(sql);
		ps.setDouble(1, Transaction.getBalance());
		ps.setString(1, Transaction.getStatus());
		ps.execute();
		conn.close();
	}

	@Override
	public void updateTransaction(Transaction Transaction) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call update_transaction(?,?,?,?,?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, Transaction.getID());
		call.setDouble(1, Transaction.getBalance());
		call.setString(1, Transaction.getStatus());
		call.execute();
		conn.close();
	}

	@Override
	public void deleteTransaction(Transaction Transaction) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call delete_transaction(?)";
		CallableStatement ps = conn.prepareCall(sql);
		ps.setInt(1, Transaction.getID());
		ps.execute();
		conn.close();	
	}
}
