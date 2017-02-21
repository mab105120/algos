package applications;

import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

/**
 * Created by Moe on 2/19/17.
 */
public class PercolationStats {

    private double[] scores; // Ratio of open sites to total sites per trial
    private final int trials; // number of simulation trials

    /**
     * Monte-Carlo simulation of the percolation problem. Open random sites repeatedly until
     * the system peculates.
     *
     * @param n      grid size
     * @param trials number of simulation trials
     */
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

    /**
     * The average site vacancy probability
     *
     * @return average site vacancy probability
     */
    public double mean() {
        return StdStats.mean(scores);
    }

    /**
     * Standard deviation of site vacancy probability
     *
     * @return Standard deviation of site vacancy probability
     */
    public double stddev() {
        return StdStats.stddev(scores);
    }

    /**
     * Lower 95%-estimate of site vacancy probability
     *
     * @return Lower 95%-estimate of site vacancy probability
     */
    public double confidenceLo() {
        return mean() - ((1.96 * stddev()) / Math.sqrt(trials));
    }

    /**
     * Upper 95%-estimate of site vacancy probability
     *
     * @return Upper 95%-estimate of site vacancy probability
     */
    public double confidenceHi() {
        return mean() + ((1.96 * stddev()) / Math.sqrt(trials));
    }

    public static void main(String[] args) {
        final int gridSize = Integer.parseInt(args[0]);
        final int trials = Integer.parseInt(args[1]);
        PercolationStats stats = new PercolationStats(gridSize, trials);
        System.out.println("mean: " + stats.mean());
        System.out.println("Stddev: " + stats.stddev());
        System.out.println("95% confidence interval [" + stats.confidenceLo() + "," + stats.confidenceHi() + "]");
    }
}