package applications;

import org.junit.Test;

/**
 * Created by Moe on 2/19/17.
 */
public class PercolationTest {

    @Test
    public void percolationTest() {
        Percolation p = new Percolation(4);
        p.open(1,1);
        p.open(2,1);
        p.open(3,1);
        p.open(4,1);
        System.out.println(p.numberOfOpenSites());
        System.out.println(p.percolates());
    }

}
