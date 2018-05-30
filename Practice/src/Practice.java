
public class Practice {

	public static void main(String[] args) {
		String regex = "\\d+(\\.*)(\\d*)";
		String regex2 = "\\d+";

		// positive test cases, should all be "true"
		System.out.println("50.0".matches(regex));
		System.out.println("$500".matches(regex));
		System.out.println("123.456789".matches(regex));
		
		System.out.println();
		// negative test cases, should all be "false"
		System.out.println("111".matches(regex2));
		System.out.println("foo".matches(regex2));
		System.out.println("aa123bb".matches(regex2));
	}

}
