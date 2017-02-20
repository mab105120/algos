package com.bourjm.algos;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Moe on 2/18/17.
 */
public class WeightedQuickUnionTest {

    @Test
    public void weightedQuickUnionTest() {
        WeightedQuickUnion wqu = new WeightedQuickUnion(10);
        wqu.union(0, 5);
        wqu.union(4, 3);
        wqu.union(6, 8);
        wqu.union(0, 8);
        assertTrue(wqu.isConnected(5, 8));
        assertTrue(wqu.isConnected(5, 6));
        assertFalse(wqu.isConnected(4, 8));
        assertFalse(wqu.isConnected(1, 2));
        wqu.union(5, 4);
        assertTrue(wqu.isConnected(6, 3));
    }
}