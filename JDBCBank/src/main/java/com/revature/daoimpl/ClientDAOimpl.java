package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Menus;
import com.revature.beans.Account;
import com.revature.beans.Client;
import com.revature.dao.ClientDAO;
import com.revature.util.ConnFactory;

public class ClientDAOimpl implements ClientDAO {
	
	
	public static ConnFactory cf = ConnFactory.getInstance();
	//check the client name is in the database
	public List<Client> getClients()throws SQLException{
		
		
		List<Client> clientList = new ArrayList<Client>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs =stmt.executeQuery("SELECT * FROM CLIENT");
		Client c = null;
			while(rs.next()) {
			c = new Client(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				clientList.add(c);
			}
			conn.close();
		
		return clientList;
	}
	
	
	
	public boolean newClient(String user,String password,String fname,String lname)throws SQLException {
		Menus m = new Menus();
		boolean clientCreated = false;
		Connection conn = cf.getConnection();
		String sql = "{call CREATECLIENT(?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		
		call.setString(1, user);
		call.setString(2, password);
		call.setString(3, fname);
		call.setString(4, lname);
		call.execute();
		conn.close();
		
		
		clientCreated = true;
		
		//return that a new client has been created
		return clientCreated;
		
	}
	
	public void addAccountsFromDB(Client client) {
		
		try {
		List<Account> accountList = getAccounts(client);
		for(Account acc : accountList) {
			client.getAccountList().add(acc);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
public List<Account> getAccounts(Client client)throws SQLException{
		
		
		List<Account> accountList = new ArrayList<Account>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ACCOUNT WHERE CLIENTID = " + client.getClientID());
		Account a = null;
			while(rs.next()) {
			a = new Account(rs.getInt(1),rs.getInt(2),rs.getDouble(3));
				accountList.add(a);
			}
			conn.close();
		
		return accountList;
	}
	
}
