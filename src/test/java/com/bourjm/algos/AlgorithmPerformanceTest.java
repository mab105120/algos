package com.bourjm.algos;

import java.util.Random;

import org.junit.Test;

import sorting.QuickSort;

public class AlgorithmPerformanceTest {

	@Test
	public void testAlgorithmPerformance() {
		final int THRESHOLD = 100000;
		Double[] d = new Double[THRESHOLD];
		Random rand = new Random();
		for (int i = 0; i < THRESHOLD; i++)
			d[i] = rand.nextDouble();
		System.out.println(AlgoPerformance.measurePerformance(d, QuickSort::sort));
	}

}
