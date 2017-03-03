package applications;

import datastructures.RandomizedQueue;
import edu.princeton.cs.introcs.StdIn;

/**
 * Created by Moe on 2/27/17.
 */
public class Permutation {

    /**
     * This program takes in as a command line argument an integer (k) and a sequence of string
     * characters and prints out (k) strings chosen at random from the input
     *
     * @param args an integer followed by string sequence separated by white space
     */
    public static void main(String[] args) {
        final int K = Integer.parseInt(args[0]);
        RandomizedQueue<String> q = new RandomizedQueue<>();
        while (!StdIn.isEmpty())
            q.enqueue(StdIn.readString());
        if (K > q.size()) throw new IllegalArgumentException();
        for (int i = 0; i < K; i++)
            System.out.println(q.dequeue());
    }
}