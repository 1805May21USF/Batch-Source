package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.DAO.CustomerDAO;
import com.revature.beans.Customer;
import com.revature.util.ConnFactory;

public class CustomerDAOImpl implements CustomerDAO{
	
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public Customer findCustomer(int ID) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findCustomerByUsername(String username) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM JBDCBANK_CUSTOMER WHERE USERNAME=?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		return null;
		
	}

	@Override
	public ArrayList<Customer> findAllCustomers() throws SQLException {
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		Connection conn = cf.getConnection();
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM JDBCBANK_CUSTOMER;");
		Customer s = null;
		
		while(rs.next()) {
			s = new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			customerList.add(s);
		}
		return customerList;
	}

	@Override
	public void createCustomer(Customer customer) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		String sql = "{call add_customer(?,?,?,?)";
		
		CallableStatement ps = conn.prepareCall(sql);
		ps.setString(1, customer.getUserName());
		ps.setString(2, customer.getPassWord());
		ps.setString(3, customer.getFname());
		ps.setString(4, customer.getLname());
		ps.execute();
	}

	@Override
	public void updateCustomer(Customer customer) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call update_customer(?,?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, customer.getID());
		call.setString(2, customer.getUserName());
		call.setString(3, customer.getPassWord());
		call.setString(4, customer.getFname());
		call.setString(5, customer.getFname());
		call.execute();
	}

	@Override
	public void deleteCustomer(Customer customer) throws SQLException {
		// TODO Auto-generated method stub
		
	}


}
