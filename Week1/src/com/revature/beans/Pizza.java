package com.revature.beans;
import java.util.*;

public class Pizza {

	
	
	private String p  = "";
	private int pepTops = 2;
	private int CheeseTops = 1;
	private int SupremeTops = 5;
	
	
		
	public Pizza() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getP() {
		return p;
	}



	public void setP(String p) {
		this.p = p;
	}



	public int getPepTops() {
		return pepTops;
	}



	public void setPepTops(int pepTops) {
		this.pepTops = pepTops;
	}



	public int getCheeseTops() {
		return CheeseTops;
	}



	public void setCheeseTops(int cheeseTops) {
		CheeseTops = cheeseTops;
	}



	public int getSupremeTops() {
		return SupremeTops;
	}



	public void setSupremeTops(int supremeTops) {
		SupremeTops = supremeTops;
	}



	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		boolean end = false;
		
		// TODO Auto-generated method stub
		Pizza pizza = new Pizza();
		
		while(end == false) {
		System.out.println("Enter your favorite Pizza!");
		pizza.setP(in.next());
		
		
			System.out.println(pizza.getP());
		
		
		switch(pizza.getP()) {
		
		case "Pepperoni":{
			System.out.println("That sounds delicious");
				for(int i = 0; i<pizza.getPepTops();i++) {
					System.out.println("Adding Topping");
				}
				break;
		}
		case "Cheese":{
			System.out.println("Meh");
			for(int i = 0; i<pizza.getCheeseTops();i++) {
				System.out.println("Adding Topping");
			}
			break;
				
		}
		case "Supreme":{
			System.out.println("Get that outta here!");
			for(int i = 0; i<pizza.getSupremeTops();i++) {
				System.out.println("Adding Topping");
				break;
			}
			
		}
		default:
			System.out.println("Thats not pizza bro");
			break;
		}
		
		}//end Switch
		System.out.println("Do you want another Pizza?");
		in.nextLine();
	}

}
