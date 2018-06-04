package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

import com.revature.dao.EmployeeDAO;
import com.revature.util.ConnFactory;

public class EmployeeDAOImpl implements EmployeeDAO {
	public static ConnFactory cf = ConnFactory.getInstance();
	Scanner input = new Scanner(System.in);

	@Override
	public void EmployeeApproveApplication(String account) {
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
	public void EmployeeDenyApplication(String account) {
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
	public ArrayList<String> EmployeeViewAccountInfo() {
		LinkedHashSet<String>  results = new LinkedHashSet<>();
		ArrayList<String> result = new ArrayList<>();
		Connection conn = cf.getConnection();
		try {
			Statement stmt = conn.createStatement();
			String queryString = "select firstname, lastname, accountid from person where status < 2";
			ResultSet rst = stmt.executeQuery(queryString);
			// getString(1) = First Name, getString(2) = Last Name, getString(3) = AccountID
			while (rst.next()) {
				results.add(rst.getString(1) + "," + rst.getString(2) + "," + rst.getString(3));
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println("Error caught at EmployeeViewAccountInfo in EmployeeDAOImpl: " + ex.getMessage());
		}
		for (String r : results) {
			result.add(r);
		}
		return result;
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

}
