package com.revature.implementdao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Transaction;
import com.revature.dao.TransactionsDAO;
import com.revature.util.ConnFactory;

public class ImpTransactionsDAO implements TransactionsDAO{
	public static ConnFactory cf = ConnFactory.getInstance();
	
	/*
	 * Name: addTransaction()
	 * Input:String type, float amount, int userid,int accountid
	 * Output:None
	 * Description: Calls procedure to add a transaction
	 */
	@Override
	public void addTransaction(String type, float amount, int userid,int accountid) throws SQLException {
			Connection conn = cf.getConnection();		
			String sql = "{call ADDTRANSACTION(?,?,?,?)";
			
			CallableStatement call = conn.prepareCall(sql);
			call.setString(1, type);
			call.setFloat(2, amount);
			call.setInt(3, userid);
			call.setInt(4, accountid);
			call.execute();
			conn.close();
	}
	
	/*
	 * Name: getUserTransactions()
	 * Input:int userid
	 * Output:None
	 * Description: Calls prepared statement to get user transaction
	 */
	@Override
	public List<Transaction> getUserTransactions(int userid) throws SQLException {
		Connection conn = cf.getConnection();
		List<Transaction> transactionList = new ArrayList<Transaction>();
		String sql = "SELECT * FROM ACCOUNT_TRANSACTIONS WHERE USERID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, userid);
		ResultSet rs = ps.executeQuery();
		Transaction t = null;
		
		while(rs.next()) {
			t=new Transaction(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4), rs.getInt(5));
			transactionList.add(t);
		}
		conn.close();
		return transactionList;
	}
	
	/*
	 * Name: getAllTransactions()
	 * Input:None
	 * Output:None
	 * Description: Calls prepared statement to get all transactions
	 */
	@Override
	public List<Transaction> getAllTransactions() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		List<Transaction> transactionList = new ArrayList<Transaction>();
		String sql = "SELECT * FROM ACCOUNT_TRANSACTIONS";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		Transaction t = null;
		
		while(rs.next()) {
			t=new Transaction(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4), rs.getInt(5));
			transactionList.add(t);
		}
		conn.close();
		return transactionList;
	}
	
}
