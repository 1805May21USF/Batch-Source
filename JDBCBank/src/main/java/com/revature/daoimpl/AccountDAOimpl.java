package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.revature.dao.AccountDAO;
import com.revature.model.Account;
import com.revature.util.ConnFactory;

	

	public class AccountDAOimpl implements AccountDAO {
	 //preparedStatement
		public static ConnFactory cf = ConnFactory.getInstance();
		public void createaccount(int Account) throws SQLException {
			// TODO Auto-generated method stub

		}

		

		public void createccount(int Account) throws SQLException {
			// TODO Auto-generated method stub
			Connection conn = cf.getConnection();
			String[] primaryKeys = new String[1];
			primaryKeys[0]="accountID";
			String sql = "INSERT INTO ACCOUNT VALUES(POWSEQ.NEXTVAL,?)";
			try {
			PreparedStatement ps = conn.prepareStatement(sql, primaryKeys);
			ps.setInt(1, Account); // the 1 refers to the question mark  in the insert into
			ps.executeUpdate();
			}
		catch 
			(SQLException e){
				e.printStackTrace();
			
		}
		}


		public List<Account> getAccountList() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}



		public void deleteAccount(int Account) throws SQLException {
			// TODO Auto-generated method stub
			Connection conn = cf.getConnection();
			String sql = "DELETE FROM ACCOUNT WHER";
		}



		public void updateAccount(int Account) throws SQLException {
			Connection conn = cf.getConnection();
			String sql = "UPDATE ACCOUNT SET FIRSTNAME = EDWIN, LASTNAME = GARCIA WHERE ACCOUNTID = 1";
			
		}



		public void createAccount(int Account) throws SQLException {
			Connection conn = cf.getConnection();
			String sql = "INSERT INTO ACCOUNT (";
			
		}
	}
		

