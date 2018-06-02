package com.revature.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Application;
import com.revature.beans.Customer;

public interface ApplicationDAO {
	
	public abstract Application findApplication(int ID) throws SQLException;
	public abstract ArrayList<Application> findAllApplications() throws SQLException;
	public abstract void createApplication(Application Application) throws SQLException;
	public abstract void updateApplication(Application Application) throws SQLException;
	public abstract void deleteApplication(Application Application) throws SQLException;
	Application findApplicationByFingerprint(int ID) throws SQLException;

}
