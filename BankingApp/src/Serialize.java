import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Serialize {

	 public void Serializ3(String fileName, Object o1) {
      
     // Serialization 
     try
     {   
         //Saving of object in a file
         FileOutputStream file = new FileOutputStream(fileName);
         ObjectOutputStream out = new ObjectOutputStream(file);
          
         // Method for serialization of object
         out.writeObject(o1);
          
         out.close();
         file.close();
          
         System.out.println("Object has been serialized");

     }
      
     catch(IOException ex)
     {
         System.out.println("IOException is caught");
     }
}
	 public void Deserialization(String fileName, Object o1) {
		
	        try
	        {   
	            
	            FileInputStream file = new FileInputStream(fileName);
	            ObjectInputStream in = new ObjectInputStream(file);
	             
	            ArrayList<Account> arrli = new ArrayList<Account>();

	            
	             
	            in.close();
	            file.close();
	             
	           
	        }
	         
	        catch(IOException ex)
	        {
	            System.out.println("IOException is caught");
	        }
	 
	    }
	 
	 
	 }
	


