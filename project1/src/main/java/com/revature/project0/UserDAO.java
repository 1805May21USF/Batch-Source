package com.revature.project0;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;


public interface UserDAO {
	//CRUD operations
	public abstract void createUser(String userName) throws SQLException, NotPermittedException;
	public abstract boolean isAdmin();
	public abstract void setAdmin(boolean admin);
	public abstract HashMap<String, String> getLoginInfo() ;
	public abstract void setLoginInfo(HashMap<String, String> loginInfo) ;
	public abstract boolean isActive() ;
	public abstract void setActive(boolean active);
	public abstract double getBalance();
	public abstract void setBalance(double balance) ;

}
