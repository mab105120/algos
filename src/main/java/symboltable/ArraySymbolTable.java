package symboltable;

import sorting.Sort;

public class ArraySymbolTable<K extends Comparable<K>, V> {

	private K[] keys = (K[]) new Comparable[1]; // the ugly cast
	private V[] values = (V[]) new Object[1]; // the ugly cast
	private int N = 0;

	public void put(K key, V value) {
		// check if the key already exists in the array
		for (int i = 0; i < N; i++) {
			if (keys[i].compareTo(key) == 0) {
				values[i] = value;
				return;
			}
		}
		if (N > keys.length / 2)
			resize(keys.length * 2);
		keys[N] = key;
		values[N] = value;
		N++;
	}

	public V delete(K key) {
		if (isEmpty())
			return null;
		for (int i = 0; i < N; i++)
			if (keys[i].compareTo(key) == 0) {
				Sort.exchange(keys, i, N - 1);
				Sort.exchange(values, i, N - 1);
				keys[N - 1] = null;
				V value = values[N - 1];
				values[N - 1] = null; // to avoid loitering
				N--;
				return value;
			}

		return null;
	}

	public V get(K key) {
		for (int i = 0; i < N; i++)
			if (keys[i].compareTo(key) == 0)
				return values[i];
		return null;
	}

	public boolean contains(K key) {
		return get(key) != null;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	private void resize(int capacity) {
		K[] keyCopy = (K[]) new Comparable[capacity]; // the ugly cast
		for (int i = 0; i < N; i++)
			keyCopy[i] = keys[i];
		keys = keyCopy;
		V[] valueCopy = (V[]) new Object[capacity]; // the ugly cast
		for (int i = 0; i < N; i++)
			valueCopy[i] = values[i];
		values = valueCopy;
	}
}
