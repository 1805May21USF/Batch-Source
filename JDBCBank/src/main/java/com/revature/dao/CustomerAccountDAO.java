package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.CustomerAccount;

public interface CustomerAccountDAO {
	public abstract List<?> getCustomerAccounts() throws SQLException;
	public abstract void createCustomerAccount(CustomerAccount cus) throws SQLException;
	public abstract void deleteCustomerAccount(CustomerAccount cus) throws SQLException;
	public abstract void updateCustomerAccount(CustomerAccount cus) throws SQLException;
}
