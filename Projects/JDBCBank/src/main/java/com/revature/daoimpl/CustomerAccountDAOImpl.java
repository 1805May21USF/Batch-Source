package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.CustomerAccount;
import com.revature.dao.CustomerAccountDAO;
import com.revature.util.ConnFactory;

/*
 * Implementation of the customer account DAO.
 */
public class CustomerAccountDAOImpl implements CustomerAccountDAO {
	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public List<CustomerAccount> getCustomerAccounts() throws SQLException {
		List<CustomerAccount> customerAccounts = new ArrayList<CustomerAccount>();
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM CUSTOMER_ACCOUNT ORDER BY USER_ID";	
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		CustomerAccount a = null;
		
		while (rs.next()) {
			a = new CustomerAccount(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			customerAccounts.add(a);
		}
		conn.close();
		return customerAccounts;
	}

	@Override
	public void createCustomerAccount(CustomerAccount cus) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call INSERTCUSTOMER(?,?,?,?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, cus.getUsername());
		call.setString(2, cus.getPassword());
		call.setString(3, cus.getFirstname());
		call.setString(4, cus.getLastname());
		call.execute();
		conn.close();
	}

	@Override
	public void deleteCustomerAccount(CustomerAccount cus) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call DELETECUSTOMER(?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, cus.getUser_ID());
		call.execute();
		conn.close();
	}

	@Override
	public void updateCustomerAccount(CustomerAccount cus) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call UPDATECUSTOMER(?,?,?,?,?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, cus.getUser_ID());
		call.setString(2, cus.getUsername());
		call.setString(3, cus.getPassword());
		call.setString(4, cus.getFirstname());
		call.setString(5, cus.getLastname());
		call.execute();
		conn.close();
	}
}
