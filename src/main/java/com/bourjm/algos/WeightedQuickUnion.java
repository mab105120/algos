package com.bourjm.algos;

/**
 * Created by Moe on 2/18/17.
 */
public class WeightedQuickUnion {

    private int[] w;
    private int[] a;

    public WeightedQuickUnion(int n) {
        this.w = new int[n];
        this.a = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = 1;
            a[i] = i;
        }
    }

    public void union(int p, int q) {
        int rootp = root(p);
        int rootq = root(q);
        if (w[rootp] > w[rootq]) {
            a[rootq] = rootp;
            w[rootp] += w[rootq];
        } else {
            a[rootp] = rootq;
            w[rootq] += w[rootp];
        }
    }

    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    private int root(int p) {
        while (a[p] != p)
            p = a[p];
        return p;
    }

}
