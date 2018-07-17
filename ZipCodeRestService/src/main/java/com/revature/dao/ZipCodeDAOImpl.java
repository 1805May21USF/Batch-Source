package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.domain.ZipCodes;

public class ZipCodeDAOImpl {
	
	public static List<ZipCodes> zipList = new ArrayList<ZipCodes>();
	
	static {
		zipList.add(new ZipCodes(33579, "Riverview", "Florida"));
		zipList.add(new ZipCodes(92277, "Twentynine Palms", "California"));
		zipList.add(new ZipCodes(35670, "Somerville", "Alabama"));
	}
	
	public static List<ZipCodes> getAllZipCodes() {
		return zipList;
	}
	
	public static ZipCodes getInfoByZip(int zipCode) {
		for(ZipCodes z : zipList) {
			if (z.getZipCode() == zipCode) {
				return z;
			}
		}
		
		return null;
	}
	
	public static void addZipCode(ZipCodes z) {
		zipList.add(z);
	}
	
	public static void removeZipCode(int zipCode) {
		for (int i = 0; i < zipList.size(); i++) {
			if (zipList.get(i).getZipCode() == zipCode) {
				zipList.remove(i);
			}
		}
	}

}