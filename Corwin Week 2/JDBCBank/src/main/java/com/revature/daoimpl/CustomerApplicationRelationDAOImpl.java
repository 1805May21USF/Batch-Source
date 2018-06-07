package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.DAO.CustomerApplicationRelationDAO;
import com.revature.beans.CustomerAccountRelation;
import com.revature.beans.CustomerApplicationRelation;
import com.revature.util.ConnFactory;

public class CustomerApplicationRelationDAOImpl implements CustomerApplicationRelationDAO {

	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public CustomerApplicationRelation findCustomerApplicationRelation(int ID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM JDBCBANK_CUSTOMER_APPLICATION WHERE REL_ID = ? ";
		CallableStatement ps = conn.prepareCall(sql);
		ps.setInt(1, ID);
		ResultSet rs = ps.executeQuery();
		CustomerApplicationRelation s = null;
		
		while(rs.next()) {
			s = new CustomerApplicationRelation(rs.getInt(1),rs.getInt(2),rs.getInt(3));
		}
		conn.close();
		return s;
	}
	
	@Override
	public ArrayList<CustomerApplicationRelation> findCustomerApplicationRelationByCustomerId(int ID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM JDBCBANK_CUSTOMER_APPLICATION WHERE CUSTOMER_ID = ? ";
		CallableStatement ps = conn.prepareCall(sql);
		ps.setInt(1, ID);
		ResultSet rs = ps.executeQuery();
		ArrayList<CustomerApplicationRelation> car = new ArrayList<CustomerApplicationRelation>();
		
		while(rs.next()) {
			CustomerApplicationRelation s = new CustomerApplicationRelation(rs.getInt(1),rs.getInt(2),rs.getInt(3));
			car.add(s);
		}
		conn.close();
		return car;
	}
	
	@Override
	public ArrayList<CustomerApplicationRelation> findCustomerApplicationRelationByApplicationId(int ID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM JDBCBANK_CUSTOMER_APPLICATION WHERE APPLICATION_ID = ? ";
		CallableStatement ps = conn.prepareCall(sql);
		ps.setInt(1, ID);
		ResultSet rs = ps.executeQuery();
		ArrayList<CustomerApplicationRelation> car = new ArrayList<CustomerApplicationRelation>();
		
		while(rs.next()) {
			CustomerApplicationRelation s = new CustomerApplicationRelation(rs.getInt(1),rs.getInt(2),rs.getInt(3));
			car.add(s);
		}
		conn.close();
		return car;
	}

	@Override
	public ArrayList<CustomerApplicationRelation> findAllCustomerApplicationRelations() throws SQLException {
		ArrayList<CustomerApplicationRelation> CustomerApplicationRelationList = new ArrayList<CustomerApplicationRelation>();
		Connection conn = cf.getConnection();
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM JDBCBANK_CUSTOMER_APPLICATION");
		CustomerApplicationRelation s = null;
		
		while(rs.next()) {
			s = new CustomerApplicationRelation(rs.getInt(1),rs.getInt(2),rs.getInt(3));
			CustomerApplicationRelationList.add(s);
		}
		conn.close();
		return CustomerApplicationRelationList;
	}

	@Override
	public void createCustomerApplicationRelation(CustomerApplicationRelation CustomerApplicationRelation) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		String sql = "{call add_cust_app_relation(?,?)";
		
		CallableStatement ps = conn.prepareCall(sql);
		ps.setInt(1, CustomerApplicationRelation.getCustomer_id());
		ps.setInt(2, CustomerApplicationRelation.getApplication_id());
		ps.execute();
		conn.close();
	}

	@Override
	public void updateCustomerApplicationRelation(CustomerApplicationRelation CustomerApplicationRelation) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call update_cust_app_relation(?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, CustomerApplicationRelation.getId());
		call.setInt(1, CustomerApplicationRelation.getCustomer_id());
		call.setInt(2, CustomerApplicationRelation.getApplication_id());
		call.execute();
		conn.close();
	}

	@Override
	public void deleteCustomerApplicationRelation(CustomerApplicationRelation CustomerApplicationRelation) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call delete_cust_app_relation(?)";
		CallableStatement ps = conn.prepareCall(sql);
		ps.setInt(1, CustomerApplicationRelation.getId());
		ps.execute();
		conn.close();
	}
	
}
