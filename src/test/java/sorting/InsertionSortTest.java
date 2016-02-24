package sorting;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class InsertionSortTest {

	private String[] s = new String[]{"b","e","a","d","c","f"};
	
	@Test
	public void selectionSort() {
		SelectionSort.sort(s);
		assertTrue(SortTest.isSorted(s));
	}	
	
	@Test
	public void insertionSort() { 
		InsertionSort.sort(s);
		assertTrue(SortTest.isSorted(s));
	}
}