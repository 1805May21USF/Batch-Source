package revature.com.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.SuperHero;
import com.revature.dao.SuperHeroDAO;
import com.revature.util.ConnFactory;

public class SuperHeroDAOImpl implements SuperHeroDAO{

	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void createSuperHero(String heroName) throws SQLException {
		// TODO Auto-generated method stub
		// These are called CallableStatement
		Connection conn = cf.getConnection();
		String sql = "{call INSERTSUPERHERO(?)";
		
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1,  heroName);
		call.execute();
	}

	public List<SuperHero> getSuperHeroList()throws SQLException {
		// TODO Auto-generated method stub 
		List<SuperHero> superHeroList = new ArrayList<SuperHero>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("Select * From SuperHero");
		SuperHero s = null;
		
		while(rs.next()) {
			s = new SuperHero(rs.getInt(1), rs.getString(2));
			superHeroList.add(s);
		}
		
		return superHeroList;
	}

	@Override
	public String toString() {
		try {
			return "SuperHeroDAOImpl [getSuperHeroList()=" + getSuperHeroList() + "]";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
