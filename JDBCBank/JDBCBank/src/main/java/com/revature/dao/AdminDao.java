package com.revature.dao;

import java.sql.SQLException;

import com.revature.beans.Admin;

public interface AdminDao {
	
	public abstract void createAdmin(Admin admin) throws SQLException;
	public abstract void deleteAdmin(int adminID) throws SQLException;
	public abstract Admin getAdminByID(int adminID) throws SQLException;

}
