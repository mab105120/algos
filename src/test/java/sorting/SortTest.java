package sorting;

import beans.Book;
import edu.princeton.cs.introcs.In;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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

    @Test
    public void sort() {
        Book[] books = readBooks();
        List<BiConsumer<Comparator<Book>, Book[]>> functions = getSortingFunctions();
        for (BiConsumer<Comparator<Book>, Book[]> function : functions) {
            sort(books, Book.BY_AUTHOR, function);
            sort(books, Book.BY_PRICE, function);
        }
    }

    private static <T> List<BiConsumer<Comparator<T>, T[]>> getSortingFunctions() {
        List<BiConsumer<Comparator<T>, T[]>> functions = new ArrayList<>();
        functions.add(SelectionSort::sort);
        functions.add(InsertionSort::sort);
        functions.add(ShellSort::sort);
        functions.add(MergeSort::sort);
        functions.add(QuickSort::sort);
        return functions;
    }

    private static <T> void sort(T[] t, Comparator<T> p, BiConsumer<Comparator<T>, T[]> c) {
        c.accept(p, t);
        assertTrue(isSorted(p, t));
    }

    public static <T> boolean isSorted(Comparator<T> c, T[] a) {
        for (int i = 1; i < a.length; i++)
            if (Sort.less(c, a[i], a[i - 1])) return false;
        return true;
    }

    private static Book[] readBooks() {
        List<Book> books = new ArrayList<>();
        In in = new In("src/test/resource/books.txt");
        while (in.hasNextLine()) {
            String[] params = in.readLine().split(";");
            books.add(new Book(params[1], params[0], Integer.parseInt(params[2]), Integer.parseInt(params[3])));
        }
        Book[] booksArray = new Book[books.size()];
        for (int i = 0; i < books.size(); i++)
            booksArray[i] = books.get(i);
        return booksArray;
    }

}