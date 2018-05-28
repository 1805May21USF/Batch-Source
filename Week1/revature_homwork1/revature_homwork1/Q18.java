package revature_homwork1;

public class Q18 extends Q18Super{
	 public static void main(String[] args) {
		 Q18 q = new Q18();
		 System.out.println("potato" + " uppers = " + q.uppers("potato"));
		 System.out.println("POtaTO" + " uppers = " + q.uppers("POtaTO"));
		 System.out.println("potato" + " toUpper = " + q.toUpper("potato"));
		 System.out.println("POtaTO" + " toUpper = " + q.toUpper("POtaTO"));
		 System.out.println("pot31ato" + " newToInt = " + q.newToInt("31"));
		 System.out.println("331" + " newToInt = " + q.newToInt("331"));
	 }

	@Override
	public boolean uppers(String s) {
		return (s.toLowerCase().equals(s));
	}

	@Override
	public String toUpper(String s) {
		return s.toUpperCase();
	}

	@Override
	public int newToInt(String s) {
		System.out.println(Integer.parseInt(s)+10);
		return Integer.parseInt(s)+10;
	}
}
