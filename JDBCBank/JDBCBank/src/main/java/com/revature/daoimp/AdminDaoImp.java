package com.revature.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.beans.Admin;
import com.revature.dao.AdminDao;
import com.revature.util.ConnFactory;

public class AdminDaoImp implements AdminDao {
	
	public static ConnFactory cf = ConnFactory.getInstance();

	public void createAdmin(Admin admin) throws SQLException {
		
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "AdminID";
		
		String sql = "INSERT INTO ADMIN VALUES(ADMINIDSEQ.NEXTVAL, ?)";
		
		PreparedStatement ps = conn.prepareStatement(sql, primaryKeys);
		ps.setInt(1, admin.getUserID());
		ps.executeUpdate();
		
		
	}

	public void deleteAdmin(int adminID) throws SQLException {
		
		
	}

	public Admin getAdminByID(int adminID) throws SQLException {
		
		return null;
	}
	
	

}
