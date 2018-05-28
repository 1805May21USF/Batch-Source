package revature_homwork1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Q14 {
	public static String[] doit(int mode) {
		switch  (mode) {
		case 0:
			String[] holder = new String[1];
			holder[0]=""+(Math.sqrt(24134.31));
			return holder;
		case 1:
			String[] holder1 = new String[1];
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  

			holder1[0]= now.toString();
			return holder1;
		default:
			String[] holder2 = new String[2];
			holder2[0]="I am learning Core Java".substring(0, 10);
			holder2[0]="I am learning Core Java".substring(10,23);

			return holder2;
		
		}
			
	}
}	
