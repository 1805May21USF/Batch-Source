package com.revature.beans;

public class Powers {
	private int PowersID;
	private String powersName;
	
	protected int getPowersID() {
		return PowersID;
	}

	protected void setPowersID(int powersID) {
		PowersID = powersID;
	}

	protected String getPowersName() {
		return powersName;
	}

	protected void setPowersName(String powersName) {
		this.powersName = powersName;
	}

	protected Powers(int powersID, String powersName) {
		super();
		PowersID = powersID;
		this.powersName = powersName;
	}
	
	protected Powers() {
		super();
	}
	
}
