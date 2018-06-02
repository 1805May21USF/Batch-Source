package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Superhero;

public interface SuperheroDAO {
	//CRUD operations
	public abstract void createSuperhero(String heroName) throws SQLException;
	public abstract List<Superhero> getSuperHeroList() throws SQLException;
}
