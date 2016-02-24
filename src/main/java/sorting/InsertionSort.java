package sorting;

public class InsertionSort {

	public static <T extends Comparable<T>> void sort(T[] a) {
		for (int i = 0; i < a.length; i++)
			for (int j = i; j >= 1; j--)
				if (Sort.less(a[j], a[j - 1]))
					Sort.exchange(a, j, j - 1);
	}
}