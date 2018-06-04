package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.dao.PowersDAO;
import com.revature.util.ConnFactory;

public class PowerDAOImple implements PowersDAO {
	public static ConnFactory cf = ConnFactory.getInstance();

	//Prepared statements
	public void createPower(String powerName) throws SQLException {
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0] = "PowersID";
		String sql = "INSERT INTO POWERS VALUES(POWSEQ.NEXTVAL,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql,primaryKeys);
			ps.setString(1, powerName); //first ?
			ps.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

}
