package com.revature.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Superhero;
import com.revature.dao.SuperheroDAO;
import com.revature.util.ConnFactory;

public class SuperheroDAOimpl implements SuperheroDAO {
public static ConnFactory cf =ConnFactory.getInstance();
	@Override
	public void createSuperhero(String heroName) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{call INSERTSUPERHERO(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, heroName);
		call.execute();
	}

	@Override
	public List<Superhero> getSuperHeroList() throws SQLException {
		List<Superhero> superHeroList = new ArrayList<>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM SUPERHERO");
		Superhero s = null;
		while(rs.next()) {
			s = new Superhero(rs.getInt(1),rs.getString(2));
			superHeroList.add(s);
			
		}
		return superHeroList;
	}

}
