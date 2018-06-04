package com.sunny.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sunny.beans.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AdminDAO {

	public abstract String getPassword(String user) throws SQLException;
	public abstract boolean adminExists(String user) throws SQLException;
}
