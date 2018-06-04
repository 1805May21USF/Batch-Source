package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.revature.dao.CustomerDAO;
import com.revature.util.ConnFactory;

public class CustomerDAOImpl implements CustomerDAO {

	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public void CustomerWithdraw(String username, String account, String amount) {
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			String queryString = "update personaccounts set balance = '" + amount + "' where accountid = '" + account
					+ "'";
			stmt.executeQuery(queryString);

		} catch (Exception ex) {
			System.out.println("Error caught at CustomerWithdraw in CustomerDAOImpl: " + ex.getMessage());
		}
	}

	@Override
	public void CustomerDeposit(String username, String account, String amount) {
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			String queryString = "update personaccounts set balance = '" + amount + "' where accountid = '" + account
					+ "'";
			stmt.executeQuery(queryString);

		} catch (Exception ex) {
			System.out.println("Error caught at CustomerDeposit in CustomerDAOImpl: " + ex.getMessage());
		}

	}

	@Override
	public void CustomerTransfer(String username) {
		// TODO Auto-generated method stub

	}

	@Override
	public void CustomerCancelAccount(String account) {
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			String queryString = "delete from person where accountid = '" + account + "'";
			stmt.executeQuery(queryString);

		} catch (Exception ex) {
			System.out.println("Error caught at CustomerCancelAccount in CustomerDAOImpl: " + ex.getMessage());
		}

	}

}
