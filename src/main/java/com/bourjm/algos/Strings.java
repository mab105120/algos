package com.bourjm.algos;

public class Strings {

	public String reverse(String s) {
		String reverse = "";
		for (int i = 0; i < s.length(); i++)
			reverse = s.charAt(i) + reverse;
		return reverse;
	}

	public String recursiveReverse(String s) {

		return null;
	}

}
