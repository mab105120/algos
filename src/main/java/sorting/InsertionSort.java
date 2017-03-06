package sorting;

import java.util.Comparator;

public class InsertionSort {

	public static <T> void sort(Comparator<T> c, T[]a) {
		for (int i = 0; i < a.length; i++)
			for (int j = i; j >= 1; j--)
				if (Sort.less(c, a[j], a[j - 1]))
					Sort.exchange(a, j, j - 1);
	}
}