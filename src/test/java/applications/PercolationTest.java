package applications;

import edu.princeton.cs.introcs.In;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by Moe on 2/19/17.
 */
@RunWith(Parameterized.class)
public class PercolationTest {

    private String filename;
    private boolean expected;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "input10.txt", true },
                { "input10-no.txt", false },
                { "input20.txt", true },
                { "input50.txt", true },
                { "input8.txt", true },
                { "input8-no.txt", false },
                { "input3.txt", true },
                { "input4.txt", true },
                { "input5.txt", true },
                { "jerry47.txt", true },
                { "sedgewick60.txt", true },
                { "wayne98.txt", true }
        });
    }

    public PercolationTest(String filename, boolean expected) {
        this.filename = filename;
        this.expected = expected;
    }

    @Test
    public void testPercolation() {
        final String FILE_PATH = "src/test/resource/percolation/";
        In in = new In(new File(FILE_PATH + this.filename));
        int[] input = in.readAllInts();
        Percolation p = new Percolation(input[0]);
        assertFalse(p.percolates());
        for (int i = 1; i < input.length; i = i + 2)
            p.open(input[i], input[i + 1]);
        assertEquals(expected, p.percolates());
    }
}