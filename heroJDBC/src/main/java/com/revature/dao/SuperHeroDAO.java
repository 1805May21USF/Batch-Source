/**
 * 
 */
package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.SuperHero;

/**
 * @author kmart
 *
 */
public interface SuperHeroDAO {

	//CRUD Operations
	public abstract void createSuperHero(String heroName) throws SQLException;
	public abstract List<SuperHero> getHeroList() throws SQLException;
	
}
