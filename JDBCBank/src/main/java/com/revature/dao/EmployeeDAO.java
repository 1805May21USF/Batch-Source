package com.revature.dao;

import java.util.ArrayList;

public interface EmployeeDAO {
	public abstract ArrayList<String> ListOfOpenApplications();

	public abstract void EmployeeApproveApplication(String account);

	public abstract void EmployeeDenyApplication(String account);

	public abstract ArrayList<String> EmployeeViewAccountInfo();
}
