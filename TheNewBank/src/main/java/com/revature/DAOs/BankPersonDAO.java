package com.revature.DAOs;
import java.sql.SQLException;

public abstract interface BankPersonDAO {

	public abstract boolean createBankPerson(String name, String pass, int rank) throws SQLException;
	public abstract boolean deleteBankPerson(String name) throws SQLException;
	
	
}
