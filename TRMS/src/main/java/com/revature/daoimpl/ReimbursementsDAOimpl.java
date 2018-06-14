package com.revature.daoimpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.revature.beans.Reimbursements;
import com.revature.beans.User;
import com.revature.dao.ReimbursementsDAO;
import com.revature.dao.UserDAO;
import com.revature.util.ConnFactory;

/**
 * Data access object implementation for accessing, editing, and
 * manipulating reimbursement data.
 * @author Marcus Aderele
 *
 */

public class ReimbursementsDAOimpl implements ReimbursementsDAO {

	
	private String[] arr;
	
	public ReimbursementsDAOimpl(String[] arr) {
	
		this.arr = arr;
	
	}
	
	//Connection factory object for connecting to the database
	public static ConnFactory cf = ConnFactory.getInstance();
	
	
	/*
	 * Create and put a new reimbursement/form data in database
	 */
	public void createReimbursement(String location, Timestamp startDate, Timestamp submit, Timestamp finished, double amount, String status,
			String desc, String justification, int cId, int userId, int worker) throws SQLException {
		
		Connection conn = cf.getConnection(arr);
		String sql = 
				"INSERT INTO REIMBURSEMENT VALUES(RIDSEQUENCE.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, location);
			ps.setTimestamp(2, startDate);
			ps.setTimestamp(3, submit);
			ps.setTimestamp(4, finished);
			ps.setDouble(5, amount);
			ps.setString(6, status);
			ps.setString(7, desc);
			ps.setString(8, justification);
			ps.setInt(9, cId);
			ps.setInt(10, userId);
			ps.setInt(11, worker);

			ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}

		conn.close();
		
	}

	/*
	 * Retrieve reimbursement/form details from the database
	 */
	public Reimbursements retrieveReimbursement(int rId) throws SQLException {
		
		Connection conn = cf.getConnection(arr);
		String sql = "SELECT * FROM USERS WHERE RID = '?'";
		
		ResultSet rs = null;
		Reimbursements r = null;
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, rId);
			rs = ps.executeQuery();
			if(rs.next())
			{
				r = new Reimbursements(rs.getInt(1), rs.getString(2), rs.getTimestamp(3), rs.getTimestamp(4),
						rs.getTimestamp(5), rs.getDouble(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11), rs.getInt(12));
				conn.close();
				return r;
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		
		return null;
		
	}
	
	
	//---------------------------UPDATES--------------------------------------------
	/*
	* Update reimbursement info in the database
	*/
	//update Status
	public void updateReimbursementStatus(int rId, String status) throws SQLException {
		Connection conn = cf.getConnection(arr);
		String sql = "UPDATE REIMBURSEMENT SET STATUS = ? WHERE RID = ?";
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, status);
			ps.setInt(2, rId);
			ps.execute();

			conn.close();
		}catch(SQLException e)
		{
			e.printStackTrace();

		}
	}

	//update Amount
	public void updateReimbursementAmount(int rId, Double amt) throws SQLException {
		Connection conn = cf.getConnection(arr);
		String sql = "UPDATE REIMBURSEMENT SET AMOUNT = ? WHERE RID = ?";
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, amt);
			ps.setInt(2, rId);
			ps.execute();

			conn.close();
		}catch(SQLException e)
		{
			e.printStackTrace();

		}

	}

	//update current worker
	public void updateReimbursementWorker(int rId, int worker) throws SQLException {
		Connection conn = cf.getConnection(arr);
		
		String sql = "UPDATE REIMBURSEMENT SET WORKER = ? WHERE RID = ?";
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, worker);
			ps.setInt(2, rId);
			ps.execute();

			conn.close();
		}catch(SQLException e)
		{
			e.printStackTrace();

		}


	}

	//updateFinishTime
	public void updateReimbursementFinishTime(int rId, Timestamp time) throws SQLException {
		Connection conn = cf.getConnection(arr);
		String sql = "UPDATE REIMBURSEMENT SET time = ? WHERE RID = ?";
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setTimestamp(1, time);
			ps.setInt(2, rId);
			ps.execute();

			conn.close();
		}catch(SQLException e)
		{
			e.printStackTrace();

		}


	}

	public void deleteReimbursement(int rId) throws SQLException {
		Connection conn = cf.getConnection(arr);
		String sql = "{call DELETE_REIMBURSEMENT(?)";
		
		try {
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, rId);
			cs.execute();
			conn.close();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
