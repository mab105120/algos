package applications;

import static org.junit.Assert.*;

import applications.IntegerOccurance;
import org.junit.Test;

public class IntegerOccuranceTest {

	private final Integer[] i = { 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4 };

	@Test
	public void getIntegerWithTheMostOccurance() {
		assertEquals(4, IntegerOccurance.getMostFrequentOccurance(i));
		assertEquals(4, IntegerOccurance.mostFrequentOccurance(i));
	}

	@Test
	public void getIntegerWithMostOccurancesWhenATieExists() {
		Integer[] i = { 1, 1, 1, 2, 2, 2 };
		assertEquals(2, IntegerOccurance.getMostFrequentOccurance(i));
		assertEquals(2, IntegerOccurance.mostFrequentOccurance(i));
	}
}