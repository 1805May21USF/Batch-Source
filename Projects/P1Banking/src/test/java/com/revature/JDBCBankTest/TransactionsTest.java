package com.revature.JDBCBankTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.revature.beans.BankAccount;
import com.revature.beans.User;
import com.revature.implementdao.ImpBankAccountDAO;
import com.revature.implementdao.ImpTransactionsDAO;
import com.revature.implementdao.ImpUserDAO;
import com.revature.util.ConnFactory;

class TransactionsTest {
	private static String firstname = "Tran";
	private static String lastname = "Saction";
	private static String username = "transaction1";
	private static String password = "1";
	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Test
	void testAddTransaction() throws SQLException {
		ImpUserDAO iud = new ImpUserDAO();
		ImpTransactionsDAO itd = new ImpTransactionsDAO();
		iud.insertUser(firstname, lastname, username, password);
		User u = iud.getUserByCredentials(username, password);
		ImpBankAccountDAO ibad = new ImpBankAccountDAO();
		ibad.createBankAccount(u.getId());
		List<BankAccount> accts = ibad.getUserBankAccounts(u.getId());
		BankAccount acct = accts.get(0);
		int oldsize = itd.getAllTransactions().size();
		Connection conn = cf.getConnection();
		
		String sql = "{call ADDTRANSACTION(?,?,?,?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, "Deposited");
		call.setFloat(2, 500.00f);
		call.setInt(3, acct.getUserid());
		call.setInt(4, acct.getAccountid());
		call.execute();
		
		int newsize = itd.getAllTransactions().size();
		ibad.deleteBankAccount(acct.getAccountid());
		iud.deleteUser(username);
		conn.close();
		assertTrue(newsize>oldsize);
	}

}
