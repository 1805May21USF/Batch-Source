package com.revature.daoimpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.log4j.Category;
import org.apache.log4j.PropertyConfigurator;

import com.revature.DAO.TransactionDAO;
import com.revature.beans.Account;
import com.revature.beans.Transaction;
import com.revature.util.ConnFactory;

public class TransactionDAOImpl implements TransactionDAO{

	public static ConnFactory cf = ConnFactory.getInstance();
	
	private String properties = "Log4j.properties";
	private Category log;
	
	public TransactionDAOImpl() {
		Properties logProperties = new Properties();
		log = Category.getInstance(this.getClass());
		
		 try
		    {
		      // load our log4j properties / configuration file
		      logProperties.load(new FileInputStream(properties));
		      PropertyConfigurator.configure(logProperties);
		      log.info("Logging initialized.");
		    }
		    catch(IOException e)
		    {
		      throw new RuntimeException("Unable to load logging property " + properties);
		    }
	}
	
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
					rs.getInt(5),rs.getInt(6),rs.getDouble(7),rs.getDouble(8));
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
					rs.getInt(5),rs.getInt(6),rs.getDouble(7),rs.getDouble(8));
			TransactionList.add(s);
		}
		conn.close();
		return TransactionList;
	}

	@Override
	public void createTransaction(Transaction transaction) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		String sql = "{call add_transaction(?,?,?,?,?,?,?)";
		
		CallableStatement ps = conn.prepareCall(sql);
		ps.setString(1, transaction.getDate());
		ps.setString(2, transaction.getStatus());
		ps.setString(3, transaction.getType());
		ps.setInt(4, transaction.getFrom_account_id());
		ps.setInt(5, transaction.getTo_account_id());
		ps.setDouble(6, transaction.getAmount());
		ps.setDouble(7, transaction.getBalance());
		ps.execute();
		conn.close();
		
		log.info("Transaction #"+transaction.getID() + ", From Account #"+transaction.getFrom_account_id()+", To Account #"+
		transaction.getTo_account_id()+", of Type: "+transaction.getType() +", Amount: " + transaction.getAmount() + ", Final Balance: "+transaction.getBalance());
	}

	@Override
	public void updateTransaction(Transaction transaction) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call update_transaction(?,?,?,?,?,?,?,?)";
		CallableStatement ps = conn.prepareCall(sql);
		ps.setInt(1,transaction.getID());
		ps.setString(2, transaction.getDate());
		ps.setString(3, transaction.getStatus());
		ps.setString(4, transaction.getType());
		ps.setInt(5, transaction.getFrom_account_id());
		ps.setInt(6, transaction.getTo_account_id());
		ps.setDouble(6, transaction.getAmount());
		ps.setDouble(7, transaction.getBalance());
		ps.execute();
		conn.close();
		log.info("Transaction updated in database.");
	}

	@Override
	public void deleteTransaction(Transaction Transaction) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call delete_transaction(?)";
		CallableStatement ps = conn.prepareCall(sql);
		ps.setInt(1, Transaction.getID());
		ps.execute();
		conn.close();
		log.info("Transaction deleted.");
	}
}
