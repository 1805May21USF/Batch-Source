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
			System.out.println("Error caught at EmployeeApproveApplication from BankAdminDAOImpl: " + ex.getMessage());
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
			System.out.println("Error caught at EmployeeApproveApplication from BankAdminDAOImpl: " + ex.getMessage());
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
			System.out.println("Error caught at ListOfOpenApplications in BankAdminDAOImpl: " + ex.getMessage());
		}
		return results;
	}

	/*
	 * t1 - First Name \n\t2 - Last Name" + " \n\t3 - Status
	 */
	@Override
	public boolean BankAdminViewAndEditAccountInfo(String account, String newInfo, int editPosition) {
		Connection conn = cf.getConnection();
		switch (editPosition) {
		// Case 1 : update first name
		case 1:
			try {
				Statement stmt = conn.createStatement();
				String queryString = "update person set firstname = '" + newInfo + "' where accountid = '" + account
						+ "'";
				stmt.executeQuery(queryString);
				// getString(1) = First Name, getString(2) = Last Name, getString(3) = AccountID
				conn.close();
				return true;
			} catch (Exception ex) {
				System.out.println(
						"Error caught at updating first name BankAdminViewAndEditAccountInfo in BankAdminDAOImpl: "
								+ ex.getMessage());
			}
			return false;
		// Case 2 : update last name
		case 2:
			try {
				Statement stmt = conn.createStatement();
				String queryString = "update person set lastname = '" + newInfo + "' where accountid = '" + account
						+ "'";
				stmt.executeQuery(queryString);
				conn.close();
				return true;
			} catch (Exception ex) {
				System.out.println(
						"Error caught at updating last name at BankAdminViewAndEditAccountInfo in BankAdminDAOImpl: "
								+ ex.getMessage());
			}
			return false;
		// Case 3 : Update status
		case 3:
			try {
				Statement stmt = conn.createStatement();
				String queryString = "update person set status = '" + newInfo + "' where accountid = '" + account + "'";
				stmt.executeQuery(queryString);
				conn.close();
				return true;
			} catch (Exception ex) {
				System.out.println(
						"Error caught at updating status at BankAdminViewAndEditAccountInfo in BankAdminDAOImpl: "
								+ ex.getMessage());
			}
			return false;
		default:
			System.out.println("Error caught in Editing Info at BankAdminDAOImpl! ");
		}
		return false;
	}

	@Override
	public void BankAdminWithdraw(String account, String newAmount) {
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			String queryString = "update personaccounts set balance = '" + newAmount + "' where accountid = '" + account
					+ "'";
			stmt.executeQuery(queryString);

		} catch (Exception ex) {
			System.out.println("Error caught at BankAdminWithdraw in BankAdminDAOImpl: " + ex.getMessage());
		}
	}

	@Override
	public void BankAdminDeposit(String account, String newAmount) {
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			String queryString = "update personaccounts set balance = '" + newAmount + "' where accountid = '" + account
					+ "'";
			stmt.executeQuery(queryString);
		} catch (Exception ex) {
			System.out.println("Error caught at BankAdminDeposit in BankAdminDAOImpl: " + ex.getMessage());
		}
	}

	@Override
	public void BankAdminTransfer(String username, String account, String newAmount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void BankAdminCancelAccount(String account) {
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			String queryString = "delete from person where accountid = '" + account + "'";
			stmt.executeQuery(queryString);

		} catch (Exception ex) {
			System.out.println("Error caught at BankAdminCancelAccount in BankAdminDAOImpl: " + ex.getMessage());
		}

	}

	@Override
	public ArrayList<String> ListOfAllAccounts() {
		ArrayList<String> results = new ArrayList<>();
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			String queryString = "select  person.FIRSTNAME, person.lastname, person.ACCOUNTID, personaccounts.balance, person.status "
					+ "FROM person INNER JOIN personaccounts ON person.username = personaccounts.username";
			ResultSet rst = stmt.executeQuery(queryString);
			// getString(1) = First Name, getString(2) = Last Name, getString(3) =
			// AccountID, getString(4) = Balance, getString(5) = status
			while (rst.next()) {
				String status = "";
				//
				switch (rst.getString(5)) {
				case "-1":
					status = "Denied";
					break;
				case "0":
					status = "Open";
					break;
				case "1":
					status = "Customer";
					break;
				case "2":
					status = "Employee";
					break;
				case "3":
					status = "Admin";
					break;
				default:
					status = "Open";
				}
				results.add(rst.getString(1) + "," + rst.getString(2) + "," + rst.getString(3) + "," + rst.getString(4)
						+ "," + status);
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println("Error caught at ListOfOpenApplications in BankAdminDAOImpl: " + ex.getMessage());
		}
		return results;
	}

}
