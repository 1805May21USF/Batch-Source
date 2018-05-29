package javaCore;

import java.util.Arrays;

public class q1BubbleSort {
	int[] myIntArray = new int[]{1,0,5,6,3,2,3,7,9,8,4};
	int n = myIntArray.length;
	{
	for (int i = 0; i < n-1; i++)
        for (int j = 0; j < n-i-1; j++)
            if (myIntArray[j] > myIntArray[j+1])
            {
                int temp = myIntArray[j];
                myIntArray[j] = myIntArray[j+1];
                myIntArray[j+1] = temp;
            }
	System.out.println(Arrays.toString(myIntArray));
	}
}
