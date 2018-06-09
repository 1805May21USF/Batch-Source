package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.revature.dao.AccountDAO;
import com.revature.dao.Bank_EmployeeDAO;
import com.revature.model.Account;
import com.revature.util.ConnFactory;

	

	public class Bank_EmployeeDAOimpl implements Bank_EmployeeDAO {
	 //preparedStatement
		public static ConnFactory cf = ConnFactory.getInstance();
		public void createemployee(int employeeid) throws SQLException {
			// TODO Auto-generated method stub

		}

		

		public void createEmployeeID(int employeeID) throws SQLException {
			// TODO Auto-generated method stub
			Connection conn = cf.getConnection();
			String[] primaryKeys = new String[1];
			primaryKeys[0]="accountID";
			String sql = "INSERT INTO BANK_EMPLOYEE VALUES(POWSEQ.NEXTVAL,?)";
			try {
			PreparedStatement ps = conn.prepareStatement(sql, primaryKeys);
			ps.setInt(1, employeeID); // the 1 refers to the question mark  in the insert into
			ps.executeUpdate();
			}
		catch 
			(SQLException e){
				e.printStackTrace();
			
		}
		}



		public void createAccount(int Account) throws SQLException {
			// TODO Auto-generated method stub
			
		}



		public List<Account> getAccountList() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}



		public void deleteAccount(int Account) throws SQLException {
			// TODO Auto-generated method stub
			
		}



		public void updateAccount(int Account) throws SQLException {
			// TODO Auto-generated method stub
			
		}



		public void createEmployee(int employeeID) throws SQLException {
			// TODO Auto-generated method stub
			
		}



		public List<Bank_EmployeeDAO> getEmployeeList() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}



		public void updateEmployee(int employeeID) throws SQLException {
			// TODO Auto-generated method stub
			
		}



		public void deleteEmployee(int employeeID) throws SQLException {
			// TODO Auto-generated method stub
			
		}
	}
		

