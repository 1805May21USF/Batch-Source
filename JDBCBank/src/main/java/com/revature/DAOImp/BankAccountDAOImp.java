package com.revature.DAOImp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.revature.banking_app.BankAccount;
import com.revature.banking_app.BankAccount.AccountStatus;
import com.revature.banking_app.BankAccount.AccountType;
import com.revature.banking_app.BankAccount.JointOwner;
import com.revature.dao.BankAccountDAO;
import com.revature.util.ConnFactory;

public class BankAccountDAOImp implements BankAccountDAO {
	
	public static ConnFactory cf = ConnFactory.getInstance();
		
	@Override
	public void createBankAccount(BankAccount bankAccount) throws SQLException 
	{
		
		Connection conn = cf.getConnection();
		
		String sql = "{call INSERTBANKACCOUNT(?,?,?,?,?,?,?,?,?)}";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, Integer.toString(bankAccount.getAccountNumber()));
		call.setString(2, "0");
		call.setString(3, bankAccount.getFirstOwnerLogin());
		call.setString(4, bankAccount.getSecondOwnersLogin());
		call.setString(5, bankAccount.getFirstOwnersFullName());
		call.setString(6, bankAccount.getSecondOwnersFullName());
		call.setString(7, bankAccount.singleOrJoint.name());
		call.setString(8, bankAccount.status.name());
		call.setString(9, bankAccount.pendingAcceptance.name());
		call.execute();
		updateBalance(bankAccount);

	}
	
	

	@Override
	public ArrayList<BankAccount> getBankAccounts() throws SQLException 
	{
		
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ArrayList<BankAccount> bankAccounts = new ArrayList<>();
		ResultSet rs = stmt.executeQuery("SELECT * FROM BANKACCOUNT");
		BankAccount account = null;
		while(rs.next())
		{
			account = new BankAccount(rs.getInt(1),rs.getDouble(2), rs.getString(3), rs.getString(5), AccountType.valueOf(rs.getString(7)), AccountStatus.valueOf(rs.getString(8)), JointOwner.valueOf(rs.getString(9)));
			if(rs.getString(4)==null && rs.getString(6)==null)
			{}
			else
			{
				account.addJointOwner(rs.getString(4), rs.getString(6));
			}
			bankAccounts.add(account);
		}
		
		
		return bankAccounts;
	}



	@Override
	public void updateBankAccount(BankAccount bankAccount) throws SQLException 
	{
		
		Connection conn = cf.getConnection();
		String sql = "{call UPDATEBANKACCOUNT(?,?,?,?,?,?,?,?)}";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, Integer.toString(bankAccount.getAccountNumber()));
		call.setString(2, bankAccount.getFirstOwnerLogin());
		call.setString(3, bankAccount.getSecondOwnersLogin());
		call.setString(4, bankAccount.getFirstOwnersFullName());
		call.setString(5, bankAccount.getSecondOwnersFullName());
		call.setString(6, bankAccount.singleOrJoint.name());
		call.setString(7, bankAccount.status.name());
		call.setString(8, bankAccount.pendingAcceptance.name());
		call.execute();
		updateBalance(bankAccount);
	}



	@Override
	public void updateBalance(BankAccount bankAccount) throws SQLException 
	{
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		
		String sql = "UPDATE BANKACCOUNT " + "SET BALANCE = " + bankAccount.getBalance() +" where ACCOUNTNUMBER=" + bankAccount.getAccountNumber();
		stmt.executeQuery(sql);
		
	}



	@Override
	public void deleteBankAccount(BankAccount bankAccount) throws SQLException 
	{
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "DELETE FROM BANKACCOUNT WHERE ACCOUNTNUMBER=" + bankAccount.getAccountNumber();
		stmt.executeQuery(sql);
		
	}



	@Override
	public ArrayList<BankAccount> getBankAccountsOwnedByUser(String userLoginName) throws SQLException 
	{
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ArrayList<BankAccount> bankAccounts = new ArrayList<>();
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM BANKACCOUNT");
		BankAccount account = null;
		while(rs.next())
		{
			account = new BankAccount(rs.getInt(1),rs.getDouble(2), rs.getString(3), rs.getString(5), AccountType.valueOf(rs.getString(7)), AccountStatus.valueOf(rs.getString(8)), JointOwner.valueOf(rs.getString(9)));
			if(rs.getString(4)==null && rs.getString(6)==null)
			{}
			else
			{
				account.addJointOwner(rs.getString(4), rs.getString(6));
			}
			if(account.isAnOwner(userLoginName))
			{
				bankAccounts.add(account);
			}
		}
		
		
		return bankAccounts;
		
	}

}
