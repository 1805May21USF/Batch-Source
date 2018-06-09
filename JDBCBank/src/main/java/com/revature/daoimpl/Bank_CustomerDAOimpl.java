package com.revature.daoimpl;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.revature.dao.AccountDAO;
import com.revature.dao.Bank_CustomerDAO;
import com.revature.dao.Bank_EmployeeDAO;
import com.revature.model.Account;
import com.revature.model.Bank_Customer;
import com.revature.util.ConnFactory;

	

	public class Bank_CustomerDAOimpl implements Bank_CustomerDAO {
	 //preparedStatement
		public static ConnFactory cf = ConnFactory.getInstance();
		public void createcustomer(int customer) throws SQLException {
			// TODO Auto-generated method stub

		}

		
		public void createCustomer(Bank_Customer bankCustomer) throws SQLException {
			// TODO Auto-generated method stub
			Connection conn = cf.getConnection();
					String sql = "{call INSERTBANKCUSTOMER(?,?,?,?,?,?,?,?,?,?)";
					CallableStatement call = conn.prepareCall(sql);
					//call.setString(1,Integer.toString(bankCustomer.getCustomerID()));
					call.setString(1, bankCustomer.getUserName());
					call.setString(2, bankCustomer.getPassword());
					call.setString(3,"");
					call.setString(4, "");
					call.setString(5,"");
					call.setString(6,"");
					call.setString(7,"");
					call.setString(8, "");
					call.setString(9, "");
					call.setString(10, "");
					call.execute();
					
					
		//	String sql = "INSERT INTO BANK_CUSTOMER( CUSTOMERID,USERNAME, PASSWORD,FIRST_NAME,LAST_NAME,SOCIAL_SECURITY,AGE,ADDRESS,CITY,STATE,ZIPCODE)"
				//	+ "VALUES ( 1,EDWIN123,PASSWORD1234,EDWIN,GARCIA,234-444-4444,34,STREET AVE.,34544 )(POWSEQ.NEXTVAL,?)";
			
			
		}
		

		public ArrayList<Bank_Customer> getCustomerList() throws SQLException {
			ArrayList<Bank_Customer> Bank_CustomerList = new ArrayList<Bank_Customer>();
			Connection conn = cf.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM BANK_CUSTOMER");
			Bank_Customer bc = null;
			while(rs.next()) {
				bc = new Bank_Customer(rs.getString(1), rs.getString(2));
				Bank_CustomerList.add(bc);
			}
			
			return Bank_CustomerList;
		}



		public void updateCustomer(Bank_Customer bankCustomer) throws SQLException {
			Connection conn = cf.getConnection();
			String sql = "{call UPDATEBANKCUSTOMER(?,?,?,?,?,?,?,?,?,?,?)";
			CallableStatement call = conn.prepareCall(sql);
			//call.setString(1,Integer.toString(bankCustomer.getCustomerID()));
			call.setString(1, bankCustomer.getUserName());
			call.setString(2, bankCustomer.getPassword());
			call.setString(3, bankCustomer.getFirst_Name());
			call.setString(4, bankCustomer.getLast_name());
			call.setString(5, bankCustomer.getSocial_Security());
			call.setString(6, bankCustomer.getAge());
			call.setString(7,bankCustomer.getAddress());
			call.setString(8, bankCustomer.getCity());
			call.setString(9, bankCustomer.getState());
			call.setString(10, bankCustomer.getZipcode());
			call.execute();
			
		}



		public void deleteCustomer(Bank_Customer bankCustomer) throws SQLException {
			// TODO Auto-generated method stub
			
		}



		

		
	}
		

