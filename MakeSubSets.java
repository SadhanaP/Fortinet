package fortinet;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MakeSubSets {

	private static boolean[] mark = new boolean[10000];

	private static boolean fill(List<Integer> item, int binsum, int n) {
		// Base Cases
		if (binsum == 0 && n >= 0) {
			return true;
		}
		if (n == 0) {
			return false;
		}

		// Exclude current item
		if (fill(item, binsum, n - 1)) {
			return true;
		}
		// Include current item
		else if (!mark[n - 1]) {

			mark[n - 1] = true;
			if (fill(item, binsum - item.get(n - 1), n - 1)) {
				return true;
			}
			mark[n - 1] = false;
		}
		return false;
	}

	private static boolean separate(List<Integer> item, int bins) {
		int n = item.size();

		if (n < bins)
			return false;
		if (bins == 1)
			return true;

		// Calculate total sum
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum = sum + item.get(i);
		}

		// Check whether total sum can be partitioned into bins/k equal sums
		int binsum = sum / bins;
		if (binsum * bins != sum) {
			return false;
		}

		// Fill all the bins one at a time
		while (--bins != 0) {
			if (fill(item, binsum, n) == false) {
				break;
			}
		}

		// Check whether all bins are filled
		if (bins == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(3);
		list.add(1);
		list.add(7);
		list.add(-1);
		list.add(6);
		int bins = 3;
		if (separate(list, bins)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}

	@Test
	public void testSeparate() {
		List<Integer> inputList = new ArrayList<Integer>();
		assertEquals(
				" empty input list, size less than the number of bins should return false",
				false, separate(inputList, 2));
		inputList.add(1);
		assertEquals("if number of bins is 1 it should return true", true,
				separate(inputList, 1));
		inputList.add(2);
		inputList.add(4);
		inputList.add(5);
		inputList.add(3);
		inputList.add(3);
		assertEquals(
				"should return true since sum of 18 can be divided into 3 bins",
				true, separate(inputList, 3));

	}
}
