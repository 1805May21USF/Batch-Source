package com.revature.driver;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.*;
import com.revature.daoimpl.ClientDAOimpl;

public class Driver {

	static List<Client> clients = new ArrayList<Client>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Menus menu = new Menus();
		menu.mainMenu();
	}
	
}
