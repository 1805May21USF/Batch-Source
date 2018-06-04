package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.dao.BankAdminDAO;
import com.revature.util.ConnFactory;

public class BankAdminDAOImpl implements BankAdminDAO {
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public void BankAdminApproveApplication(String account) {
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			String queryString = "update person set status = '1' where accountid = '" + account + "'";
			stmt.executeQuery(queryString);
			conn.close();
		} catch (Exception ex) {
			System.out.println("Error caught at EmployeeApproveApplication from EmployeeDAOImpl: " + ex.getMessage());
		}

	}

	@Override
	public void BankAdminDenyApplication(String account) {
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			String queryString = "update person set status = '-1' where accountid = '" + account + "'";
			stmt.executeQuery(queryString);
			conn.close();
		} catch (Exception ex) {
			System.out.println("Error caught at EmployeeApproveApplication from EmployeeDAOImpl: " + ex.getMessage());
		}

	}

	@Override
	public ArrayList<String> ListOfOpenApplications() {
		ArrayList<String> results = new ArrayList<>();
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			String queryString = "select firstname, lastname, accountid from person where status = 0";
			ResultSet rst = stmt.executeQuery(queryString);
			// getString(1) = First Name, getString(2) = Last Name, getString(3) = AccountID
			while (rst.next()) {
				results.add(rst.getString(1) + "," + rst.getString(2) + "," + rst.getString(3));
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println("Error caught at ListOfOpenApplications in EmployeeDAOImpl: " + ex.getMessage());
		}
		return results;
	}

	@Override
	public ArrayList<String> BankAdminViewAndEditAccountInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void BankAdminWithdraw(String username, String account, String amount) {
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			String queryString = "update personaccounts set balance = '" + amount + "' where accountid = '" + account
					+ "'";
			stmt.executeQuery(queryString);

		} catch (Exception ex) {
			System.out.println("Error caught at BankAdminWithdraw in BankAdminDAOImpl: " + ex.getMessage());
		}
	}

	@Override
	public void BankAdminDeposit(String username, String account, String amount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void BankAdminTransfer(String username, String account, String amount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void BankAdminCancelAccount(String username) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<String> ListOfAllAccounts() {
		ArrayList<String> results = new ArrayList<>();
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			String queryString = "select  person.FIRSTNAME, person.lastname, person.ACCOUNTID, personaccounts.balance "
					+ "FROM person INNER JOIN personaccounts ON person.username = personaccounts.username";
			ResultSet rst = stmt.executeQuery(queryString);
			// getString(1) = First Name, getString(2) = Last Name, getString(3) = AccountID, getString(4) = Balance
			while (rst.next()) {
				results.add(rst.getString(1) + "," + rst.getString(2) + "," + rst.getString(3) + "," + rst.getString(4));
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println("Error caught at ListOfOpenApplications in EmployeeDAOImpl: " + ex.getMessage());
		}
		return results;
	}

}
