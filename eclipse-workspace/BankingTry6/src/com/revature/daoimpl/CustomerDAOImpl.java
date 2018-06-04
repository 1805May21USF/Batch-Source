package com.revature.daoimpl;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Customer;
import com.revature.dao.CustomerDAO;
import com.revature.util.ConnFactory;

public class CustomerDAOImpl implements CustomerDAO {
	public static ConnFactory cf = ConnFactory.getInstance();
	public void createCustomer(String lastName) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call INSERTCUSTOMER(?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1,lastName);
		call.execute();
	}
	public List <Customer> getCustomerList() throws SQLException {
		List<Customer> customerList = new ArrayList<Customer>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM BANKSUSER");
		Customer s = null;
		
		while(rs.next()) {
			s = new Customer(rs.getInt(1),rs.getString(2));
			customerList.add(s);
		}
		return customerList;
	}

}
