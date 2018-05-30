package com.revature.banking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class TechnicalDB {
	/*{
		try {
			File dB = new File("DB.txt");
			Scanner fsc = new Scanner(dB);
		} catch (FileNotFoundException n) {
			n.printStackTrace();
		}
		
	}*/
	
	/*public static void addToDB(Employee e) {
		try {

			BufferedWriter out = new BufferedWriter(new FileWriter("Employees.txt"));
			out.write(e.getUsername() + " " + e.getPasswd() + " " + e.getName() + " " + e.getPhonen() + " " + e.isLoggedIn());
			out.newLine();
		} catch(IOException o) {
			o.printStackTrace();
		}

	}*/
	/*public static void addToDB(ArrayList<Employee> user) {
		
	}*/
	public static void addToDB(Customer e) {
		try {
			ArrayList<Customer> cust = new ArrayList<Customer>();
			BufferedReader br = new BufferedReader(new FileReader("data/Customers.txt")); 
			String temp = br.readLine();
			System.out.println("br " + temp);
			if (temp != null) {
				cust = translateTextToArrayCu();
			/*if(translateTextToArrayCu() == null) cust = translateTextToArrayCu();*/
			}
			boolean isItAlreadyThere = false;
			for (Customer cu : cust) {
				if (cu.getId().equals(e.getId())) {
					isItAlreadyThere = true;
					break;
				}
			}
			if(!isItAlreadyThere) {
				cust.add(e);
			}
			//Collections.sort(cust, new CompareN());
			File f = new File("data/Customers.txt");
			if (f.exists())
			{
			  //delete if exists
			   f.delete();
			   //System.out.println("It was deleted");
			}
			//FileWriter out = new FileWriter(f); 
			
			BufferedWriter out = new BufferedWriter(new FileWriter(f));
			//HashSet<Customer> titles = new HashSet<Customer>();
				
			
			for(Customer c : cust) {
				out.write(c.getName() + ":" + c.getUsername() + ":" + c.getPasswd() + ":" + c.getPhonen() + ":" + c.getId());
				out.newLine();
			}

			out.close();
		} catch(IOException o) {
			o.printStackTrace();
		}

	}
	
	public static void addToDB(Account a) {
		try {
			HashSet<Account> acc = new HashSet<Account>();
			BufferedReader br = new BufferedReader(new FileReader("data/Accounts.txt")); 
			String temp = br.readLine();
			System.out.println("br " + temp);
			if (temp != null) {
				acc = translateTextToArrayAc();
			/*if(translateTextToArrayCu() == null) cust = translateTextToArrayCu();*/
			}
			boolean isItAlreadyThere = false;
			for (Account a1 : acc) {
				if (a1.getAccountId().equals(a.getAccountId())) {
					isItAlreadyThere = true;
					break;
				}
			}
			if(!isItAlreadyThere) {
				acc.add(a);
			}
			//Collections.sort(cust, new CompareN());
			File f = new File("data/Accounts.txt");
			if (f.exists())
			{
			  //delete if exists
			   f.delete();
			   //System.out.println("It was deleted");
			}
			//FileWriter out = new FileWriter(f); 
			
			BufferedWriter out = new BufferedWriter(new FileWriter(f));
			//HashSet<Customer> titles = new HashSet<Customer>();
				
			
			for(Account ac : acc) {
				out.write(ac.getAccountBalance() + ":" + ac.getSignerIDs() + ":" + ac.getAccountId());
				out.newLine();
			}

			out.close();
		} catch(IOException o) {
			o.printStackTrace();
		}

	}
	/*public static void addToDB(ArrayList<Customer> users) {
		
	}*/
	public static void updateEmp (Employee e) {
		//translateFromTextToArray()
	}
	public static void updateCu (Customer e) {
		ArrayList<Customer> currentCustomers = new ArrayList<Customer>();
		
	}
	public static void removeFromEmp (Employee e) {
		
	}
	public static void removeFromCu (Customer e) {
		
	}
	/*public static void removeFromDB(ArrayList<User> users) {
		
	}*/
	/*public static void printDB() {
		
	}*/
/*	public static ArrayList<Account> translateTextToArray(String filename) {
		try {
			ArrayList<Account> currentAccounts;
			File dB = new File(filename);
			Scanner fsc = new Scanner(dB);
			while (fsc.nextLine() != null) {
				currentAccounts.add(Account);
			}
		} catch (FileNotFoundException n) {
			n.printStackTrace();
		}
		return ;
	}*/
	public static ArrayList<Customer> translateTextToArrayCu() {
		ArrayList<Customer> currentCustomers = new ArrayList<Customer>();
		//ArrayList<String> idStack = new ArrayList<String>();
		try {
			File dB = new File("data/Customers.txt");
			
			Scanner fsc = new Scanner(dB);
			//System.out.println(fsc.hasNextLine());
			//System.out.println(fsc.nextLine());
			//if (fsc.hasNextLine() && fsc.nextLine()!=null) {
			BufferedReader br = new BufferedReader(new FileReader(dB));
			String firstLine = br.readLine();
			if (firstLine!=null) {
/*				BufferedReader br1 = new BufferedReader(new FileReader(dB)); 
				while(br1.readLine() != null) {
					String firstSplit = br1.readLine();
					System.out.println("first split " + firstSplit);
					//String[] firstSplit = br1.readLine().split(":");
					//idStack.add(firstSplit[4]);
				}*/
				
				
				while (fsc.hasNextLine()) {
					//if (fsc.nextLine() != null) {
						String[] acct = fsc.nextLine().split(":");
						//System.out.println(java.util.Arrays.toString(acct));
						
						//System.out.println("this"+java.util.Arrays.toString(User.getLoggedUsers().toArray()));
						//System.out.println(User.getLoggedUsers().contains(acct[4]));
						if(!User.getLoggedUsers().contains(acct[4])) {
							
							currentCustomers.add(new Customer(acct[0], acct[1], acct[2], acct[3]));
						} else if(User.getLoggedUsers().contains(acct[4])) {
							currentCustomers.add(new Customer(acct[0], acct[1], acct[2], acct[3], acct[4]));
						}
				}

			       /*System.out.println("Employee List(Duplicate)");
			       for (Customer cu : currentCustomers) {
			           System.out.println(cu.getId());
			       }

			       HashSet<Customer> hashSet = new HashSet(currentCustomers);      // create has set. Set will contains only unique objects

			       System.out.println("Employee List(Unique)");
			       for (Customer cu : hashSet) {
			           System.out.println(cu.getId());
			       }*/
/*		        java.util.List<Customer> uniqueEmployee = (List<Customer>) currentCustomers.stream()
                        .distinct()
                        .collect(Collectors.toList());*/
				/*int x = currentCustomers.size();
				for(int i = 0; i < x; i++) {
					for (int j = 0; j < x; j++) {
						if (currentCustomers.get(i).getId().equals(currentCustomers.get(j).getId())){
												}
					}
				}*/
			//}
			}
			return currentCustomers;
		} catch (FileNotFoundException n) {
			n.printStackTrace();
		} catch (IOException n) {
			n.printStackTrace();
		}
		return currentCustomers;
	}

	public static HashSet<Account> translateTextToArrayAc() {
		HashSet<Account> currentAccounts = new HashSet<Account>();
		//ArrayList<String> idStack = new ArrayList<String>();
		try {
			File dB = new File("data/Accounts.txt");
			
			Scanner fsc = new Scanner(dB);
			//System.out.println(fsc.hasNextLine());
			//System.out.println(fsc.nextLine());
			//if (fsc.hasNextLine() && fsc.nextLine()!=null) {
			BufferedReader br = new BufferedReader(new FileReader(dB));
			String firstLine = br.readLine();
			if (firstLine!=null) {
/*				BufferedReader br1 = new BufferedReader(new FileReader(dB)); 
				while(br1.readLine() != null) {
					String firstSplit = br1.readLine();
					System.out.println("first split " + firstSplit);
					//String[] firstSplit = br1.readLine().split(":");
					//idStack.add(firstSplit[4]);
				}*/
				
				
				while (fsc.hasNextLine()) {
					//if (fsc.nextLine() != null) {
						String[] acct = fsc.nextLine().split(":");
						//System.out.println(java.util.Arrays.toString(acct));
						
						//System.out.println("this"+java.util.Arrays.toString(User.getLoggedUsers().toArray()));
						//System.out.println(User.getLoggedUsers().contains(acct[4]));
						HashSet<String> h = new HashSet<String>();
						if(!User.getLoggedUsers().contains(acct[2])) {

							for(String s : acct[1].split(" ")) {
								h.add(s);
							}
							currentAccounts.add(new Account(Float.valueOf(acct[0]), h));
						} else if(User.getLoggedUsers().contains(acct[2])) {
							currentAccounts.add(new Account(Float.valueOf(acct[0]), h, acct[2]));
						}
				}
			}
			return currentAccounts;
		} catch (FileNotFoundException n) {
			n.printStackTrace();
		} catch (IOException n) {
			n.printStackTrace();
		}
		return currentAccounts;
	}
	/*public static ArrayList<Employee> translateTextToArrayEmp(String filename) {

		try {
			ArrayList<Employee> currentEmployees = new ArrayList<Employee>();

			File dB = new File("data/Employees.txt");
			//System.out.println(dB.getAbsolutePath());
			//System.out.println(dB.getCanonicalPath());
			Scanner fsc = new Scanner(dB);
			//String[] firstLine = fsc.nextLine().split(" ");
			//currentCustomers.add(new Customer(firstLine[0], firstLine[1], firstLine[2], firstLine[3]));
			while (fsc.hasNextLine()) {
				String[] acct = fsc.nextLine().split(" ");
				currentEmployees.add(new Employee(acct[0], acct[1], acct[2], acct[3]));
			}
			return currentEmployees;
		} catch (FileNotFoundException n) {
			n.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}*/
}
