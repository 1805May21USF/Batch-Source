package com.revature.GavinHomework;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

//This is question 1 from the first homework assignment
//The point of this class is to implement 

//We good
public class Q01BubbleSort {
	
	
	//This was my first test method I made. It tests the equality of a and b after b has been bubble sorted
	@Test
	public void tester() {
		
		int [] a = {0,1,2,3,3,4,5,6,7,8,9};
		int [] b = {1,0,5,6,3,2,3,7,9,8,4};
		b = sortMe(b);
		assertArrayEquals(a, b);
	}
	
	
	//I found this bubble sort algorithm online and then turned it into code myself.
	//Nothing special, just bubble sort made in java. It works for any array.
	public int[] sortMe(int[] arr) {
		int temp = 0;
		for(int i = 0; i < arr.length;i++) {
			for (int j= 0; j < arr.length-1;j++) {
				if(arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		return arr;
	}
	
}
