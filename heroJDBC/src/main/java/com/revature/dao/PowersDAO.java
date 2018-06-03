package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Powers;

public interface PowersDAO {
	
	public abstract void createPower(String powerName) throws SQLException;

}
