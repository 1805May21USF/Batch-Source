package com.revature.DaoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.Customer;
import com.revature.dao.CustomerDao;
import com.revature.util.ConnFactory;

public class CustomerDaoImpl implements CustomerDao {
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public CustomerDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public void createCustomer(String Firstname, String Lastname, String Username, String Password, int status, 
			int accountNumber, int accountId) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn2 = cf.getConnection();
		
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "User_id";
		String sql = "Insert into Users values(useridseq.nextval, ?,?,?,?,?,?,?)";
		
		PreparedStatement stmt = conn2.prepareStatement(sql, primaryKeys);
		stmt.setString(1, Firstname);
		stmt.setString(2, Lastname);
		stmt.setString(3, Username);
		stmt.setString(4, Password);
		stmt.setInt(5, status);
		stmt.setDouble(6, accountNumber);
		stmt.setDouble(7, accountId);
		stmt.executeUpdate();
		conn2.close();
	}

	public Customer readCustomer(String Username, String Password) throws SQLException {
		// TODO Auto-generated method stub
		Customer customer = null;
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "User_id";
		String sql = "Select * from Users where username = ?";
		PreparedStatement stmt = conn.prepareStatement(sql, primaryKeys);
		stmt.setString(1, Username);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			String Firstname = rs.getString(2);
			String Lastname = rs.getString(3);
			String username = rs.getString(4);
			String password = rs.getString(5);
			int account_number = rs.getInt(6);
			int status = rs.getInt(7);
			customer = new Customer(Firstname, Lastname, username, password, status, account_number);
		}
		conn.close();
		return customer;
	}

	public void updateCustomer(String Username, String Password) throws SQLException {
		// TODO Auto-generated method stub
		Customer customer = null;
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "User_id";
		String sql = "UPDATE users SET column1 = value1, column2 = value2, ...\r\n" + 
				"WHERE condition;";
		PreparedStatement stmt = conn.prepareStatement(sql, primaryKeys);
		stmt.setString(1, Username);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			String Firstname = rs.getString(2);
			String Lastname = rs.getString(3);
			String username = rs.getString(4);
			String password = rs.getString(5);
			int account_number = rs.getInt(6);
			int status = rs.getInt(7);
			customer = new Customer(Firstname, Lastname, username, password, status, account_number);
		}
		conn.close();
	}

	public void deleteCustomer(String Username, String Password) throws SQLException {
		// TODO Auto-generated method stub
		//Customer customer = null;
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "User_id";
		String sql = "DELETE from users u where u.username = ?";
		PreparedStatement stmt = conn.prepareStatement(sql, primaryKeys);
		stmt.setString(1, Username);
		ResultSet rs = stmt.executeQuery();
		conn.close();
	}
	
	public void deleteCustomer(String username) throws SQLException{
		Connection conn = cf.getConnection();
		String sql = "{call deleteUser(?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, username);
		call.execute();
		conn.close();
	}
	
	public void deleteAllUsers() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "User_id";
		String sql = "DELETE from users u where u.status = ?";
		PreparedStatement stmt = conn.prepareStatement(sql, primaryKeys);
		stmt.setInt(1, 1);
		ResultSet rs = stmt.executeQuery();
		conn.close();
	}

	public List<Customer> getCustomer() throws SQLException {
		// TODO Auto-generated method stub
		List<Customer> customerList = new ArrayList<Customer>();
		Customer customer = null;
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "User_id";
		String sql = "Select * from Users";
		PreparedStatement stmt = conn.prepareStatement(sql, primaryKeys);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			String Firstname = rs.getString(2);
			String Lastname = rs.getString(3);
			String username = rs.getString(4);
			String password = rs.getString(5);
			int account_number = rs.getInt(6);
			int status = rs.getInt(7);
			customer = new Customer(Firstname, Lastname, username, password, status, account_number);
			customerList.add(customer);
		}
		conn.close();
		return customerList;
	}
}
