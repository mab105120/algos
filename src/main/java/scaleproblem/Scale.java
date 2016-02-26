package scaleproblem;

import java.util.List;

public class Scale {

	/*
	 * Algorithm to solve the scale problem: 
	 * Given N objects, all with same weight except for one, and a balance scale, what is the least 
	 * amount of scale accesses required to find the odd object.
	 * 
	 * The below algorithm solves the problem in O(log N) when N is a factor of 2.
	 */
	
	public static <T extends Weighable> T getHeaviest(List<T> lt) {
		T heaviest = null;
		int lo = 0, hi = lt.size(), mid = lo + (lo + hi + 1) / 2;
		double d1 = weigh(lt.subList(lo, mid)), d2 = weigh(lt.subList(mid,
				hi));
		if (d1 > d2) {
			if (lt.size() <= 2)
				return lt.get(0);
			heaviest = getHeaviest(lt.subList(lo, mid));
		} else if (d1 < d2) {
			if (lt.size() == 2)
				return lt.get(1);
			heaviest = getHeaviest(lt.subList(mid, hi));
		}
		return heaviest;
	}

	protected static <T extends Weighable> double weigh(List<T> lt) {
		double total = 0;
		for (T t : lt)
			total += t.getWeight();
		return total;
	}

}
