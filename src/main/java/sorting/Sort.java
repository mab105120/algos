package sorting;

import java.util.Comparator;

public class Sort {

	public static <T> boolean less(Comparator<T> c, T a, T b) {
		return c.compare(a, b) < 0;
	}


	public static <T> void exchange(T[] a, int i, int j) {
		T swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
}