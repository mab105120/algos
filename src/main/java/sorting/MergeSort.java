package sorting;

import java.util.Comparator;

public class MergeSort {

	protected static <T> void merge(Comparator<T> c, T[]t, T[] aux, int lo, int mid, int hi) {
		for (int k = lo; k <= hi; k++)
			aux[k] = t[k];
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				t[k] = aux[j++];
			else if (j > hi)
				t[k] = aux[i++];
			else if (Sort.less(c, aux[i], aux[j]))
				t[k] = aux[i++];
			else
				t[k] = aux[j++];
		}
	}

	public static <T extends Comparable<T>> void sort(Comparator<T> c, T[] t) {
		T[] aux = (T[]) new Comparable[t.length]; // the ugly cast
		int N = t.length;
		for (int sz = 1; sz < N; sz = sz * 2) {
			for (int lo = 0; lo < N - sz; lo = lo + 2 * sz) {
				merge(c, t, aux, lo, lo + sz - 1, Math.min(lo + 2 * sz - 1, N - 1));
			}
		}
	}

}
