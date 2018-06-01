package com.revature.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import com.revature.beans.Employee;

public interface EmployeeDAO {
	
	public abstract Employee findEmployee(int ID) throws SQLException;
	public abstract Employee findEmployeeByUsername(String username) throws SQLException;
	public abstract ArrayList<Employee> findAllEmployees() throws SQLException;
	public abstract void createEmployee(Employee employee) throws SQLException;
	public abstract void updateEmployee(Employee employee) throws SQLException;
	public abstract void deleteEmployee(Employee employee) throws SQLException;

}
