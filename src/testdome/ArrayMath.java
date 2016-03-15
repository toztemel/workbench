package testdome;

import java.util.List;
import java.util.Arrays;

public class ArrayMath {
	public static double weightedMean(List<Integer> values, List<Integer> weights) {
		
		if (illegal(values, weights))
			throw new IllegalArgumentException();
		
		double sum = 0;
		double sumWeights = 0;
		for (int i = 0; i < values.size(); i++) {
			Integer i1 = values.get(i);
			Integer i2 = weights.get(i);
			Double d1 = new Double(i1);
			Double d2 = new Double(i2);
			sum += d1 * d2;
			sumWeights += weights.get(i);
		}

		return sum / sumWeights;
	}

	private static boolean illegal(List<Integer> values, List<Integer> weights) {
		if (values == null)
			return true;
		if (weights == null)
			return true;
		
		if (values.size() != weights.size())
			return true;
		
		return false;
	}

	public static void main(String[] args) {
		List<Integer> a = Arrays.asList(new Integer[] { Integer.MAX_VALUE, 6 });
		List<Integer> b = Arrays.asList(new Integer[] { 4, 2 });

		System.out.println(weightedMean(a, b));
	}
}