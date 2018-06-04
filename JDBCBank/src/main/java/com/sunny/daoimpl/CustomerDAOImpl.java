package com.sunny.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sunny.beans.Customer;
import com.sunny.dao.CustomerDAO;
import com.sunny.util.ConnFactory;

public class CustomerDAOImpl implements CustomerDAO {

	public static ConnFactory cf = ConnFactory.getInstance();

	public void createCustomer(String fname, String lname, String user, String pass) throws SQLException {
		Connection con = cf.getConnection();
		String[] pk = new String[1];
		pk[0] = "CID";
		String sql = "INSERT INTO BANKCUSTOMER VALUES(ADDBANKCUST.NEXTVAL,?,?,?,?)";

		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql,pk);
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, user);
			ps.setString(4, pass);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ps.close();
		con.close();

	}

	public ArrayList<Customer> getCustomerList() throws SQLException {
		ArrayList<Customer> clist = new ArrayList<Customer>();
		Connection con = cf.getConnection();
		String sql = "SELECT * FROM BANKCUSTOMER";
		PreparedStatement ps;
		ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			clist.add(new Customer(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5)
					));
		}
		rs.close();
		ps.close();
		con.close();
		return clist;
	}

	public boolean customerExists(String user) throws SQLException {
		Connection con = cf.getConnection();

		String sql = "SELECT USERNAME FROM BANKCUSTOMER"
				+ " WHERE USERNAME = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			rs.close();
			ps.close();
			con.close();
			return true;
		} else {
			rs.close();
			ps.close();
			con.close();
			return false;
		}
	}

	public String getPassword(String user) throws SQLException {
		Connection con = cf.getConnection();

		String sql = "SELECT PASS FROM BANKCUSTOMER " +
				"WHERE USERNAME = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user);
		ResultSet rs = ps.executeQuery();
		rs.next();
		String s = rs.getString(1);
		ps.close();
		rs.close();
		con.close();
		return s;
	}

	public int getCustomerID(String user) throws SQLException {

		Connection con = cf.getConnection();

		String sql = "SELECT CID FROM BANKCUSTOMER " +
				"WHERE USERNAME = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int cid = rs.getInt(1);
		rs.close();
		ps.close();
		con.close();
		return cid;

	}

	public Customer getCustomer(int cid) throws SQLException {
		Connection con = cf.getConnection();
		String sql = "SELECT * FROM BANKCUSTOMER WHERE CID = ?";
		PreparedStatement ps;
		ps = con.prepareStatement(sql);
		ps.setInt(1, cid);
		ResultSet rs = ps.executeQuery();
		rs.next();
		Customer c = new Customer(
				rs.getInt(1),
				rs.getString(2),
				rs.getString(3),
				rs.getString(4),
				rs.getString(5)
				);
		rs.close();
		ps.close();
		con.close();
		return c;
	}
}
