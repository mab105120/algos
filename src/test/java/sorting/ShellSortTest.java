package sorting;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Moe on 3/4/17.
 */
public class ShellSortTest {

    @Test
    public void testShellSort() {
        String[] s = SortTest.readLetters();
        ShellSort.sort(s);
        assertTrue(SortTest.isSorted(s));
    }


}
