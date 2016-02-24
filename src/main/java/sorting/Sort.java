package sorting;

public class Sort {

	public static <T> boolean less(Comparable<T> a, T b) {
		return a.compareTo(b) < 0;
	}

	public static <T extends Comparable<T>> boolean lessThanOrEq(T a, T b) {
		return a.compareTo(b) <= 0;
	}

	public static <T> void exchange(T[] a, int i, int j) {
		T swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
}