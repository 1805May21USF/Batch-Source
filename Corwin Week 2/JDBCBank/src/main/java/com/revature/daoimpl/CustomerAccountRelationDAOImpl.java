package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.DAO.CustomerAccountRelationDAO;
import com.revature.beans.CustomerAccountRelation;
import com.revature.util.ConnFactory;

public class CustomerAccountRelationDAOImpl implements CustomerAccountRelationDAO {

	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public CustomerAccountRelation findCustomerAccountRelation(int ID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM JDBCBANK_CUSTOMER_ACCOUNT WHERE REL_ID = ? ";
		CallableStatement ps = conn.prepareCall(sql);
		ps.setInt(1, ID);
		ResultSet rs = ps.executeQuery();
		CustomerAccountRelation s = null;
		
		while(rs.next()) {
			s = new CustomerAccountRelation(rs.getInt(1),rs.getInt(2),rs.getInt(3));
		}
		conn.close();
		return s;
	}
	
	@Override
	public ArrayList<CustomerAccountRelation> findCustomerAccountRelationByCustomerId(int ID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM JDBCBANK_CUSTOMER_ACCOUNT WHERE CUSTOMER_ID = ? ";
		CallableStatement ps = conn.prepareCall(sql);
		ps.setInt(1, ID);
		ResultSet rs = ps.executeQuery();
		ArrayList<CustomerAccountRelation> car = new ArrayList<CustomerAccountRelation>();
		
		while(rs.next()) {
			CustomerAccountRelation s = new CustomerAccountRelation(rs.getInt(1),rs.getInt(2),rs.getInt(3));
			car.add(s);
		}
		conn.close();
		return car;
	}
	
	@Override
	public ArrayList<CustomerAccountRelation> findCustomerAccountRelationByAccountId(int ID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM JDBCBANK_CUSTOMER_ACCOUNT WHERE ACCOUNT_ID = ? ";
		CallableStatement ps = conn.prepareCall(sql);
		ps.setInt(1, ID);
		ResultSet rs = ps.executeQuery();
		ArrayList<CustomerAccountRelation> car = new ArrayList<CustomerAccountRelation>();
		
		while(rs.next()) {
			CustomerAccountRelation s = new CustomerAccountRelation(rs.getInt(1),rs.getInt(2),rs.getInt(3));
			car.add(s);
		}
		conn.close();
		return car;
	}

	@Override
	public ArrayList<CustomerAccountRelation> findAllCustomerAccountRelations() throws SQLException {
		ArrayList<CustomerAccountRelation> CustomerAccountRelationList = new ArrayList<CustomerAccountRelation>();
		Connection conn = cf.getConnection();
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM JDBCBANK_CUSTOMER_ACCOUNT");
		CustomerAccountRelation s = null;
		
		while(rs.next()) {
			s = new CustomerAccountRelation(rs.getInt(1),rs.getInt(2),rs.getInt(3));
			CustomerAccountRelationList.add(s);
		}
		conn.close();
		return CustomerAccountRelationList;
	}

	@Override
	public void createCustomerAccountRelation(CustomerAccountRelation CustomerAccountRelation) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		String sql = "{call add_cust_acc_relation(?,?)";
		
		CallableStatement ps = conn.prepareCall(sql);
		ps.setInt(1, CustomerAccountRelation.getCustomer_id());
		ps.setInt(2, CustomerAccountRelation.getAccount_id());
		ps.execute();
	}

	@Override
	public void updateCustomerAccountRelation(CustomerAccountRelation CustomerAccountRelation) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call update_cust_acc_relation(?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, CustomerAccountRelation.getId());
		call.setInt(1, CustomerAccountRelation.getCustomer_id());
		call.setInt(2, CustomerAccountRelation.getAccount_id());
		call.execute();
		conn.close();
	}

	@Override
	public void deleteCustomerAccountRelation(CustomerAccountRelation CustomerAccountRelation) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call delete_cust_acc_relation(?)";
		CallableStatement ps = conn.prepareCall(sql);
		ps.setInt(1, CustomerAccountRelation.getId());
		ps.execute();
		conn.close();
	}

}
