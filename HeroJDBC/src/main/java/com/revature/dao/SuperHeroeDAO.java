package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.SuperHero;

public interface SuperHeroeDAO {
//CRUD OPERATION
	// CREATE, UPDATE , DELETE
	
	public abstract void createSuperHero(String heroName) throws SQLException;
	
	public abstract List<SuperHero> getSuperHeroList() throws SQLException;
}
