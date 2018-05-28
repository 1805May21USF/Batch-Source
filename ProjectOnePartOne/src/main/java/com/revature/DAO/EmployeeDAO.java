package com.revature.DAO;

import java.util.ArrayList;

import com.revature.beans.Employee;

public interface EmployeeDAO {
	   public ArrayList<Employee> getAllEmployee();
	   public Employee getEmployee(int ID);
	   public void updateEmployee(Employee employee);
	   public void deleteEmployee(Employee employee);
}
