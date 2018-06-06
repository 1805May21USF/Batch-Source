package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.AccountDAO;
import com.revature.model.Account;
import com.revature.model.Bank_Customer;
import com.revature.util.ConnFactory;

	

	public class AccountDAOimpl implements AccountDAO {
	 //preparedStatement
		public static ConnFactory cf = ConnFactory.getInstance();
		public void createaccount(int Account) throws SQLException {
			// TODO Auto-generated method stub

		}
public ArrayList<Account> getAccountList() throws SQLException {
	ArrayList<Account> AccountList = new ArrayList<Account>();
	Connection conn = cf.getConnection();
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNT");
	Account ac = null;
	while(rs.next()) {
		ac = new Account(rs.getInt(1), rs.getString(2), rs.getDouble(5),rs.getString(4), rs.getString(3));
		AccountList.add(ac);
	}
	
	return AccountList;
}
		


	public void createAccount(Account account) throws SQLException {
			Connection conn = cf.getConnection();
			String sql = "{call INSERTACCOUNT(?,?,?,?,?)";
			CallableStatement call = conn.prepareCall(sql);
			call.setString(1,Integer.toString(account.getAccountID()));
			call.setString(2, account.getUserName());
			call.setString(3, account.getAccount_Type());
			call.setString(4, account.getAccount_Name());
			call.setString(5,Double.toString(account.getBalance()));
			call.executeQuery();
			
			
		}



		public void deleteAccount(Account account) throws SQLException {
			Connection conn = cf.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "DELETE FROM ACCOUNT WHERE ACCOUNTID =" + account.getAccountID();
			stmt.executeQuery(sql);
		}



		public void updateAccount(Account account) throws SQLException {
			Connection conn = cf.getConnection();
			String sql = "{call UPDATEACCOUNT(?,?,?,?,?)";
			CallableStatement call = conn.prepareCall(sql);
			call.setString(1,Integer.toString(account.getAccountID()));
			call.setString(2, account.getUserName());
			call.setString(3, account.getAccount_Type());
			call.setString(4, account.getAccount_Name());
			call.setString(5,Double.toString(account.getBalance()));
			call.executeQuery();
			
		}

	}


