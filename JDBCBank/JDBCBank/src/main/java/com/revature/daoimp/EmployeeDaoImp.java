package com.revature.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.beans.Employee;
import com.revature.beans.User;
import com.revature.dao.EmployeeDao;
import com.revature.util.ConnFactory;

public class EmployeeDaoImp implements EmployeeDao {
	
	public static ConnFactory cf = ConnFactory.getInstance();

	public void createEmployee(Employee employee) throws SQLException {
		
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "EmployeeID";
		
		String sql = "INSERT INTO BANKEMPLOYEE VALUES(EMPLOYEEIDSEQ.NEXTVAL, ?)";
		
		PreparedStatement ps = conn.prepareStatement(sql, primaryKeys);
		ps.setInt(1, employee.getUserID());
		ps.executeUpdate();
		
		
	}

	public void deleteEmployee(int employeeID) throws SQLException {
		
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		stmt.executeQuery("DELETE FROM BANKEMPLOYEE WHERE EMPLOYEEID = '" + employeeID + "'");
		
		
	}

	public Employee getEmployeeByID(int employeeID) throws SQLException {
		
		Employee e = null;
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT FROM BANKEMPLOYEE WHERE EMPLOYEEID = '" + employeeID + "'");
		//u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
		e = new Employee(rs.getInt(1));
		e.setUserID(rs.getInt(2));
		
		return e;
	}

}
