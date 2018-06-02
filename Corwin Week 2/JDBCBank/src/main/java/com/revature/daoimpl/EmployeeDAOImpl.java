package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.DAO.EmployeeDAO;
import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.util.ConnFactory;

public class EmployeeDAOImpl implements EmployeeDAO {

	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public Employee findEmployee(int ID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM JDBCBANK_EMPLOYEE WHERE EMPLOYEE_ID = ? ";
		CallableStatement ps = conn.prepareCall(sql);
		ps.setInt(1, ID);
		ResultSet rs = ps.executeQuery();
		Employee s = null;
		
		while(rs.next()) {
			s = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
		}
		conn.close();
		return s;
	}

	@Override
	public Employee findEmployeeByUsername(String username) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM JDBCBANK_EMPLOYEE WHERE USERNAME = ? ";
		CallableStatement ps = conn.prepareCall(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		Employee s = null;
		
		while(rs.next()) {
			s = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
		}
		conn.close();
		return s;
		
	}

	@Override
	public ArrayList<Employee> findAllEmployees() throws SQLException {
		ArrayList<Employee> EmployeeList = new ArrayList<Employee>();
		Connection conn = cf.getConnection();
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM JDBCBANK_EMPLOYEE");
		Employee s = null;
		
		while(rs.next()) {
			s = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			EmployeeList.add(s);
		}
		conn.close();
		return EmployeeList;
	}

	@Override
	public void createEmployee(Employee Employee) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		String sql = "{call add_employee(?,?,?,?)";
		
		CallableStatement ps = conn.prepareCall(sql);
		ps.setString(1, Employee.getUserName());
		ps.setString(2, Employee.getPassWord());
		ps.setString(3, Employee.getFname());
		ps.setString(4, Employee.getLname());
		ps.execute();
		conn.close();
	}

	@Override
	public void updateEmployee(Employee Employee) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call update_employee(?,?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, Employee.getID());
		call.setString(2, Employee.getUserName());
		call.setString(3, Employee.getPassWord());
		call.setString(4, Employee.getFname());
		call.setString(5, Employee.getFname());
		call.execute();
		conn.close();
	}

	@Override
	public void deleteEmployee(Employee Employee) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call delete_employee(?)";
		CallableStatement ps = conn.prepareCall(sql);
		ps.setInt(1, Employee.getID());
		ps.execute();
		conn.close();
	}

}
