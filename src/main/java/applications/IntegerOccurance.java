package applications;

import java.util.HashMap;
import java.util.Map;

public class IntegerOccurance {

	// Problem: Find the most frequent integer in an array

	/*
	 * This is a linear algorithm to solve the problem
	 */
	public static int mostFrequentOccurance(Integer[] i) {
		HashMap<Integer, Integer> counter = new HashMap<>();
		for (int j = 0; j < i.length; j++)
			if (counter.get(i[j]) == null)
				counter.put(i[j], 1);
			else
				counter.put(i[j], counter.get(i[j]) + 1);
		// Iterate through the map to find the maximum
		int max = counter.get(i[0]);
		for (Map.Entry<Integer, Integer> j : counter.entrySet())
			if (j.getValue() >= max)
				max = j.getKey();
		return max;
	}

	/*
	 * brute-force algorithm This is an N-Squared algorithm so it doesn't scale
	 * well.
	 */
	public static int getMostFrequentOccurance(Integer[] i) {
		int max = 0;
		for (int j = 0; j < i.length; j++) {
			int counter = 0;
			for (int k = 0; k < i.length; k++)
				if (i[k] == i[j])
					counter++;
			if (counter >= max)
				max = i[j];
		}
		return max;
	}

}
