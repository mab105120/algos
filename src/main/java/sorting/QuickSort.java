package sorting;

import java.util.Comparator;

public class QuickSort {

	protected static <T> int partition(Comparator<T> c, T[] a, int lo,
			int hi) {
		int i = lo;
		int j = hi + 1;
		while (true) {
			while (Sort.less(c, a[++i], a[lo]))
				if (i == hi)
					break;
			while (Sort.less(c, a[lo], a[--j]))
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

	protected static <T> void sort(Comparator<T> c, T[] a, int lo, int hi) {
		if (lo >= hi)
			return;
		int j = partition(c, a, lo, hi);
		sort(c, a, lo, j - 1);
		sort(c, a, j + 1, hi);
	}

	public static <T> void sort(Comparator<T> c, T[]a) {
		sort(c, a, 0, a.length - 1);
	}
}