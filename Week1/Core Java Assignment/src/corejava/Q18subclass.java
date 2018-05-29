package corejava;

public class Q18subclass implements Q18superclass {

	//loops through and checks whether each char in string is uppercase
	public boolean CheckUpper(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (Character.isUpperCase(str.charAt(i))) {
				return true;
			};
		}
		return false;
	}

	//converts each char (if lowercase) into uppercase
	public String ToUpper(String str) {
		char[] charArr = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			if (Character.isLowerCase(str.charAt(i))) {
				charArr[i] = Character.toUpperCase(str.charAt(i));
			}
			else {
				charArr[i] = str.charAt(i);
			}
		}
		return new String(charArr);
	}

	//prints string as int plus 10
	public void ToInt(String str) {
		Integer i = Integer.parseInt(str);
		System.out.println(i + 10);
	}
}
