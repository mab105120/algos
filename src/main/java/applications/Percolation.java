package applications;

import com.bourjm.algos.WeightedQuickUnion;

/**
 * Created by Moe on 2/18/17.
 */
public class Percolation {

    private int[] status;
    private WeightedQuickUnion sites;
    private final int n;
    private int openSites;

    public Percolation(int n) {
        this.n = n;
        int numberOfSites = n * n + 2; // Grid sites + 2 "master" sites
        this.status = new int[numberOfSites];
        sites = new WeightedQuickUnion(numberOfSites);
        connectMasterSites();
    }

    public void open(int row, int col) {
        if (!isOpen(row, col)) {
            int siteId = getSiteId(row, col);
            openSites++;
            status[siteId] = 1;
            connectWithSiteAbove(row, col);
            connectWithSiteBelow(row, col);
            connectWithLeftSite(row, col);
            connectWithRightSite(row, col);
        }
    }

    public boolean isOpen(int row, int col) {
        return status[getSiteId(row, col)] != 0;
    }

    public boolean isFull(int row, int col) {
        return true;
    }

    public int numberOfOpenSites() {
        return openSites;
    }

    public boolean percolates() {
        return sites.isConnected(0, (n * n) + 1);
    }

    private void connectMasterSites() {
        for (int i = 1; i <= n; i++)
            sites.union(0, i);
        for (int i = getSiteId(n, 1); i <= getSiteId(n, n); i++)
            sites.union((n * n) + 1, i);
    }

    private int getSiteId(int row, int col) {
        if (row <= 0 || row > n || col <= 0 || col > n)
            throw new IndexOutOfBoundsException();
        return (n * (row - 1)) + col;
    }

    private void connectWithSiteAbove(int row, int col) {
        if (row != 1 && isOpen(row - 1, col))
            if (!sites.isConnected(getSiteId(row, col), getSiteId(row - 1, col)))
                sites.union(getSiteId(row, col), getSiteId(row - 1, col));
    }

    private void connectWithSiteBelow(int row, int col) {
        if (row != n && isOpen(row + 1, col))
            if (!sites.isConnected(getSiteId(row, col), getSiteId(row + 1, col)))
                sites.union(getSiteId(row, col), getSiteId(row + 1, col));
    }

    private void connectWithRightSite(int row, int col) {
        if (col != n && isOpen(row, col + 1))
            if (!sites.isConnected(getSiteId(row, col), getSiteId(row, col + 1)))
                sites.union(getSiteId(row, col), getSiteId(row, col + 1));
    }

    private void connectWithLeftSite(int row, int col) {
        if (col != 1 && isOpen(row, col - 1))
            if (!sites.isConnected(getSiteId(row, col), getSiteId(row, col - 1)))
                sites.union(getSiteId(row, col), getSiteId(row, col - 1));
    }
}