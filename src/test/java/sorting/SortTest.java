package sorting;

import edu.princeton.cs.introcs.In;
import org.junit.Test;

import java.io.File;
import java.util.Comparator;
import java.util.function.BiConsumer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SortTest {

    @Test
    public void lessTest() {
        assertTrue(Sort.less(Comparator.naturalOrder(), 1, 2));
    }

    @Test
    public void equalItems() {
        assertFalse(Sort.less(Comparator.naturalOrder(), 1, 1));
    }

    @Test
    public void exchange() {
        Integer[] i = new Integer[]{1, 2, 3, 4, 5, 6};
        Sort.exchange(i, 4, 5);
        assertTrue(i[4] == 6);
        assertTrue(i[5] == 5);
    }

    public static <T> boolean isSorted(Comparator<T> c, T[] a) {
        for (int i = 1; i < a.length; i++)
            if (Sort.less(c, a[i], a[i - 1])) return false;
        return true;
    }

    private static String[] readLetters() {
        In in = new In(new File("src/test/resource/letters.txt"));
        return in.readAllStrings();
    }

    @Test
    public void sort() {
        String[] s = readLetters();
        sort(s, Comparator.naturalOrder(), InsertionSort::sort);
        sort(s, Comparator.naturalOrder(), SelectionSort::sort);
        sort(s, Comparator.naturalOrder(), QuickSort::sort);
        sort(s, Comparator.naturalOrder(), MergeSort::sort);
        sort(s, Comparator.naturalOrder(), ShellSort::sort);
    }

    private static <T> void sort(T[] t, Comparator<T> p, BiConsumer<Comparator<T>, T[]> c) {
        c.accept(p, t);
        assertTrue(isSorted(p, t));
    }

}