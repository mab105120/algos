package applications;

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

/**
 * Created by Moe on 2/19/17.
 */
public class PercolationStats {

    private double[] scores;
    private final int trials;

    public PercolationStats(int n, int trials) {
        this.trials = trials;
        scores = new double[trials];
        final int TOTAL_SITES = n * n;
        for (int i = 0; i < trials; i++) {
            Percolation p = new Percolation(n);
            while (!p.percolates())
                p.open(StdRandom.uniform(1, n + 1), StdRandom.uniform(1, n + 1));
            scores[i] = (double) p.numberOfOpenSites() / TOTAL_SITES;
        }
    }

    public double mean() {
        return StdStats.mean(scores);
    }

    public double stddev() {
        return StdStats.stddev(scores);
    }

    public double confidenceLo() {
        return mean() - ((1.96 * stddev()) / Math.sqrt(trials));
    }

    public double confidenceHi() {
        return mean() + ((1.96 * stddev()) / Math.sqrt(trials));
    }

    public static void main(String[] args) {
        PercolationStats stats = new PercolationStats(200, 10000);
        System.out.println("mean: " + stats.mean());
        System.out.println("Stddev: " + stats.stddev());
        System.out.println("95% confidence interval [" + stats.confidenceLo() + "," + stats.confidenceHi() + "]");
    }
}