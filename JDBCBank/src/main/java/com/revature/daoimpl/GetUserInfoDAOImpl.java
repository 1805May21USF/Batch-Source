package com.revature.daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;

import com.revature.dao.GetUserInfoDAO;
import com.revature.util.ConnFactory;

public class GetUserInfoDAOImpl implements GetUserInfoDAO {
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public String getUserFirstName(String username) {
		String result = "";
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			String queryString = "Select firstname from person where person.username = '" + username + "'";
			ResultSet rst = stmt.executeQuery(queryString);
			if (rst.next()) {
				result = rst.getString(1);
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println("Error caught at getUserFirstName from GetUserInfoDAOImpl: " + ex.getMessage());
		}

		return result;
	}

	@Override
	public String getUserLastName(String username) {
		String result = "";
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			String queryString = "Select lastname from person where person.username = '" + username + "'";
			ResultSet rst = stmt.executeQuery(queryString);
			if (rst.next()) {
				result = rst.getString(1);
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println("Error caught at getUserLastName from GetUserInfoDAOImpl: " + ex.getMessage());
		}

		return result;
	}

	@Override
	public ArrayList<String> getUserAccountNumbers(String username) {

		ArrayList<String> result = new ArrayList<>();
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			String queryString = "Select accountid from person where person.username = '" + username + "'";
			ResultSet rst = stmt.executeQuery(queryString);
			while (rst.next()) {
				result.add(rst.getString(1));
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println("Error caught at getUserAccountNumbers in GetUserInfoDAOImpl: " + ex.getMessage());
		}

		return result;
	}

	@Override
	public ArrayList<String> getUserAccountAndBalanceNumbers(String username) {
		LinkedHashSet<String> result = new LinkedHashSet<String>();
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			String queryString = "Select person.accountid, personaccounts.balance from person inner join personaccounts on person.username = "
					+ "personaccounts.username where person.username = '" + username + "'";
			ResultSet rst = stmt.executeQuery(queryString);
			while (rst.next()) {
				result.add(rst.getString(1) + "," + rst.getString(2));
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println(
					"Error caught at getUserAccountAndBalanceNumbers from GetUserInfoDAOImpl: " + ex.getMessage());
		}
		ArrayList<String> results = new ArrayList<>();
		for (String res : result) {
			results.add(res);
		}
		return results;
	}

	@Override
	public String getUserStatus(String username) {
		String result = "";
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			String queryString = "Select status from person where person.username = '" + username + "'";
			ResultSet rst = stmt.executeQuery(queryString);
			if (rst.next()) {
				result = rst.getString(1);
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println("Error caught at getUserStatus from GetUserInfoDAOImpl: " + ex.getMessage());
		}

		return result;
	}

	@Override
	public String getUserBalance(String accountNumber) {
		String result = "";
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			String queryString = "Select balance from personaccounts where personaccounts.accountid = '" + accountNumber
					+ "'";
			ResultSet rst = stmt.executeQuery(queryString);
			if (rst.next()) {
				result = rst.getString(1);
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println("Error caught at getUserStatus from GetUserInfoDAOImpl: " + ex.getMessage());
		}

		return result;
	}

}
