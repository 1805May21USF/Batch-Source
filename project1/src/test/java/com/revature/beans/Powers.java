package com.revature.beans;

public class Powers {
private int powerID;
private String powerName;



@Override
public String toString() {
	return "Powers [powerID=" + powerID + ", powerName=" + powerName + "]";
}
public Powers(int powerID, String powerName) {
	super();
	this.powerID = powerID;
	this.powerName = powerName;
}
public int getPowerID() {
	return powerID;
}
public void setPowerID(int powerID) {
	this.powerID = powerID;
}
public String getPowerName() {
	return powerName;
}
public void setPowerName(String powerName) {
	this.powerName = powerName;
}

}
