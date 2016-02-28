package sorting;

public class SelectionSort {

	public static <T extends Comparable<T>> void sort(T[] a) {
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i; j < a.length; j++)
				if (Sort.less(a[j], a[min]))
					min = j;
			Sort.exchange(a, i, min);
		}
	}
	
}