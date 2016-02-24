package sorting;

public class QuickSort {

	protected static <T extends Comparable<T>> int partition(T[] a, int lo,
			int hi) {
		int i = lo;
		int j = hi + 1;
		while (true) {
			while (Sort.less(a[++i], a[lo]))
				if (i == hi)
					break;
			while (Sort.less(a[lo], a[--j]))
				if (j == lo)
					break;
			if (j <= i)
				break;
			else
				Sort.exchange(a, i, j);
		}
		Sort.exchange(a, lo, j);
		return j;
	}

	protected static <T extends Comparable<T>> void sort(T[] a, int lo, int hi) {
		if (lo >= hi)
			return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	public static <T extends Comparable<T>> void sort(T[] a) {
		sort(a, 0, a.length - 1);
	}
}