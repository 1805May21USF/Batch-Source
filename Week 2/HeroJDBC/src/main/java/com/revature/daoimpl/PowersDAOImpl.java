package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.dao.PowersDAO;
import com.revature.util.ConnFactory;

public class PowersDAOImpl implements PowersDAO {
	public static ConnFactory cf= ConnFactory.getInstance();
	
	//PreparedStatement
	public void createPower(String powerName) throws SQLException {
		Connection conn = cf.getConnection();
		String[] primaryKeys = new String[1];
		primaryKeys[0]= "PowersId";
		String sql =  "INSERT INTO POWERS VALUES(POWSEQ.NEXTVAL,?)";
		try {
		PreparedStatement ps= conn.prepareStatement(sql, primaryKeys);
		ps.setString(1, powerName);
		ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

}
