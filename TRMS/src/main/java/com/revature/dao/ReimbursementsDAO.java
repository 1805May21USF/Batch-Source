package com.revature.dao;

import java.sql.SQLException;
import java.sql.Timestamp;

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
	public abstract void createReimbursement(String location, Timestamp startDate, Timestamp submit, Timestamp finished, double amount, String status,
			String desc, String justification, int cId, int userId, int worker) throws SQLException;
	
	
	/*
	 * Retrieve reimbursement/form details from the database
	 */
	public abstract Reimbursements retrieveReimbursement(int rId)throws SQLException;;
	
	
	
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
	public abstract void deleteReimbursement(int rId)throws SQLException;;
	
	

	

}
