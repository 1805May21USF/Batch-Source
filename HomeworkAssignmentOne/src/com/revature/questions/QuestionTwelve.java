package com.revature.questions;

import com.revature.qelevenone.QElevenOne;
import com.revature.qeleventwo.QElevenTwo;

public class QuestionTwelve {
		
		public QuestionTwelve() {
			
		}
		public void run() {
			int[] hundo = new int[100];
			for(int i = 1;i<=100;i++) {
				hundo[i-1]=i;
			}
			for(Integer i:hundo) {
				if(i%2==0) {
					System.out.print(i+" ");
				}
			}
			System.out.println();
		}

}
