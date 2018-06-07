package com.revature.qeighteen;

public class ThingyImplementer implements Thingy{

	@Override
	public boolean caseChecker(String s) {
		char[] chars = s.toCharArray();
		for(int i = 0;i<chars.length;i++)
		{
			if(Character.isUpperCase(chars[i])) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toYellyCase(String s) {
		char[] chars = s.toCharArray();
		for(int i = 0;i<chars.length;i++) {
			chars[i] = Character.toUpperCase(chars[i]);
		}
		return new String(chars);
	}

	@Override
	public String stringPluser(String s) {
		Integer i = Integer.parseInt(s);
		i = i + 10;
		return i.toString();
	}

}
