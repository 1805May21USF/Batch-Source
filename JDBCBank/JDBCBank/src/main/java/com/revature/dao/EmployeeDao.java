package com.revature.dao;

import java.sql.SQLException;

import com.revature.beans.Employee;

public interface EmployeeDao {
	
	public abstract void createEmployee(Employee employee) throws SQLException;
	public abstract void deleteEmployee(int employeeID) throws SQLException;
	public abstract Employee getEmployeeByID(int employeeID) throws SQLException;

}
