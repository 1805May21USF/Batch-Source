package com.revature.daoimpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
	public void createReimbursement(String location,double amount, Timestamp startDate,
			String desc, String justification, int cId, int userId, int worker) throws SQLException {

		Connection conn = cf.getConnection(arr);

		String sql = "{call CREATE_REIMBURSEMENT(?,?,?,?,?,?,?,?,?)";

		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, location);
		call.setDouble(2, amount);
		call.setTimestamp(3, startDate);
		call.setString(4, "Pending");
		call.setString(5, desc);
		call.setString(6, justification);
		call.setInt(7, cId);
		call.setInt(8, userId);
		call.setInt(9, worker);
		call.execute();
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


	//retrieve coverage id
	@Override
	public int retrieveCoverageId(String type) throws SQLException {
		System.out.println("in retrieve cid");
		Connection conn = cf.getConnection(arr);
		String sql = "SELECT CID FROM COVERAGES WHERE CTYPE = ?";
		int cId = 0;
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, type);
			ResultSet rs = ps.executeQuery();

			while(rs.next() == true)
			{
				cId = rs.getInt(1);
			}

			conn.close();
			return cId;



		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return 0;

	}


	//retrieve user id
	@Override
	public int retrieveUserId(String email) throws SQLException {

		Connection conn = cf.getConnection(arr);
		String sql = "SELECT USERID FROM USERS WHERE EMAIL = ?";
		int uId = 0;
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			while(rs.next())
			{
				uId = rs.getInt(1);
			}
			conn.close();

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return uId;
	}


	//retrieve superuserID from title ID
	@Override
	public int retrieveSuperUserId(int titleId) throws SQLException {

		Connection conn = cf.getConnection(arr);
		String sql = "SELECT USERID FROM USERS WHERE TID = ?";
		int sUId = 0;
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, titleId);
			ResultSet rs = ps.executeQuery();

			while(rs.next())
			{
				sUId = rs.getInt(1);
			}
			conn.close();

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return sUId;
	}
	
	public String retrieveUserEmail(int uid) throws SQLException {

		Connection conn = cf.getConnection(arr);
		String sql = "SELECT EMAIL FROM USERS WHERE USERID = ?";
		String email = "";
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();


			while(rs.next())
			{
				email = rs.getString(1);
			}
			conn.close();

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return email;
	}


	public List<Reimbursements> retrieveUserReimbursements(int userId) throws SQLException {
		List<Reimbursements> rList = new ArrayList<Reimbursements>();

		Connection conn = cf.getConnection(arr);
		String sql = "SELECT * FROM REIMBURSEMENT WHERE USERID = ?";
		ResultSet rs = null;

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Reimbursements r = null;

		while (rs.next()) {
			r = new Reimbursements(rs.getInt(1),rs.getString(2),
					rs.getTimestamp(3),rs.getTimestamp(4),
					rs.getTimestamp(5),rs.getDouble(6),
					rs.getString(7),rs.getString(8),
					rs.getString(9),rs.getShort(10),
					rs.getInt(11),rs.getInt(12));
			rList.add(r);
		}

		if (rList.isEmpty()) {
			return null;
		}

		return rList;
	}


	public List<Reimbursements> retrieveAllReimbursements() throws SQLException {
		List<Reimbursements> rList = new ArrayList<Reimbursements>();

		Connection conn = cf.getConnection(arr);
		String sql = "SELECT * FROM REIMBURSEMENT";
		ResultSet rs = null;

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Reimbursements r = null;

		while (rs.next()) {
			r = new Reimbursements(rs.getInt(1),rs.getString(2),
					rs.getTimestamp(3),rs.getTimestamp(4),
					rs.getTimestamp(5),rs.getDouble(6),
					rs.getString(7),rs.getString(8),
					rs.getString(9),rs.getShort(10),
					rs.getInt(11),rs.getInt(12));
			rList.add(r);
		}

		if (rList.isEmpty()) {
			return null;
		}

		return rList;
	}



	public List<Reimbursements> retrieveWorkerReimbursements(int workerID) throws SQLException {
		List<Reimbursements> rList = new ArrayList<Reimbursements>();

		Connection conn = cf.getConnection(arr);
		String sql = "SELECT * FROM REIMBURSEMENT WHERE WORKER = ?";
		ResultSet rs = null;

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, workerID);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Reimbursements r = null;

		while (rs.next()) {
			r = new Reimbursements(rs.getInt(1),rs.getString(2),
					rs.getTimestamp(3),rs.getTimestamp(4),
					rs.getTimestamp(5),rs.getDouble(6),
					rs.getString(7),rs.getString(8),
					rs.getString(9),rs.getShort(10),
					rs.getInt(11),rs.getInt(12));
			rList.add(r);
		}

		if (rList.isEmpty()) {
			return null;
		}

		return rList;
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

	public String getCoverageType(int cid) throws SQLException {
		String sql = "SELECT CTYPE FROM COVERAGES WHERE CID = ?";
		Connection conn = cf.getConnection(arr);
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, cid);
		ResultSet r = ps.executeQuery();
		if(r.next()) {
			return r.getString(1);
		}

		return "";
	}

}