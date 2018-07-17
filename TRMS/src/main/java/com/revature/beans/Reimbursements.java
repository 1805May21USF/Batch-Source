package com.revature.beans;

import java.sql.Timestamp;

public class Reimbursements {
	
	private int rId;
	private String location;
	private Timestamp startDate;
	private Timestamp submit;
	private Timestamp finished;
	private double amount;
	private String status;
	private String desc;
	private String justification;
	private int cId;
	private int userId;
	private int worker;
	
	public Reimbursements() {
		super();
	}

	

	public Reimbursements(int rId, String location, Timestamp startDate, Timestamp submit, Timestamp finished,
			double amount, String status, String desc, String justification, int cId, int userId, int worker) {
		super();
		this.rId = rId;
		this.location = location;
		this.startDate = startDate;
		this.submit = submit;
		this.finished = finished;
		this.amount = amount;
		this.status = status;
		this.desc = desc;
		this.justification = justification;
		this.cId = cId;
		this.userId = userId;
		this.worker = worker;
	}



	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public Timestamp getFinished() {
		return finished;
	}

	public void setFinished(Timestamp finished) {
		this.finished = finished;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getWorker() {
		return worker;
	}

	public void setWorker(int worker) {
		this.worker = worker;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getSubmit() {
		return submit;
	}

	public void setSubmit(Timestamp submit) {
		this.submit = submit;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	@Override
	public String toString() {
		return "Reimbursements [rId=" + rId + ", location=" + location + ", startDate=" + startDate + ", submit="
				+ submit + ", finished=" + finished + ", amount=" + amount + ", status=" + status + ", desc=" + desc
				+ ", justification=" + justification + ", cId=" + cId + ", userId=" + userId + ", worker=" + worker
				+ "]";
	}

}
