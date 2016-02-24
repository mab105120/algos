package com.bourjm.algos;

import org.apache.commons.math3.distribution.UniformRealDistribution;

public class BuffonNeedle {

	public static void main(String[] args) {
		estimatePi(2,1,10000000);
	}
	
	private static double getProbability(double d, double l, double iterations) {
		assert (d > l);
		UniformRealDistribution thetaURD = new UniformRealDistribution(0,
				Math.PI / 2);
		UniformRealDistribution xURD = new UniformRealDistribution(0, d / 2);
		double count = 0;
		for (int i = 0; i < iterations; i++) {
			double x = xURD.sample();
			double theta = thetaURD.sample();
			if (x < Math.sin(theta) * l / 2)
				count++;
		}
		return count / iterations;
	}

	public static void estimatePi(double d, double l, double iterations) {
		System.out.println("-----------");
		double prob = getProbability(d, l, iterations);
		System.out.println("Probability of intersection: " + prob);
		System.out.println("Estimated PI: " + ((2 * l) / (d * prob)));
		System.out.println("-----------");
	}
}