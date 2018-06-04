package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDAO {
	// Declares the abstract methods that need to be implemented by a class
	public abstract void createEmployee(String username, String password, String firstName, String lastName, char middleInitial, 
										int age, String address, String city, int zip, String state, String department, double pay) throws SQLException;
	public abstract List<Employee> getEmployeeList(int arg) throws SQLException;
	public abstract void deleteEmployee(int id) throws SQLException;
	public abstract void updateEmployee(Employee e) throws SQLException;
}
