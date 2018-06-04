package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;

import com.revature.dao.RegistrationDAO;
import com.revature.util.ConnFactory;

public class RegistrationDAOImpl implements RegistrationDAO {
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public void RegisterNewAccount(String firstName, String lastName, String username, String password,
			String tempAccountNumber) {
		Connection conn = cf.getConnection();

		try {
			PreparedStatement pstmt = conn.prepareStatement("Insert into person values (bankseq.nextval,?,?,?,?,?,?)");
			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.setString(3, username);
			pstmt.setString(4, password);
			pstmt.setInt(5, 0);
			pstmt.setString(6, tempAccountNumber);
			pstmt.executeQuery();
		} catch (Exception ex) {
			System.out.println("Error caught at registering for user into Person database at RegistrationDAOImpl: "
					+ ex.getMessage());
		}

		try {
			PreparedStatement pstmt = conn.prepareStatement("Insert into personaccounts values (?,?,?)");
			pstmt.setString(1, tempAccountNumber);
			pstmt.setString(2, username);
			pstmt.setString(3, "0.00");
			pstmt.executeQuery();
		} catch (Exception ex) {
			System.out.println("Error caught at registering for user into PersonAccounts at RegistrationDAOImpl: "
					+ ex.getMessage());
		}

	}

	@Override
	public void RegisterNewAccount(String firstName1, String lastName1, String username1, String password1,
			String firstName2, String lastName2, String username2, String password2, String tempAccountNumber) {
		Connection conn = cf.getConnection();

		try {
			PreparedStatement pstmt = conn.prepareStatement("Insert into person values (bankseq.nextval,?,?,?,?,?,?)");
			pstmt.setString(1, firstName1);
			pstmt.setString(2, lastName1);
			pstmt.setString(3, username1);
			pstmt.setString(4, password1);
			pstmt.setInt(5, 0);
			pstmt.setString(6, tempAccountNumber);
			pstmt.executeQuery();
			
			PreparedStatement pstmt2 = conn.prepareStatement("Insert into person values (bankseq.nextval,?,?,?,?,?,?)");
			pstmt2.setString(1, firstName2);
			pstmt2.setString(2, lastName2);
			pstmt2.setString(3, username2);
			pstmt2.setString(4, password2);
			pstmt2.setInt(5, 0);
			pstmt2.setString(6, tempAccountNumber);
			pstmt2.executeQuery();
		} catch (Exception ex) {
			System.out.println("Error caught at registering for joint user into Person database at RegistrationDAOImpl: "
					+ ex.getMessage());
		}

		try {
			PreparedStatement pstmt = conn.prepareStatement("Insert into personaccounts values (?,?,?)");
			pstmt.setString(1, tempAccountNumber);
			pstmt.setString(2, username1);
			pstmt.setString(3, "0.00");
			pstmt.executeQuery();
			
			PreparedStatement pstmt2 = conn.prepareStatement("Insert into personaccounts values (?,?,?)");
			pstmt2.setString(1, tempAccountNumber);
			pstmt2.setString(2, username2);
			pstmt2.setString(3, "0.00");
			pstmt2.executeQuery();
		} catch (Exception ex) {
			System.out.println("Error caught at registering for joint user into PersonAccounts at RegistrationDAOImpl: "
					+ ex.getMessage());
		}

	}

}
