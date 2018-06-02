package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

public interface SuperpowerDAO {

	public abstract void createSuperpower(String powerName) throws SQLException;

}
