package com.revature.driver;
import java.sql.SQLException;

public abstract interface BankPersonDAO {

	public abstract boolean createBankPerson(String name, String pass, int rank, String fn, String ln) throws SQLException;
	public abstract boolean deleteBankPerson(String name) throws SQLException;
	
	
}
