package com.revature.corejava;

//Imported the package
import com.revature.q11float.Q11vars;

public class Q11 
{
	//Instantiated the Object from the Class in the imported package. Q11vars.
	public void displayOtherPackageFloatNumbers()
	{
		Q11vars myVars = new Q11vars();
		
		System.out.println(myVars.getFirstFloatNumber()+" "+myVars.getSecondFloatNumber());
	}

}
