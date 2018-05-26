package com.revature.questions;

import com.revature.qelevenone.*;
import com.revature.qeleventwo.*;

public class QuestionEleven {

		public QuestionEleven() {
			
		}
		/*
		 * Just instantiates the two classes from
		 * other packages.
		 */
		public void run() {
			QElevenOne qe1 = new QElevenOne();
			System.out.println(qe1.qElevenOne);
			QElevenTwo qe2 = new QElevenTwo();
			System.out.println(qe2.qElevenTwo);
		}
}
