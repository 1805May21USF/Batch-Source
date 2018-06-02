package com.revature.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Application;
import com.revature.beans.CustomerApplicationRelation;

public interface CustomerApplicationRelationDAO {
	
	public abstract CustomerApplicationRelation findCustomerApplicationRelation(int ID) throws SQLException;
	public abstract ArrayList<CustomerApplicationRelation> findAllCustomerApplicationRelations() throws SQLException;
	public abstract void createCustomerApplicationRelation(CustomerApplicationRelation CustomerApplicationRelation) throws SQLException;
	public abstract void updateCustomerApplicationRelation(CustomerApplicationRelation CustomerApplicationRelation) throws SQLException;
	public abstract void deleteCustomerApplicationRelation(CustomerApplicationRelation CustomerApplicationRelation) throws SQLException;
	ArrayList<CustomerApplicationRelation> findCustomerApplicationRelationByApplicationId(int ID) throws SQLException;
	ArrayList<CustomerApplicationRelation> findCustomerApplicationRelationByCustomerId(int ID) throws SQLException;

}
