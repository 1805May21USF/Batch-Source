package project1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DoSerialization {
	//Customer customer = new Customer();
	
	public DoSerialization() {
		// TODO Auto-generated constructor stub
	}
	
	public static void serialize(Customer customer) {
		try {
			File filename = new File("Data/Customers/" + customer.getUserName() + ".text");
	         FileOutputStream fileOut =
	    	         new FileOutputStream(filename);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(customer);
	         out.close();
	         fileOut.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
	}
	
	public static Customer deserialize(String userName) {
		//Customer customer;
		//ArrayList<Customer> list = new ArrayList<>();
	      try {
	    	  File file = new File("Data/Customers/" + userName + ".text" );
	         FileInputStream fileIn = new FileInputStream(file);
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         Customer customer = (Customer) in.readObject();
	         in.close();
	         fileIn.close();
	         return customer;
	      } catch (IOException i) {
	         i.printStackTrace();
	         return null;
	      } 
	      catch (ClassNotFoundException c) {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	         return null;
	      }
	}

}
