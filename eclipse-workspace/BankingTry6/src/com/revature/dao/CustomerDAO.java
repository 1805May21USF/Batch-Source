package com.revature.dao;

import java.sql.*;

import java.util.*;
import com.revature.beans.*;

public interface CustomerDAO {
//CRUD operations
	public abstract void createCustomer(String lastName) throws SQLException;
	public abstract List<Customer> getCustomerList() throws SQLException;
}
