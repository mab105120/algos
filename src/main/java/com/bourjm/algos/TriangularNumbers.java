package com.bourjm.algos;

public class TriangularNumbers {

	public int getTriangularNumber(int n) {
		int tn = 0;
		int j = 1;
		for (int i = 0; i < n; i++) {
			tn += j++;
		}
		return tn;
	}

	public static void main(String[] args) { 
		TriangularNumbers tn = new TriangularNumbers();
		System.out.println(tn.getTriangularNumber(7));
	}
	
}
