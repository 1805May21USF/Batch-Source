package com.revature.implementdao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.BankAccount;
import com.revature.dao.BankAccountDAO;
import com.revature.util.ConnFactory;

public class ImpBankAccountDAO implements BankAccountDAO{
	public static ConnFactory cf = ConnFactory.getInstance();
	
	/******Constructors************************/
	public ImpBankAccountDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*********Methods*************************/
	/*
	 * Name: createBankAccount()
	 * Input:int userid
	 * Output:None
	 * Description: Calls procedure to create a bank account in SQL Table BANK_ACCOUNT
	 */
	@Override
	public void createBankAccount(int userid) throws SQLException {
		Connection conn = cf.getConnection();		
		String sql = "{call INSERTBANKACCOUNT(?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, userid);
		call.execute();
		conn.close();
	}

	/*
	 * Name: updateBankAccount()
	 * Input:BankAccount b
	 * Output:None
	 * Description: Calls procedure to update a bank account in SQL Table BANK_ACCOUNT
	 */
	@Override
	public void updateBankAccount(BankAccount b) throws SQLException {
		Connection conn = cf.getConnection();
		
		String sql = "{call UPDATEBANKACCOUNT(?,?,?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, b.getAccountid());
		call.setFloat(2, b.getBalance());
		call.setInt(3, b.getUserid());
		call.execute();
		conn.close();
	}
	
	/*
	 * Name: deleteBankAccount()
	 * Input:int accountid
	 * Output:None
	 * Description: Calls procedure to delete a bank account in SQL Table BANK_ACCOUNT
	 */
	@Override
	public void deleteBankAccount(int accountid) throws SQLException {
		Connection conn = cf.getConnection();	
		String sql = "{call DELETEBANKACCOUNT(?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, accountid);
		call.execute();
		conn.close();
	}

	/*
	 * Name: getUserBankAccounts()
	 * Input:int userid
	 * Output:List<BankAccount>
	 * Description: Calls prepared statement to get all of specific users bank accounts in SQL Table BANK_ACCOUNT
	 */
	@Override
	public List<BankAccount> getUserBankAccounts(int userid) throws SQLException {
		Connection conn = cf.getConnection();
		List<BankAccount> bankAccountList = new ArrayList<BankAccount>();
		String sql = "SELECT * FROM BANK_ACCOUNT WHERE USERID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, userid);
		ResultSet rs = ps.executeQuery();
		BankAccount b = null;
		
		while(rs.next()) {
			b=new BankAccount(rs.getInt(1), rs.getFloat(2), rs.getInt(3));
			bankAccountList.add(b);
		}
		conn.close();
		return bankAccountList;
	}

	/*
	 * Name: getBankAccountList()
	 * Input:None
	 * Output:List<BankAccount>
	 * Description: Calls prepared statement to grab all bank accounts in SQL Table BANK_ACCOUNT
	 */
	@Override
	public List<BankAccount> getBankAccountList() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		List<BankAccount> bankAccountList = new ArrayList<BankAccount>();
		String sql = "SELECT * FROM BANK_ACCOUNT";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery(sql);
		BankAccount b = null;
		
		while(rs.next()) {
			b=new BankAccount(rs.getInt(1), rs.getFloat(2), rs.getInt(3));
			bankAccountList.add(b);
		}
		conn.close();
		return bankAccountList;
	}
}
