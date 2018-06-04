package com.revature.dao;

import java.sql.SQLException;

import com.revature.beans.Client;

public interface ClientDao {
	
	public abstract void createClient(Client client) throws SQLException;
	public abstract void deleteClient(int clientID) throws SQLException;
	public abstract Client getClientByID(int clientID) throws SQLException;

}
