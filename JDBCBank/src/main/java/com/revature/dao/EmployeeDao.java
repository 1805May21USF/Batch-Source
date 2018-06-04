package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDao {
	public abstract void createEmployee(String heroName) throws SQLException;
	public abstract List<Employee> getSuperHeroList() throws SQLException;
}
