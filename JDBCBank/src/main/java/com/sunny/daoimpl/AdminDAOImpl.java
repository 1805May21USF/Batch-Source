package com.sunny.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sunny.dao.AdminDAO;
import com.sunny.util.ConnFactory;

public class AdminDAOImpl implements AdminDAO {
	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public String getPassword(String user) throws SQLException {
		Connection con = cf.getConnection();
		String sql = "SELECT PASSWORD FROM BANKADMIN WHERE USERNAME = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user);
		ResultSet rs = ps.executeQuery();
		rs.next();
		String s = rs.getString(1);
		return s;
	}

	public boolean adminExists(String user) throws SQLException {
		Connection con = cf.getConnection();
		String sql = "SELECT * FROM BANKADMIN WHERE USERNAME = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			rs.close();
			ps.close();
			con.close();
			return true;
		}
		rs.close();
		ps.close();
		con.close();
		return false;
	}

}
