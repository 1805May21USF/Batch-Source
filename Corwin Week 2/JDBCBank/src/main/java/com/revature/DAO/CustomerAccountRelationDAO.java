package com.revature.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Application;
import com.revature.beans.CustomerAccountRelation;

public interface CustomerAccountRelationDAO {
	
	public abstract CustomerAccountRelation findCustomerAccountRelation(int ID) throws SQLException;
	public abstract ArrayList<CustomerAccountRelation> findAllCustomerAccountRelations() throws SQLException;
	public abstract void createCustomerAccountRelation(CustomerAccountRelation CustomerAccountRelation) throws SQLException;
	public abstract void updateCustomerAccountRelation(CustomerAccountRelation CustomerAccountRelation) throws SQLException;
	public abstract void deleteCustomerAccountRelation(CustomerAccountRelation CustomerAccountRelation) throws SQLException;
	ArrayList<CustomerAccountRelation> findCustomerAccountRelationByCustomerId(int ID) throws SQLException;
	ArrayList<CustomerAccountRelation> findCustomerAccountRelationByAccountId(int ID) throws SQLException;

}
