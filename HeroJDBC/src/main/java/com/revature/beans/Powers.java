package com.revature.beans;

public class Powers
{
	private int powerID;
	private String powersName;
	public int getPowerID()
	{
		return powerID;
	}
	public void setPowerID(int powerID)
	{
		this.powerID = powerID;
	}
	public String getPowersName()
	{
		return powersName;
	}
	public void setPowersName(String powersName)
	{
		this.powersName = powersName;
	}
	@Override
	public String toString()
	{
		return "Powers [powerID=" + powerID + ", powersName=" + powersName
				+ "]";
	}	
}
