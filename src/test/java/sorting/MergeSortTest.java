package sorting;

import static org.junit.Assert.*;

import org.junit.Test;

public class MergeSortTest {

	@Test
	public void mergeSort() {
		Integer[] i = { 3, 4, 7, 3, 7, 9, 0, 2, 1, 2, 6, 8 };
		MergeSort.sort(i);
		assertTrue(SortTest.isSorted(i));
	}

}
