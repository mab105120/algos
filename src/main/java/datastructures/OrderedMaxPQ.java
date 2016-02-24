package datastructures;

import sorting.QuickSort;
import sorting.Sort;

public class OrderedMaxPQ<T extends Comparable<T>> {

	private T[] a;
	private int N;

	public OrderedMaxPQ() {
		this.a = (T[]) new Comparable[1]; // the ugly cast
		QuickSort.sort(a);
		this.N = 0;
	}

	public void insert(T t) {
		if (N > a.length / 2)
			resize(a.length * 2);
		a[N++] = t;
		for (int i = N - 1; i > 0; i--)
			if (Sort.less(a[i], a[i - 1]))
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
