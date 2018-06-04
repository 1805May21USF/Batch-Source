package com.sunny.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sunny.beans.Account;
import com.sunny.dao.AccountDAO;
import com.sunny.util.ConnFactory;

public class AccountDAOImpl implements AccountDAO {

	public static ConnFactory cf = ConnFactory.getInstance();
	
	
	public int createAccount(int type, float balance) throws SQLException {
		Connection con = cf.getConnection();
		String[] pk = new String[1];
		pk[0] = "AID";
		int aid = 0;
		String sqlgrabseq = "SELECT ADDBANKACC.NEXTVAL FROM DUAL";
		PreparedStatement ps;
		ps = con.prepareStatement(sqlgrabseq);
		ResultSet rs = ps.executeQuery();
		rs.next();
		aid = rs.getInt(1);
		rs.close();
		
		String sqlinsert= "INSERT INTO BANKACCOUNT VALUES(?,?,?)";
		
		ps = con.prepareStatement(sqlinsert,pk);
		ps.setInt(1,aid);
		ps.setFloat(2, balance);
		ps.setInt(3, type);
		ps.executeQuery();
		ps.close();
		con.close();
		return aid;
	}

	public ArrayList<Account> getAccountList() throws SQLException {
		ArrayList<Account> aList = new ArrayList<Account>();
		Connection con = cf.getConnection();
		PreparedStatement ps;
		String sql = "SELECT * FROM BANKACCOUNT";
		ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			aList.add(new Account(
					rs.getInt(1),
					rs.getInt(3),
					rs.getFloat(2)
					));
		}
		rs.close();
		ps.close();
		con.close();
		return aList;
	}
	
	public Account getAccount(int aid) throws SQLException {
		Connection con = cf.getConnection();
		PreparedStatement ps;
		String sql = "SELECT * FROM BANKACCOUNT WHERE AID = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, aid);
		ResultSet rs = ps.executeQuery();
		rs.next();
		Account a = new Account(
				rs.getInt(1),
				rs.getInt(3),
				rs.getFloat(2)
				);
		rs.close();
		ps.close();
		con.close();
		return a;
	}

	public void setBalance(float balance, int aid) throws SQLException {
		Connection con = cf.getConnection();
		String sql = "UPDATE BANKACCOUNT SET BALANCE = ? WHERE AID = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setFloat(1, balance);
		ps.setInt(2, aid);
		ps.executeQuery();
		ps.close();
		con.close();
	}
	
	public void deleteAccount(int aid) throws SQLException {
		Connection con = cf.getConnection();
		String sql = "DELETE BANKACCOUNT WHERE AID = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, aid);
		ps.executeQuery();
		ps.close();
		con.close();
	}


}
