package applications;

import com.bourjm.algos.WeightedQuickUnion;

/**
 * Created by Moe on 2/18/17.
 */
public class Percolation {

    private int[] status; // holds the status of each site (0 = blocked, non-0 = open)
    private WeightedQuickUnion sites; // quick-union to track which sites are connected
    private final int n; // grid dimension (n x n)
    private int openSites; // number of open sites in the grid

    /**
     * Creates a percolation grid (n x n) with two master sites: one of top of the grid, another at the bottom.
     * Connects all the sites in the top row to the top master site; all the sites in the bottom row to the
     * bottom master site.
     * throws IllegalArgumentException if n < 0
     *
     * @param n grid dimension
     */
    public Percolation(int n) {
        if (n < 0) throw new IllegalArgumentException();
        this.n = n;
        int numberOfSites = n * n + 2; // Grid sites + 2 "master" sites
        this.status = new int[numberOfSites];
        sites = new WeightedQuickUnion(numberOfSites);
        connectMasterSites();
    }

    /**
     * Opens a site if not already open. Connects the open site with all open neighboring sites.
     *
     * @param row row of the site to open
     * @param col col of the site to open
     */
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

    /**
     * Checks if site is open.
     *
     * @param row site row
     * @param col site column
     * @return True if site is open, false otherwise.
     */
    public boolean isOpen(int row, int col) {
        return status[getSiteId(row, col)] != 0;
    }

    /**
     * Checks if site is connected to the top row.
     *
     * @param row site row
     * @param col site column
     * @return True if site is connected to top row, false otherwise
     */
    public boolean isFull(int row, int col) {
        return sites.isConnected(0, getSiteId(row, col));
    }

    /**
     * Checks number of open sites
     *
     * @return total open sites
     */
    public int numberOfOpenSites() {
        return openSites;
    }

    /**
     * Checks if any of the bottom sites is connected to any of the top sites.
     *
     * @return True is the system percolates, false otherwises
     */
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
            sites.union(getSiteId(row, col), getSiteId(row - 1, col));
    }

    private void connectWithSiteBelow(int row, int col) {
        if (row != n && isOpen(row + 1, col))
            sites.union(getSiteId(row, col), getSiteId(row + 1, col));
    }

    private void connectWithRightSite(int row, int col) {
        if (col != n && isOpen(row, col + 1))
            sites.union(getSiteId(row, col), getSiteId(row, col + 1));
    }

    private void connectWithLeftSite(int row, int col) {
        if (col != 1 && isOpen(row, col - 1))
            sites.union(getSiteId(row, col), getSiteId(row, col - 1));
    }
}