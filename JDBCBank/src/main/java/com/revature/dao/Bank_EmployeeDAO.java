package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

public interface Bank_EmployeeDAO {

	public abstract void createEmployee(int employeeID) throws SQLException;
	public abstract List<Bank_EmployeeDAO> getEmployeeList() throws SQLException;
	public abstract void updateEmployee(int employeeID) throws SQLException;
	public abstract void deleteEmployee(int employeeID) throws SQLException;
}
