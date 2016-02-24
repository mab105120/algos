package sorting;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuickSortTest {

	private Integer[] a = new Integer[] { 4, 2, 6, 7, 3, 7, 9, 4, 3, 6, 8 };

	@Test
	public void partition() {
		int j = QuickSort.partition(a, 0, a.length - 1);
		for (int i = 0; i < j; i ++) 
			assertTrue(Sort.lessThanOrEq(a[i], a[j]));
		for (int i = j; i < a.length; i++) 
			assertTrue(Sort.lessThanOrEq(a[j], a[i]));
	}

	@Test
	public void sort() {
		QuickSort.sort(a);
		assertTrue(SortTest.isSorted(a));
	}
}
