package com.revature.daoimpl;


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

		

		public void createcustomerID(String customerID) throws SQLException {
			// TODO Auto-generated method stub
			Connection conn = cf.getConnection();
			String[] primaryKeys = new String[1];
			primaryKeys[0]="CustomerID";
			String sql = "INSERT INTO BANK_CUSTOMER( CUSTOMERID,USERNAME, PASSWORD,FIRST_NAME,LAST_NAME,SOCIAL_SECURITY,AGE,ADDRESS,CITY,STATE,ZIPCODE)"
					+ "VALUES ( 1,EDWIN123,PASSWORD1234,EDWIN,GARCIA,234-444-4444,34,STREET AVE.,34544 )(POWSEQ.NEXTVAL,?)";
			try {
			PreparedStatement ps = conn.prepareStatement(sql, primaryKeys);
			ps.setString(1, customerID); // the 1 refers to the question mark  in the insert into
			ps.executeUpdate();
			}
		catch 
			(SQLException e){
				e.printStackTrace();
			
		}
		}

		public List<Bank_Customer> getCustomerList() throws SQLException {
			List<Bank_Customer> Bank_CustomerList = new ArrayList<Bank_Customer>();
			Connection conn = cf.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM BANK_CUSTOMER");
			Bank_Customer bc = null;
			while(rs.next()) {
				bc = new Bank_Customer(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),rs.getString(9), rs.getString(10),rs.getString(11));
				Bank_CustomerList.add(bc);
			}
			
			return Bank_CustomerList;
		}



		public void updateCustomer(int customerID) throws SQLException {
			// TODO Auto-generated method stub
			
		}



		public void deleteCustomer(int customerID) throws SQLException {
			// TODO Auto-generated method stub
			
		}



		public void createCustomer(String customerID) throws SQLException {
			// TODO Auto-generated method stub
			
		}
	}
		

