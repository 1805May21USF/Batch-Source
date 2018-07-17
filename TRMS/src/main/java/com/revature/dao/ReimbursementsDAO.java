package com.revature.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.revature.beans.Reimbursements;

/**
 * Data access object for employee/user accounts.
 * @author Marcus Aderele
 *
 */

public interface ReimbursementsDAO {
	
	/*
	 * Create and put a new reimbursement/form data in database
	 */
	public abstract void createReimbursement(String location, double amount, Timestamp startDate, String desc,
            String justification, int cId, int userId, int worker) throws SQLException;	
	
	/*
	 * Retrieve reimbursement/form details from the database
	 */
	public abstract Reimbursements retrieveReimbursement(int rId)throws SQLException;
	
	//retrieve coverage id
	public abstract int retrieveCoverageId(String type) throws SQLException;
	
	//retrieve User id
	public abstract int retrieveUserId(String email) throws SQLException;
	
	//retrieve superUser id
	public abstract int retrieveSuperUserId(int titleId) throws SQLException;
	
	public abstract List<Reimbursements> retrieveUserReimbursements(int userId) throws SQLException;
	
	public abstract List<Reimbursements> retrieveAllReimbursements() throws SQLException;
	
	
	//---------------------------UPDATES--------------------------------------------
	/*
	 * Update reimbursement info in the database
	 */
	//update status
	public abstract void updateReimbursementStatus(int rId, String status)throws SQLException;
	
	//update Amount
	public abstract void updateReimbursementAmount(int rId, Double amt)throws SQLException;
	
	//update Worker
	public abstract void updateReimbursementWorker(int rId, int title)throws SQLException;
	
	//updateFinishTome
	public abstract void updateReimbursementFinishTime(int rId, Timestamp time)throws SQLException;	
	
	/*
	 * Delete reimbursement/form details in the database
	 */
	public abstract void deleteReimbursement(int rId)throws SQLException;
	
	public abstract String getCoverageType(int cid) throws SQLException;

	

}