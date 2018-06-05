package com.revature.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.beans.Client;
import com.revature.dao.ClientDao;
import com.revature.util.ConnFactory;

public class ClientDaoImp implements ClientDao {
	
	public static ConnFactory cf = ConnFactory.getInstance();

	public void createClient(Client client) throws SQLException {
		
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "ClientID";
		
		String sql = "INSERT INTO CLIENT VALUES(CLIENTIDSEQ.NEXTVAL, ?)";
		
		PreparedStatement ps = conn.prepareStatement(sql, primaryKeys);
		ps.setInt(1, client.getUserID());
		ps.executeUpdate();
		
		
	}

	public void deleteClient(int clientID) throws SQLException {
		
		
	}

	public Client getClientByID(int clientID) throws SQLException {
		
		return null;
	}
	

}
