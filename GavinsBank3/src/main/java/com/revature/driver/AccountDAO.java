package com.revature.driver;
import java.sql.SQLException;
import java.util.List;


public abstract interface AccountDAO {
	//CRUD
	
	public abstract void createAccount(String name, String type) throws SQLException;
	public abstract List<Integer> getAccountList(String user) throws SQLException;
	public abstract void deleteAccount(int id) throws SQLException;

	

}


/*
 * 
 * public abstract interface SuperHeroDAO {

		//CRUD Create read update deleter Operations
			
			public abstract void createSuperHero(String heroName) throws SQLException;
			
			public abstract List<SuperHero> getSuperHeroList() throws SQLException;
			
		}
 * 
 */
