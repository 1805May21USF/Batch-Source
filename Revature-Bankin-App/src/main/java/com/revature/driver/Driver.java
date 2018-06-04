package com.revature.driver;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.*;
import com.revature.daoimpl.ClientDAOimpl;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Driver {

	static List<Client> clients = new ArrayList<Client>();
	final static Logger logger = Logger.getLogger(Driver.class);
	
	public static void main(String[] args) {
		BasicConfigurator.configure();
		// TODO Auto-generated method stub
		Menus menu = new Menus();
		menu.mainMenu();
		
	}
	
}
