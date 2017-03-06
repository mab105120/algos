package datastructures;

import sorting.QuickSort;
import sorting.Sort;

import java.util.Comparator;

public class OrderedMaxPQ<T> {

	private T[] a;
	private int N;
	private Comparator<T> c;

	public OrderedMaxPQ(Comparator<T> c) {
		this.a = (T[]) new Comparable[1]; // the ugly cast
		this.c = c;
		QuickSort.sort(c, a);
		this.N = 0;
	}

	public void insert(T t) {
		if (N > a.length / 2)
			resize(a.length * 2);
		a[N++] = t;
		for (int i = N - 1; i > 0; i--)
			if (Sort.less(c, a[i], a[i - 1]))
				Sort.exchange(a, i, (i - 1));
			else
				break;
	}

	public T removeMax() {
		if (!isEmpty()) {
			T max = a[--N];
			a[N] = null; // avoid loitering
			return max;
		} else
			throw new RuntimeException("The array is empty!");
	}

	public boolean isEmpty() {
		return N == 0;
	}

	private void resize(int capacity) {
		T[] copy = (T[]) new Comparable[capacity]; // the ugly cast
		for (int i = 0; i < N; i++)
			copy[i] = a[i];
		a = copy;
	}

}
