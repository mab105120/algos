package datastructures;

import sorting.Sort;

public class UnorderedMinPQ<T extends Comparable<T>> {

	// This class is an implementation of a Minimum Priority Queue

	private T[] a;
	private int N;

	public UnorderedMinPQ() {
		this.a = (T[]) new Comparable[1]; // the ugly cast
		this.N = 0;
		// default constructor
	}

	public UnorderedMinPQ(T[] a) {
		this.a = a;
		int N = a.length;
		this.resize(N * 2);
		this.N = N;
	}

	public void insert(T t) {
		if (N > a.length / 2)
			resize(2 * a.length);
		a[N++] = t;
	}

	public T removeMin() {
		int min = 0;
		for (int i = 1; i < N; i++) {
			if (Sort.less(a[i], a[min]))
				min = i;
		}
		Sort.exchange(a, min, N - 1);
		return a[--N];
	}

	private void resize(int capacity) {
		T[] copy = (T[]) new Comparable[capacity]; // the ugly cast
		for (int i = 0; i < a.length; i++)
			copy[i] = a[i];
		a = copy;
	}
}