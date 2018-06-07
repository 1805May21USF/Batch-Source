package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.DAO.ApplicationDAO;
import com.revature.beans.Account;
import com.revature.beans.Application;
import com.revature.util.ConnFactory;

public class ApplicationDAOImpl implements ApplicationDAO{

	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public Application findApplication(int ID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM JDBCBANK_APPLICATION WHERE APPLICATION_ID = ? ";
		CallableStatement ps = conn.prepareCall(sql);
		ps.setInt(1, ID);
		ResultSet rs = ps.executeQuery();
		Application s = null;
		
		while(rs.next()) {
			s = new Application(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4));
		}
		conn.close();
		return s;
	}
	
	@Override
	public Application findApplicationByFingerprint(int ID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM JDBCBANK_APPLICATION WHERE FINGERPRINT = ? ";
		CallableStatement ps = conn.prepareCall(sql);
		ps.setInt(1, ID);
		ResultSet rs = ps.executeQuery();
		Application s = null;
		
		while(rs.next()) {
			s = new Application(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4));
		}
		conn.close();
		return s;
	}

	@Override
	public ArrayList<Application> findAllApplications() throws SQLException {
		ArrayList<Application> ApplicationList = new ArrayList<Application>();
		Connection conn = cf.getConnection();
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM JDBCBANK_APPLICATION");
		Application s = null;
		
		while(rs.next()) {
			s = new Application(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4));
			ApplicationList.add(s);
		}
		conn.close();
		return ApplicationList;
	}

	@Override
	public void createApplication(Application application) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = cf.getConnection();
		String sql = "{call add_application(?,?,?)";
		
		CallableStatement ps = conn.prepareCall(sql);
		ps.setInt(1, application.getFingerprint());
		ps.setDouble(2, application.getBalance());
		ps.setString(3, application.getApproval());
		ps.execute();
		conn.close();
	}

	@Override
	public void updateApplication(Application application) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call update_application(?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, application.getID());
		call.setInt(2, application.getFingerprint());
		call.setDouble(3, application.getBalance());
		call.setString(4, application.getApproval());
		call.execute();
		conn.close();
	}

	@Override
	public void deleteApplication(Application Application) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call delete_application(?)";
		CallableStatement ps = conn.prepareCall(sql);
		ps.setInt(1, Application.getID());
		ps.execute();
		conn.close();
		
	}
}
