package com.bourjm.algos;

import java.util.function.Consumer;

public class AlgoPerformance {

	public static <T extends Comparable<T>> double measurePerformance(T[] t, Consumer<T[]> sort) {
		double now = System.currentTimeMillis();
		sort.accept(t);
		return (System.currentTimeMillis() - now) / 1000;
	}
}