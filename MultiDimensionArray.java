package fortinet;

public class MultiDimensionArray {
	// This is a provided function, Assume it works
	public static Long getValue(int... indexOfDimension) {
		long value = 0;
		// ...
		return (long) value;
	}

	// time complexity: O(n) n-->total elements
	// space complexity:O(1)
	public static Long sum(MultiDimensionArray mArray, int[] lengthOfDeminsion) {

		if (lengthOfDeminsion == null || lengthOfDeminsion.length == 0) {
			return (long) 0;
		}

		int totalElements = 1;
		int n = lengthOfDeminsion.length;
		// contains index for each dimension in the mArray
		int[] currIndex = new int[n];
		long sum = (long) 0.0;
		// Calculate the total elements in the array
		for (int i = 0; i < n; i++) {
			totalElements = totalElements * lengthOfDeminsion[i];
		}

		// Loop through all the elements
		for (int i = 0; i < totalElements; i++) {
			for (int j = 0; j < n; j++) {
				// when ever we reach max in a dimension reset it to 0
				if (currIndex[j] >= lengthOfDeminsion[j]) {
					currIndex[j] = 0;
				} else {
					currIndex[j]++;// We incremented so just break
					break;
				}
			}
			sum = sum + getValue(currIndex[n]);
		}
		return sum;
	}

}
