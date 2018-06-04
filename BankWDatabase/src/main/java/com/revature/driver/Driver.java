package com.revature.driver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.revature.beans.B_Account;
import com.revature.beans.B_User;
import com.revature.daoimpl.B_AccountDAOImpl;
import com.revature.daoimpl.B_UserDAOImpl;
import com.revature.util.ConnFactory;



public class Driver {

	public static ConnFactory cf = ConnFactory.getInstance();
	static B_AccountDAOImpl badi = new B_AccountDAOImpl();
	static B_UserDAOImpl budi = new B_UserDAOImpl();
	
	public static void main(String[] args) {

		
/*		try {
			badi.createBankAccount(14.0f, 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	
		while(true) {
		
			boolean done = false;
			boolean loggedin = false;
			
			B_User current = new B_User();
			
			Scanner sc = new Scanner(System.in);
			while(!loggedin) {
				
				System.out.println("Welcome to the bank? Log in or sign up?");
				String s = sc.nextLine();
			
				if(s.toLowerCase().equals("log in")) {
					current = login();
					//System.out.println(current);
					if (current != null) {
						loggedin = true;
						System.out.println("Welcome " + current.getFirstName() + "!");
					}
					else {
						System.out.println("Incorrect log in info, please try again!");
					}
				}
				else if (s.toLowerCase().equals("register")) {
					register();
					System.out.println("Thank you for registering! Please try to log in once your account is approved.");
				}
				else if (s.toLowerCase().equals("secret admin login ;)")) {
					current = aLogin();
					loggedin = true;
					System.out.println("Welcome Admin!");
				}
				else {
					System.out.println("Wrong input, try again!");
				}
			}
	
			//current = null;
			
			while(!done) {
				
				if (current != null) {
					int response;
					if (current.isAdmin()) 
					{
						System.out.println("What ACTION would you like to perform?\n"
								+ "1) View All Users\n" + "2) User Approvals\n" 
								+ "3) Create New User\n" + "4) Update User Info\n" 
								+ "5) Delete a User\n" + "6) Log out");
						if (sc.hasNextInt()) {
							//String next = sc.next();
							int response1 = sc.nextInt();

						
						
						switch(response1) 
						{
						case 1:
							try {
								System.out.println(budi.getUserList());
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						
						case 2:
							approveAccounts();
							System.out.println("Accounts approved!");
							break;
						
						case 3:
							adCreate();
							System.out.println("User created!");
							break;
						
						case 4:
							System.out.println("Which user would you like to update?(ID)");
							int next = sc.nextInt();
							
							adUpdate(next);
							System.out.println("User updated!");
							break;
						
						case 5:
							System.out.println("Which user would you like to delete?(ID)");
							int nextd = sc.nextInt();
							
							adDelete(nextd);
							System.out.println("User deleted!");
							break;
						
						case 6:
							System.out.println("Bye!");
							logout(current);
							done = true;
							break;
						
						default:
							System.out.println("Wrong input. Please try again!");
							break;
						}
						} else {
							try {
								throw new PassNumException("Incorrect input value. Please enter a number, not a string. Returning to Log in");
							} catch (PassNumException e) {
								// TODO Auto-generated catch block
								logout(current);
								System.out.println(e);
							}
							break;
						}
	
					} 
					else if (!current.isAdmin())
					{
						System.out.println("What ACTION would you like to perform?\n"  
								+ "1) View my Acccounts\n" + "2) Open new Bank Account\n"
								+ "3) Delete Account\n" + "4) Make a Deposit\n"
								+ "5) Make a Withdrawal\n" + "6) Log out" );
						
						if (sc.hasNextInt()) {
							//String next = sc.next();
							int response1 = sc.nextInt();
							switch(response1) 
							{
							case 1:
								try {
									List<B_Account> temp = badi.getMyAccountList(current.getUserID());
									System.out.println(temp);
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								break;
							
							case 2:
								usCreate(current);
								System.out.println("User created!");					
								break;
							
							case 3:
								usDeleteAcct(current);
								break;
							
							case 4:
								deposit(current);
								break;
							
							case 5:
								withdraw(current);
								break;
							
							case 6:
								logout(current);
								done = true;
								break;
								
							default:
								System.out.println("Wrong input. Please try again!");
								break;
							}
						} else {
							logout(current);
							try {
								throw new PassNumException("Incorrect input value. Please enter a number, not a string. Returning to Log in");
							} catch (PassNumException e) {
								// TODO Auto-generated catch block
								System.out.println(e);
							break;
						}
						
						
					}
						
				}
				
			}
			//		System.out.println("Out of loop");
	
			/*try {
				//badi.createBankAccount(12.44f);			
				//System.out.println(badi.getBankAccountList());
				
				//budi.createUser("Test", "Test", "Test", "Test");
				List<B_User> stupidName = budi.getUserList();
				System.out.println(stupidName);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}*/
			}		
		}
	}

	public static B_User login() {
/*		B_AccountDAOImpl badi = new B_AccountDAOImpl();
		B_UserDAOImpl budi = new B_UserDAOImpl();*/
		
		Scanner sc = new Scanner(System.in);
		
		B_User temp = new B_User();
		
		temp = null;
		
		System.out.println("username?");
		String username = sc.nextLine();
		
		try {
			for (B_User i : budi.getUserList()) 
			{				
				if (username.equals(i.getUsername()))
				{
					temp = i;		
				
					System.out.println("password?");
					String pass = sc.nextLine();
					
					//System.out.println(i.getPassword());
					//System.out.println(pass);
					if(i.getPassword().equals(pass)) 
					{
						if (i.getPriv().equals("Y")){
							//TODO create login function here. Should be like an update function for the db
							Connection conn = cf.getConnection();
							String sql = "{call LOGIN(?)";
						
							//System.out.println(i.getUserID());
							int j = i.getUserID();
							CallableStatement call = conn.prepareCall(sql);
						
							call.setInt(1, j);
							call.execute();
							conn.close();
						}
						else {
							temp = null;
						}
						//else System.out.println("");
					}
					else {
						temp = null;
					}
					
				}
				
			} 

				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
		
	}
	
	private static B_User aLogin() {
		/*		B_AccountDAOImpl badi = new B_AccountDAOImpl();
				B_UserDAOImpl budi = new B_UserDAOImpl();*/
				Properties prop = new Properties();
				try {
					prop.load(new FileReader("database.properties"));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				Scanner sc = new Scanner(System.in);
				
				B_User temp = new B_User();
				
				temp = null;
				
//				System.out.println("username?");
     			String username = prop.getProperty("admin");
				
				try {
					for (B_User i : budi.getUserList()) 
					{				
						if (username.equals(i.getUsername()))
						{
							temp = i;		
						
							//System.out.println("password?");
							String pass = prop.getProperty("pass");
						
							if(i.getPassword().equals(pass)) 
							{
								if (i.getPriv().equals("Y")){
									//TODO create login function here. Should be like an update function for the db
									Connection conn = cf.getConnection();
									String sql = "{call LOGIN(?)";
								
									//System.out.println(i.getUserID());
									int j = i.getUserID();
									CallableStatement call = conn.prepareCall(sql);
								
									call.setInt(1, j);
									call.execute();
									
									conn.close();
								}
								//else System.out.println("");
							}
							
						}
						
					} 

						
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return temp;
	}
	
	public static void logout(B_User b) {
		try {
			Connection conn = cf.getConnection();
			String sql = "{call LOGOUT(?)";
		
			//System.out.println(i.getUserID());
			CallableStatement call = conn.prepareCall(sql);
			
			int j = b.getUserID();
		
			call.setInt(1, j);
	
			call.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void register() {
		
		// may need to add a check if someone is already in there
//		B_AccountDAOImpl badi = new B_AccountDAOImpl();
//		B_UserDAOImpl budi = new B_UserDAOImpl();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Username?");
		String username = sc.nextLine();
		
		System.out.println("Password?");
		String pass = sc.nextLine();
		//TODO Maybe do a password matching confirmation
		
		System.out.println("Name?(First and Last)");
		String[] name = sc.nextLine().split(" ");
		
		try {
			budi.createUser(name[0], name[1], username, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//----------ACTIONS---------
	
	//TODO admin approve
	public static void approveAccounts() {
/*		B_AccountDAOImpl badi = new B_AccountDAOImpl();
		B_UserDAOImpl budi = new B_UserDAOImpl();*/
		Scanner sc = new Scanner(System.in);
		
		List<B_User> unapproved = new ArrayList<B_User>();
		
		try {
			unapproved = budi.getUnapprovedUserList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(unapproved);

		System.out.println("Accounts you would like to approve? (Enter IDs separated by commas OR type quit to exit)");
		String[] a = sc.nextLine().split(", ");
		
		if (a[0].equals("quit"))
		{
			return;
		} 
		else
		{
			
			List<Integer> list = new ArrayList<Integer>();
			
			for (int i =0; i < a.length; i++) {
				int temp = Integer.parseInt(a[i]);
				list.add(temp);
			}
			
			try {
				for (B_User c : unapproved) {
					
					if(list.contains(c.getUserID())) {
						
						Connection conn = cf.getConnection();
						String sql = "{call SETAPPROVE(?)";
					
						//System.out.println(i.getUserID());
						CallableStatement call = conn.prepareCall(sql);
						
						int j = c.getUserID();
					
						call.setInt(1, j);
				
						call.execute();
						conn.close();
					}
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//TODO admin view (MAYBE)

	public static void adCreate() {
		register();
	}
	
	public static void adUpdate(int n) {
	/*	B_AccountDAOImpl badi = new B_AccountDAOImpl();
		B_UserDAOImpl budi = new B_UserDAOImpl();
		*/
		Scanner sc = new Scanner(System.in);
		
		B_User thiscurrent = new B_User();
		
		List<B_User> getUser = new ArrayList<B_User>();
		
		try {
			getUser = budi.getUserList();
			for (B_User b : getUser) {
				if (n == b.getUserID()) {
					thiscurrent = b;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("What would you like to edit?(firstname, lastname, username, password, admin)");
		String result = sc.nextLine();
		Connection conn = cf.getConnection();
		if (result.equals("firstname")) 
		{
			System.out.println("What are you changing the first name to?");
			
			String newname = sc.nextLine();

			try {

				String sql = "{call UPDATEFNAME(?, ?)";
			
				//System.out.println(i.getUserID());
				CallableStatement call = conn.prepareCall(sql);
				
				int j = thiscurrent.getUserID();
			
				call.setInt(1, j);
				call.setString(2, newname);
		
				call.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if (result.equals("lastname"))
		{
			System.out.println("What are you changing the last name to?");
			
			String newname = sc.nextLine();
			
			try {

				String sql = "{call UPDATELNAME(?, ?)";
			
				//System.out.println(i.getUserID());
				CallableStatement call = conn.prepareCall(sql);
				
				int j = thiscurrent.getUserID();
			
				call.setInt(1, j);
				call.setString(2, newname);
				
				call.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if (result.equals("username"))
		{
			System.out.println("What are you changing the username to?");
			
			String newname = sc.nextLine();
			
			try {

				String sql = "{call UPDATEUNAME(?, ?)";
			
				//System.out.println(i.getUserID());
				CallableStatement call = conn.prepareCall(sql);
				
				int j = thiscurrent.getUserID();
			
				call.setInt(1, j);
				call.setString(2, newname);
				
				call.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if (result.equals("password"))
		{
			System.out.println("What are you changing the password to?");
			
			String newname = sc.nextLine();
			
			try {

				String sql = "{call UPDATEPASS(?, ?)";
			
				//System.out.println(i.getUserID());
				CallableStatement call = conn.prepareCall(sql);
				
				int j = thiscurrent.getUserID();
			
				call.setInt(1, j);
				call.setString(2, newname);
				
				call.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if (result.equals("admin"))
		{
			System.out.println("What are you changing the admin priviledges too?");
			
			int newname = Integer.parseInt(sc.nextLine());
			
			try {

				String sql = "{call UPDATEADMIN(?, ?)";
			
				//System.out.println(i.getUserID());
				CallableStatement call = conn.prepareCall(sql);
				
				int j = thiscurrent.getUserID();
			
				call.setInt(1, j);
				call.setInt(2, newname);
				
				call.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//TODO admin delete
	public static void adDelete(int n)
	{
		try {
			Connection conn = cf.getConnection();
			String sql = "{call DELETEENTRY(?)";
		
			//System.out.println(i.getUserID());
			CallableStatement call = conn.prepareCall(sql);
			
		
			call.setInt(1, n);
			
			call.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//TODO user create
	public static void usCreate(B_User b) {
/*		B_AccountDAOImpl badi = new B_AccountDAOImpl();
		B_UserDAOImpl budi = new B_UserDAOImpl();*/
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Initial balance?");
		
		float s = sc.nextFloat();
		
		try {
			badi.createBankAccount(s, b.getUserID());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void usDeleteAcct(B_User c)
	{
/*		B_AccountDAOImpl badi = new B_AccountDAOImpl();
		B_UserDAOImpl budi = new B_UserDAOImpl();*/
		
		Scanner sc = new Scanner(System.in);
		
		List<B_Account> accts;
		try {
			
			accts = badi.getMyAccountList(c.getUserID());
			System.out.println(accts);
			
			System.out.println("Which account would you like to delete?(you can only delete accounts with zero balance)");
			int acctid = sc.nextInt();
			boolean check = false;
			
			for (B_Account d : accts) {
				if (acctid == d.getAccountID()) {
					if (d.getAccountBalance() == 0) {
						check = true;
					}
				}
			}
			
			if (check) {
				
				Connection conn = cf.getConnection();
				String sql = "{call DELETEENTRYACCT(?)";
			
				//System.out.println(i.getUserID());
				CallableStatement call = conn.prepareCall(sql);
				
				call.setInt(1, acctid);
				
				call.execute();
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void deposit(B_User c) {
/*		B_AccountDAOImpl badi = new B_AccountDAOImpl();
		B_UserDAOImpl budi = new B_UserDAOImpl();*/
		Scanner sc = new Scanner(System.in);
		
		List<B_Account> accts;
				
		try {
			
			accts = badi.getMyAccountList(c.getUserID());
			System.out.println(accts);
			
			B_Account relAcct = new B_Account();
			System.out.println("Into which account are you depositing?(ID)");
			int acctId = sc.nextInt();
			for (B_Account b : accts) {
				if (acctId == b.getAccountID()) {
					relAcct = b;
				}
			}
			
			System.out.println("How much money are you depositing?");
			float dep = sc.nextFloat();
			
			
			
			Connection conn = cf.getConnection();
			String sql = "{call CHANGEBAL(?, ?, ?)";
		
			//System.out.println(i.getUserID());
			CallableStatement call = conn.prepareCall(sql);
			
			call.setInt(1, relAcct.getAccountID());
			call.setFloat(2, relAcct.getAccountBalance()+ dep);
			call.setString(3, "+" + dep);
			call.execute();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void withdraw(B_User c) {
/*		B_AccountDAOImpl badi = new B_AccountDAOImpl();
		B_UserDAOImpl budi = new B_UserDAOImpl();*/
		Scanner sc = new Scanner(System.in);
		
		List<B_Account> accts;
				
		try {
			
			accts = badi.getMyAccountList(c.getUserID());
			System.out.println(accts);
			
			B_Account relAcct = new B_Account();
			System.out.println("Which account are you making a withdrawal from(ID)?");
			int acctId = sc.nextInt();
			for (B_Account b : accts) {
				if (acctId == b.getAccountID()) {
					relAcct = b;
				}
			}
			
			System.out.println("How much money are you withdrawing?");
			float dep = sc.nextFloat();
			
			if (relAcct.getAccountBalance() - dep >= 0) {
				Connection conn = cf.getConnection();
				String sql = "{call CHANGEBAL(?, ?, ?)";
			
				//System.out.println(i.getUserID());
				CallableStatement call = conn.prepareCall(sql);
				
				call.setInt(1, relAcct.getAccountID());
				call.setFloat(2, relAcct.getAccountBalance() - dep);
				call.setString(3, "-"+dep);
				call.execute();
				conn.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	//TODO logout
	
	}
}
