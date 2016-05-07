package datastructures;

import java.util.Iterator;

public class ArrayQueue<T> implements Iterable<T> {

	// this comment is added with intellij community IDEA
	private T[] a = (T[]) new Object[1]; // the ugly cast
	private int N, T = 0;

	public void enqueue(T t) {
		if (T >= a.length / 2)
			resize(a.length * 2);
		a[T++] = t;
	}

	public T front() {
		return a[N];
	}

	public T dequeue() {
		if (T <= a.length / 4)
			resize(a.length / 2);
		return a[N++];
	}

	public boolean isEmpty() {
		return (N == T);
	}

	private void resize(int capacity) {
		T[] copy = (T[]) new Object[capacity]; // the ugly cast
		for (int i = 0; i < T; i++)
			copy[i] = a[i];
		a = copy;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ArrayQueueIterator();
	}

	private class ArrayQueueIterator implements Iterator<T> {

		private int current = N;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != T;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return a[current++];
		}

	}

}