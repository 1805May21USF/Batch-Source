package com.revature.DAOImple;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.dao.AccountDAO;
import com.revature.util.ConnFactory;
import com.revature.util.UserException;

public class AccountDAOImple implements AccountDAO {
	public static ConnFactory cf = ConnFactory.getInstance();
	public void createAccount(int userID, float balance)  {
		Connection conn = cf.getConnection();
		String sql = "{call INSERTACCOUNT(?,?)";
		
		CallableStatement call;
		try {
			call = conn.prepareCall(sql);
			call.setInt(1, userID);
			call.setFloat(2, balance);
			call.execute();
			conn.close();
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}
	public List<Account> getUserAccountsList(int userID)  {
		List<Account> accountList = new ArrayList<Account>();
		Connection conn= cf.getConnection();//line needed in each method
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNTS WHERE ACCOUNTS.USERID = "+ userID);
			Account a = null;
			
			while(rs.next()) {
				a = new Account(rs.getFloat(3),rs.getInt(2),rs.getInt(1));
				accountList.add(a);
			}
			rs.close();
			conn.close();
			return accountList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accountList;
	}
		public boolean withdraw(int accountID,float amount,float balance) throws UserException {
			if(amount<=balance) {
				
			
				Connection conn = cf.getConnection();
				String sql = "{call WITHDRAWACCOUNT(?,?)";
			
				try {
					PreparedStatement ps= conn.prepareStatement(sql);
					ps.setInt(1, accountID);//1 means the first questionmark from sql
					ps.setFloat(2, amount);
					ps.executeUpdate();
					conn.close();
					return true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Bank is currently closed for scheduled maintainence "+e.getMessage());
				}
			}
			else {
				throw new UserException("You have insufficient funds in your account");
			}
			return false;
		}
		public void deposit(int accountID,float amount,List<Account> accounts) throws UserException {
			for(Account a:accounts) {
				if(a.getAccountID()==accountID) {
					Connection conn = cf.getConnection();
					String sql = "{call DEPOSITACCOUNT(?,?)";
					
					CallableStatement call;
					try {
						call = conn.prepareCall(sql);
						call.setInt(1, accountID);
						call.setFloat(2, amount);
						call.execute();
						conn.close();
						return;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println("Bank is currently closed for scheduled maintainence "+e.getMessage());
					}
				}
			}
			throw new UserException("You entered invalid AccountID");
		}
		public void deleteAccount(int accountID)  {
			Connection conn = cf.getConnection();
			String sql = "{call DELETEACCOUNT(?)";
			
			CallableStatement call;
			try {
				call = conn.prepareCall(sql);
				call.setInt(1, accountID);
				call.execute();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Bank is currently closed for scheduled maintainence "+e.getMessage());
			}
		}

}
