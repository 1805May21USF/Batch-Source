package revature.com.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.dao.PowersDAO;
import com.revature.util.ConnFactory;

public class PowersDAOImpl implements PowersDAO {

	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void createPower(String powerName) throws SQLException {
		// TODO Auto-generated method stub
		//Prepared statements much safer from sequal injection
		Connection conn = cf.getConnection();
		String[] primarykeys = new String[1];
		primarykeys[0] = "PowersId";
		String sql = "INSERT INTO POWERS VALUES (POWSEQ.NETVAL,?";
		PreparedStatement ps =conn.prepareStatement(sql, primarykeys);
		Statement stmt = conn.createStatement();
		ps.setString(1, powerName);
		ps.executeUpdate();		
	}

}
